package com.abacus.school.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactionLogger {
    private static final Logger payloadLogger = LoggerFactory.getLogger("payload");
    private static final Logger errorLogger = LoggerFactory.getLogger("error");
    private static final Logger performanceLogger = LoggerFactory.getLogger("performance");

    /**
     * this constructor is not being called externally anywhere
     */
    private TransactionLogger(){}

    public static Logger getPayloadLogger() {
        return payloadLogger;
    }

    public static Logger getErrorLogger() {
        return errorLogger;
    }

    public static Logger getPerformanceLogger() {
        return performanceLogger;
    }
}
