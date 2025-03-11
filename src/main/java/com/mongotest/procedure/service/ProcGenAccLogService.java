package com.mongotest.procedure.service;

public interface ProcGenAccLogService {

    void procGenAccLog(String pymtNo, String processName, String errorMessage, String logType, String errorCode);
}
