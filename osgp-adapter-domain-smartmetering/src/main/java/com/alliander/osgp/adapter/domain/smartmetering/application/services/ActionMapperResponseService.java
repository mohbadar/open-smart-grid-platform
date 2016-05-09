/**
 * Copyright 2016 Smart Society Services B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package com.alliander.osgp.adapter.domain.smartmetering.application.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import ma.glasnost.orika.impl.ConfigurableMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.alliander.osgp.adapter.domain.smartmetering.application.mapping.CommonMapper;
import com.alliander.osgp.adapter.domain.smartmetering.application.mapping.ConfigurationMapper;
import com.alliander.osgp.adapter.domain.smartmetering.application.mapping.ManagementMapper;
import com.alliander.osgp.adapter.domain.smartmetering.application.mapping.MonitoringMapper;
import com.alliander.osgp.domain.core.valueobjects.smartmetering.ActionResponse;
import com.alliander.osgp.domain.core.valueobjects.smartmetering.AdministrativeStatusTypeResponse;
import com.alliander.osgp.domain.core.valueobjects.smartmetering.AlarmRegister;
import com.alliander.osgp.domain.core.valueobjects.smartmetering.AssociationLnObjectsResponseData;
import com.alliander.osgp.domain.core.valueobjects.smartmetering.BundleMessagesResponse;
import com.alliander.osgp.domain.core.valueobjects.smartmetering.EventMessagesResponse;
import com.alliander.osgp.domain.core.valueobjects.smartmetering.FirmwareVersionResponse;
import com.alliander.osgp.domain.core.valueobjects.smartmetering.GetConfigurationResponse;
import com.alliander.osgp.domain.core.valueobjects.smartmetering.MeterReads;
import com.alliander.osgp.domain.core.valueobjects.smartmetering.MeterReadsGas;
import com.alliander.osgp.domain.core.valueobjects.smartmetering.PeriodicMeterReadsContainer;
import com.alliander.osgp.domain.core.valueobjects.smartmetering.PeriodicMeterReadsContainerGas;
import com.alliander.osgp.dto.valueobjects.smartmetering.ActionResponseDto;
import com.alliander.osgp.dto.valueobjects.smartmetering.AdministrativeStatusTypeResponseDto;
import com.alliander.osgp.dto.valueobjects.smartmetering.AlarmRegisterResponseDto;
import com.alliander.osgp.dto.valueobjects.smartmetering.AssociationLnObjectsResponseDto;
import com.alliander.osgp.dto.valueobjects.smartmetering.BundleMessagesResponseDto;
import com.alliander.osgp.dto.valueobjects.smartmetering.EventMessageDataResponseDto;
import com.alliander.osgp.dto.valueobjects.smartmetering.FirmwareVersionResponseDto;
import com.alliander.osgp.dto.valueobjects.smartmetering.GetConfigurationResponseDto;
import com.alliander.osgp.dto.valueobjects.smartmetering.MeterReadsResponseDto;
import com.alliander.osgp.dto.valueobjects.smartmetering.MeterReadsGasResponseDto;
import com.alliander.osgp.dto.valueobjects.smartmetering.PeriodicMeterReadsResponseDto;
import com.alliander.osgp.dto.valueobjects.smartmetering.PeriodicMeterReadGasResponseDto;
import com.alliander.osgp.shared.exceptionhandling.ComponentType;
import com.alliander.osgp.shared.exceptionhandling.FunctionalException;
import com.alliander.osgp.shared.exceptionhandling.FunctionalExceptionType;

@Service(value = "domainSmartMeteringActionMapperResponseService")
@Validated
public class ActionMapperResponseService {

    @Autowired
    private ManagementMapper managementMapper;

    @Autowired
    private ConfigurationMapper configurationMapper;

    @Autowired
    private MonitoringMapper monitoringMapper;

    @Autowired
    private CommonMapper commonMapper;

    /**
     * Specifies which mapper to use for the DTO class received.
     */
    private static Map<Class<? extends ActionResponseDto>, ConfigurableMapper> classToMapperMap = new HashMap<>();

    @PostConstruct
    private void postConstruct() {
        classToMapperMap.put(EventMessageDataResponseDto.class, this.managementMapper);
        classToMapperMap.put(MeterReadsResponseDto.class, this.monitoringMapper);
        classToMapperMap.put(MeterReadsGasResponseDto.class, this.monitoringMapper);
        classToMapperMap.put(ActionResponseDto.class, this.commonMapper);
        classToMapperMap.put(AlarmRegisterResponseDto.class, this.commonMapper);
        classToMapperMap.put(AdministrativeStatusTypeResponseDto.class, this.configurationMapper);
        classToMapperMap.put(PeriodicMeterReadsResponseDto.class, this.monitoringMapper);
        classToMapperMap.put(PeriodicMeterReadGasResponseDto.class, this.monitoringMapper);
        classToMapperMap.put(GetConfigurationResponseDto.class, this.configurationMapper);
        classToMapperMap.put(FirmwareVersionResponseDto.class, this.configurationMapper);
        classToMapperMap.put(AssociationLnObjectsResponseDto.class, this.commonMapper);
    }

    /**
     * Specifies to which core value object the DTO object needs to be mapped.
     */
    private static Map<Class<? extends ActionResponseDto>, Class<? extends ActionResponse>> classMap = new HashMap<>();
    static {
        classMap.put(EventMessageDataResponseDto.class, EventMessagesResponse.class);
        classMap.put(MeterReadsResponseDto.class, MeterReads.class);
        classMap.put(MeterReadsGasResponseDto.class, MeterReadsGas.class);
        classMap.put(ActionResponseDto.class, ActionResponse.class);
        classMap.put(AlarmRegisterResponseDto.class, AlarmRegister.class);
        classMap.put(AdministrativeStatusTypeResponseDto.class, AdministrativeStatusTypeResponse.class);
        classMap.put(PeriodicMeterReadsResponseDto.class, PeriodicMeterReadsContainer.class);
        classMap.put(PeriodicMeterReadGasResponseDto.class, PeriodicMeterReadsContainerGas.class);
        classMap.put(GetConfigurationResponseDto.class, GetConfigurationResponse.class);
        classMap.put(FirmwareVersionResponseDto.class, FirmwareVersionResponse.class);
        classMap.put(AssociationLnObjectsResponseDto.class, AssociationLnObjectsResponseData.class);
    }

    public BundleMessagesResponse mapAllActions(
            final BundleMessagesResponseDto bundleResponseMessageDataContainerDto)
            throws FunctionalException {

        final List<ActionResponse> actionResponseList = new ArrayList<ActionResponse>();

        for (final ActionResponseDto action : bundleResponseMessageDataContainerDto.getActionValueObjectResponseDto()) {

            final ConfigurableMapper mapper = this.getMapper(action);
            final Class<? extends ActionResponse> clazz = this.getClazz(action);
            final ActionResponse actionValueResponseObject = this.doMap(action, mapper, clazz);

            actionResponseList.add(actionValueResponseObject);
        }

        return new BundleMessagesResponse(actionResponseList);

    }

    private ActionResponse doMap(final ActionResponseDto action, final ConfigurableMapper mapper,
            final Class<? extends ActionResponse> clazz) throws FunctionalException {
        final ActionResponse actionValueResponseObject = mapper.map(action, clazz);

        if (actionValueResponseObject == null) {
            throw new FunctionalException(FunctionalExceptionType.UNSUPPORTED_DEVICE_ACTION,
                    ComponentType.DOMAIN_SMART_METERING, new RuntimeException(
                            "No Action Value Response Object for Action Value Response DTO Object of class: "
                                    + action.getClass().getName()));
        }
        return actionValueResponseObject;
    }

    private Class<? extends ActionResponse> getClazz(final ActionResponseDto action) throws FunctionalException {
        final Class<? extends ActionResponse> clazz = classMap.get(action.getClass());

        if (clazz == null) {
            throw new FunctionalException(FunctionalExceptionType.UNSUPPORTED_DEVICE_ACTION,
                    ComponentType.DOMAIN_SMART_METERING, new RuntimeException(
                            "No Action Value Response Object class for Action Value Response DTO Object class: "
                                    + action.getClass().getName()));
        }
        return clazz;
    }

    private ConfigurableMapper getMapper(final ActionResponseDto action) throws FunctionalException {
        final ConfigurableMapper mapper = classToMapperMap.get(action.getClass());

        if (mapper == null) {
            throw new FunctionalException(FunctionalExceptionType.UNSUPPORTED_DEVICE_ACTION,
                    ComponentType.DOMAIN_SMART_METERING, new RuntimeException(
                            "No mapper for Action Value Response DTO Object class: " + action.getClass().getName()));
        }
        return mapper;
    }
}
