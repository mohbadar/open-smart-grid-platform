/**
 * Copyright 2015 Smart Society Services B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
package org.osgp.adapter.protocol.dlms.infra.messaging;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alliander.osgp.shared.infra.jms.RetryHeader;

@Component
public class RetryHeaderFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(RetryHeaderFactory.class);

    @Value("${core.retry.dlms.delay}")
    private int retryDelay;

    @Value("${core.retry.dlms.retries}")
    private int maximumRetries;

    @Value("${core.retry.dlms.backoff.multiplier}")
    private int backoffMultiplier;

    @Value("${core.retry.dlms.backoff.exponential}")
    private boolean exponentialBackoff;

    public RetryHeader createRetryHeader(final int retry) {
        final Calendar retryTime = Calendar.getInstance();
        retryTime.add(Calendar.MILLISECOND, this.calculateDelay(retry));

        LOGGER.info("Scheduling retry for {}.", retryTime.getTime());
        return new RetryHeader(retry, this.maximumRetries, retryTime.getTime());
    }

    public RetryHeader createEmtpyRetryHeader() {
        return new RetryHeader();
    }

    private int calculateDelay(final int retry) {
        int delay = this.retryDelay;
        if (this.exponentialBackoff) {
            final double exponent = Math.pow(this.backoffMultiplier, retry);
            delay *= exponent;
        }
        return delay;
    }
}
