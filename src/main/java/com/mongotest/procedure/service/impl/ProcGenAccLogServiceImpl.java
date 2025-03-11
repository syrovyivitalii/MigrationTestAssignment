package com.mongotest.procedure.service.impl;

import com.mongotest.procedure.service.ProcGenAccLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProcGenAccLogServiceImpl implements ProcGenAccLogService {

    private static final Logger logger = LoggerFactory.getLogger(ProcGenAccLogServiceImpl.class);

    @Override
    public void procGenAccLog(String pymtNo, String processName, String errorMessage, String logType, String errorCode) {
        logger.info("Stub called: procGenAccLog");
        logger.info("Parameters - pymtNo: {}, processName: {}, errorMessage: {}, logType: {}, errorCode: {}",
                pymtNo, processName, errorMessage, logType, errorCode);

        // TODO: Implement the actual logic for this procedure
    }
}