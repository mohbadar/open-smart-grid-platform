/**
 * Copyright 2015 Smart Society Services B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.osgp.adapter.protocol.dlms.domain.commands;

import java.util.List;

import org.openmuc.jdlms.AttributeAddress;
import org.openmuc.jdlms.ClientConnection;
import org.openmuc.jdlms.GetResult;
import org.openmuc.jdlms.ObisCode;
import org.osgp.adapter.protocol.dlms.domain.entities.DlmsDevice;
import org.osgp.adapter.protocol.dlms.exceptions.ProtocolAdapterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alliander.osgp.dto.valueobjects.smartmetering.CosemObisCodeDto;
import com.alliander.osgp.dto.valueobjects.smartmetering.PushSetupAlarmDto;

@Component()
public class GetPushSetupAlarmCommandExecutor extends GetPushSetupCommandExecutor implements
CommandExecutor<Void, PushSetupAlarmDto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetPushSetupAlarmCommandExecutor.class);
    private static final ObisCode OBIS_CODE = new ObisCode("0.1.25.9.0.255");

    private static final AttributeAddress[] ATTRIBUTE_ADDRESSES = {
        new AttributeAddress(CLASS_ID, OBIS_CODE, ATTRIBUTE_ID_PUSH_OBJECT_LIST),
        new AttributeAddress(CLASS_ID, OBIS_CODE, ATTRIBUTE_ID_SEND_DESTINATION_AND_METHOD),
        new AttributeAddress(CLASS_ID, OBIS_CODE, ATTRIBUTE_ID_COMMUNICATION_WINDOW),
        new AttributeAddress(CLASS_ID, OBIS_CODE, ATTRIBUTE_ID_RANDOMISATION_START_INTERVAL),
        new AttributeAddress(CLASS_ID, OBIS_CODE, ATTRIBUTE_ID_NUMBER_OF_RETRIES),
        new AttributeAddress(CLASS_ID, OBIS_CODE, ATTRIBUTE_ID_REPETITION_DELAY) };

    @Autowired
    private DlmsHelperService dlmsHelperService;

    @Override
    public PushSetupAlarmDto execute(final ClientConnection conn, final DlmsDevice device, final Void useless)
            throws ProtocolAdapterException {

        LOGGER.info("Retrieving Push Setup Alarm");

        final List<GetResult> getResultList = this.dlmsHelperService.getWithList(conn, device, ATTRIBUTE_ADDRESSES);

        GetPushSetupCommandExecutor.checkResultList(getResultList, ATTRIBUTE_ADDRESSES);

        final PushSetupAlarmDto.Builder pushSetupAlarmBuilder = new PushSetupAlarmDto.Builder();
        pushSetupAlarmBuilder.logicalName(new CosemObisCodeDto(OBIS_CODE.bytes()));

        pushSetupAlarmBuilder.pushObjectList(this.dlmsHelperService.readListOfObjectDefinition(
                getResultList.get(INDEX_PUSH_OBJECT_LIST), "Push Object List"));

        pushSetupAlarmBuilder.sendDestinationAndMethod(this.dlmsHelperService.readSendDestinationAndMethod(
                getResultList.get(INDEX_SEND_DESTINATION_AND_METHOD), "Send Destination And Method"));

        pushSetupAlarmBuilder.communicationWindow(this.dlmsHelperService.readListOfWindowElement(
                getResultList.get(INDEX_COMMUNICATION_WINDOW), "Communication Window"));

        pushSetupAlarmBuilder.randomisationStartInterval(this.dlmsHelperService.readLongNotNull(
                getResultList.get(INDEX_RANDOMISATION_START_INTERVAL), "Randomisation Start Interval").intValue());

        pushSetupAlarmBuilder.numberOfRetries(this.dlmsHelperService.readLongNotNull(
                getResultList.get(INDEX_NUMBER_OF_RETRIES), "Number of Retries").intValue());

        pushSetupAlarmBuilder.repetitionDelay(this.dlmsHelperService.readLongNotNull(
                getResultList.get(INDEX_REPETITION_DELAY), "Repetition Delay").intValue());

        return pushSetupAlarmBuilder.build();
    }
}
