/**
 * Copyright 2015 Smart Society Services B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package com.alliander.osgp.domain.core.valueobjects.smartmetering;

import java.util.Date;

public class ActualMeterReadsGas extends MeterReadsGas implements UnitResponse {

    private static final long serialVersionUID = 4052150124072820551L;

    public ActualMeterReadsGas(final Date logTime, final long consumption, final Date captureTime) {
        super(logTime, consumption, captureTime);
    }

    @Override
    public final OsgpUnit getOsgpUnit() {
        return OsgpUnit.M3;
    }

}
