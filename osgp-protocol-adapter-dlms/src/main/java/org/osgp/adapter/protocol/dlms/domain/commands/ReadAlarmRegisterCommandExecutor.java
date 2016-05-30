/**
 * Copyright 2015 Smart Society Services B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.osgp.adapter.protocol.dlms.domain.commands;

import java.io.IOException;
import java.util.Set;

import org.openmuc.jdlms.AttributeAddress;
import org.openmuc.jdlms.DlmsConnection;
import org.openmuc.jdlms.GetResult;
import org.openmuc.jdlms.ObisCode;
import org.openmuc.jdlms.datatypes.DataObject;
import org.osgp.adapter.protocol.dlms.domain.entities.DlmsDevice;
import org.osgp.adapter.protocol.dlms.exceptions.ConnectionException;
import org.osgp.adapter.protocol.dlms.exceptions.ProtocolAdapterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alliander.osgp.dto.valueobjects.smartmetering.AlarmRegisterResponseDto;
import com.alliander.osgp.dto.valueobjects.smartmetering.AlarmTypeDto;
import com.alliander.osgp.dto.valueobjects.smartmetering.ReadAlarmRegisterRequestDto;

@Component
public class ReadAlarmRegisterCommandExecutor implements CommandExecutor<ReadAlarmRegisterRequestDto, AlarmRegisterResponseDto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadAlarmRegisterCommandExecutor.class);

    private static final int CLASS_ID = 1;
    private static final ObisCode OBIS_CODE = new ObisCode("0.0.97.98.0.255");
    private static final int ATTRIBUTE_ID = 2;

    @Autowired
    private AlarmHelperService alarmHelperService;

    @Override
    public AlarmRegisterResponseDto execute(final DlmsConnection conn, final DlmsDevice device,
            final ReadAlarmRegisterRequestDto object) throws ProtocolAdapterException {
        return new AlarmRegisterResponseDto(this.retrieveAlarmRegister(conn));
    }

    private Set<AlarmTypeDto> retrieveAlarmRegister(final DlmsConnection conn) throws ProtocolAdapterException {

        final AttributeAddress alarmRegisterValue = new AttributeAddress(CLASS_ID, OBIS_CODE, ATTRIBUTE_ID);

        GetResult getResult=null;
        try {
            getResult = conn.get(alarmRegisterValue);
        } catch (IOException e) {
            throw new ConnectionException(e);
        }

        if (getResult==null) {
            throw new ProtocolAdapterException("No GetResult received while retrieving alarm register.");
        }

        final DataObject resultData = getResult.getResultData();
        if (resultData != null && resultData.isNumber()) {
            return this.alarmHelperService.toAlarmTypes((Long) getResult.getResultData().getValue());
        } else {
            LOGGER.error("Result: {} --> {}", getResult.getResultCode().name(), getResult.getResultData());
            throw new ProtocolAdapterException("Invalid register value received from the meter.");
        }
    }
}
