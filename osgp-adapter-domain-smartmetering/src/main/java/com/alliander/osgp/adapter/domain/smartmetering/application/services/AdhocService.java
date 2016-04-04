/**
 * Copyright 2015 Smart Society Services B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package com.alliander.osgp.adapter.domain.smartmetering.application.services;

import ma.glasnost.orika.MapperFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alliander.osgp.adapter.domain.smartmetering.infra.jms.core.OsgpCoreRequestMessageSender;
import com.alliander.osgp.adapter.domain.smartmetering.infra.jms.ws.WebServiceResponseMessageSender;
import com.alliander.osgp.domain.core.entities.SmartMeter;
import com.alliander.osgp.domain.core.valueobjects.smartmetering.SmsDetails;
import com.alliander.osgp.dto.valueobjects.smartmetering.RetrieveConfigurationObjectsRequestDto;
import com.alliander.osgp.dto.valueobjects.smartmetering.SmsDetailsDto;
import com.alliander.osgp.dto.valueobjects.smartmetering.SynchronizeTimeRequestDto;
import com.alliander.osgp.shared.exceptionhandling.FunctionalException;
import com.alliander.osgp.shared.exceptionhandling.OsgpException;
import com.alliander.osgp.shared.infra.jms.DeviceMessageMetadata;
import com.alliander.osgp.shared.infra.jms.RequestMessage;
import com.alliander.osgp.shared.infra.jms.ResponseMessage;
import com.alliander.osgp.shared.infra.jms.ResponseMessageResultType;

@Service(value = "domainSmartMeteringAdhocService")
@Transactional(value = "transactionManager")
public class AdhocService {

    private static final String DEVICE_RESPONSE_NOT_OK_UNEXPECTED_EXCEPTION = "Device Response not ok. Unexpected Exception";

    private static final Logger LOGGER = LoggerFactory.getLogger(AdhocService.class);

    @Autowired
    @Qualifier(value = "domainSmartMeteringOutgoingOsgpCoreRequestMessageSender")
    private OsgpCoreRequestMessageSender osgpCoreRequestMessageSender;

    @Autowired
    private WebServiceResponseMessageSender webServiceResponseMessageSender;

    @Autowired
    private DomainHelperService domainHelperService;

    @Autowired
    private MapperFactory mapperFactory;

    public AdhocService() {
        // Parameterless constructor required for transactions...
    }

    public void synchronizeTime(
            final DeviceMessageMetadata deviceMessageMetadata,
            final com.alliander.osgp.domain.core.valueobjects.smartmetering.SynchronizeTimeRequest synchronizeTimeRequestValueObject)
            throws FunctionalException {

        LOGGER.debug("synchronizeTime for organisationIdentification: {} for deviceIdentification: {}",
                deviceMessageMetadata.getOrganisationIdentification(), deviceMessageMetadata.getDeviceIdentification());

        final SmartMeter smartMeteringDevice = this.domainHelperService.findSmartMeter(deviceMessageMetadata
                .getDeviceIdentification());

        final SynchronizeTimeRequestDto synchronizeTimeRequestDto = new SynchronizeTimeRequestDto(
                synchronizeTimeRequestValueObject.getDeviceIdentification());

        this.osgpCoreRequestMessageSender.send(new RequestMessage(deviceMessageMetadata.getCorrelationUid(),
                deviceMessageMetadata.getOrganisationIdentification(), deviceMessageMetadata.getDeviceIdentification(),
                smartMeteringDevice.getIpAddress(), synchronizeTimeRequestDto), deviceMessageMetadata.getMessageType(),
                deviceMessageMetadata.getMessagePriority());
    }

    public void handleSynchronizeTimeResponse(final DeviceMessageMetadata deviceMessageMetadata,
            final ResponseMessageResultType deviceResult, final OsgpException exception) {

        LOGGER.debug("handleSynchronizeTimeResponse for MessageType: {}", deviceMessageMetadata.getMessageType());

        ResponseMessageResultType result = deviceResult;
        if (exception != null) {
            LOGGER.error(DEVICE_RESPONSE_NOT_OK_UNEXPECTED_EXCEPTION, exception);
            result = ResponseMessageResultType.NOT_OK;
        }

        this.webServiceResponseMessageSender.send(new ResponseMessage(deviceMessageMetadata.getCorrelationUid(),
                deviceMessageMetadata.getOrganisationIdentification(), deviceMessageMetadata.getDeviceIdentification(),
                result, exception, null, deviceMessageMetadata.getMessagePriority()), deviceMessageMetadata
                .getMessageType());
    }

    public void getSmsDetails(final DeviceMessageMetadata deviceMessageMetadata, final SmsDetails smsDetailsValueObject)
            throws FunctionalException {

        LOGGER.debug("retrieve sms details request for organisationIdentification: {} for deviceIdentification: {}",
                deviceMessageMetadata.getOrganisationIdentification(), deviceMessageMetadata.getDeviceIdentification());

        final SmartMeter smartMeteringDevice = this.domainHelperService.findSmartMeter(deviceMessageMetadata
                .getDeviceIdentification());

        final SmsDetailsDto smsDetailsDto = this.mapperFactory.getMapperFacade().map(smsDetailsValueObject,
                SmsDetailsDto.class);

        this.osgpCoreRequestMessageSender.send(new RequestMessage(deviceMessageMetadata.getCorrelationUid(),
                deviceMessageMetadata.getOrganisationIdentification(), deviceMessageMetadata.getDeviceIdentification(),
                smartMeteringDevice.getIpAddress(), smsDetailsDto), deviceMessageMetadata.getMessageType(),
                deviceMessageMetadata.getMessagePriority());

    }

    public void handleGetSmsDetailsResponse(final DeviceMessageMetadata deviceMessageMetadata,
            final ResponseMessageResultType deviceResult, final OsgpException exception,
            final SmsDetailsDto smsDetailsDto) {

        LOGGER.debug("handleGetSmsDetailsResponse for MessageType: {}", deviceMessageMetadata.getMessageType());

        ResponseMessageResultType result = deviceResult;
        if (exception != null) {
            LOGGER.error(DEVICE_RESPONSE_NOT_OK_UNEXPECTED_EXCEPTION, exception);
            result = ResponseMessageResultType.NOT_OK;
        }

        final SmsDetails smsDetails = this.mapperFactory.getMapperFacade().map(smsDetailsDto, SmsDetails.class);

        this.webServiceResponseMessageSender.send(new ResponseMessage(deviceMessageMetadata.getCorrelationUid(),
                deviceMessageMetadata.getCorrelationUid(), deviceMessageMetadata.getDeviceIdentification(), result,
                exception, smsDetails, deviceMessageMetadata.getMessagePriority()), deviceMessageMetadata
                .getMessageType());
    }

    public void retrieveConfigurationObjects(final DeviceMessageMetadata deviceMessageMetadata,
            final com.alliander.osgp.domain.core.valueobjects.smartmetering.RetrieveConfigurationObjectsRequest request)
            throws FunctionalException {

        LOGGER.debug("retrieveConfigurationObjects for organisationIdentification: {} for deviceIdentification: {}",
                deviceMessageMetadata.getOrganisationIdentification(), deviceMessageMetadata.getDeviceIdentification());

        final SmartMeter smartMeteringDevice = this.domainHelperService.findSmartMeter(deviceMessageMetadata
                .getDeviceIdentification());

        final RetrieveConfigurationObjectsRequestDto requestDto = new RetrieveConfigurationObjectsRequestDto(
                request.getDeviceIdentification());

        this.osgpCoreRequestMessageSender.send(new RequestMessage(deviceMessageMetadata.getCorrelationUid(),
                deviceMessageMetadata.getOrganisationIdentification(), deviceMessageMetadata.getDeviceIdentification(),
                smartMeteringDevice.getIpAddress(), requestDto), deviceMessageMetadata.getMessageType(),
                deviceMessageMetadata.getMessagePriority());

    }

    public void handleRetrieveConfigurationObjectsResponse(final DeviceMessageMetadata deviceMessageMetadata,
            final ResponseMessageResultType deviceResult, final OsgpException exception, final String resultData) {

        LOGGER.debug("handleRetrieveConfigurationObjectsResponse for MessageType: {}",
                deviceMessageMetadata.getMessageType());

        ResponseMessageResultType result = deviceResult;
        if (exception != null) {
            LOGGER.error(DEVICE_RESPONSE_NOT_OK_UNEXPECTED_EXCEPTION, exception);
            result = ResponseMessageResultType.NOT_OK;
        }

        this.webServiceResponseMessageSender.send(new ResponseMessage(deviceMessageMetadata.getCorrelationUid(),
                deviceMessageMetadata.getCorrelationUid(), deviceMessageMetadata.getDeviceIdentification(), result,
                exception, resultData, deviceMessageMetadata.getMessagePriority()), deviceMessageMetadata
                .getMessageType());

    }
}
