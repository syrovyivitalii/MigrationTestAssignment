package com.mongotest.procedure.service;

public interface LogService {
    void logError(String message, String vPROCESS_NAME);

    void logError(String message, String vPROCESS_NAME, Exception e);
}
