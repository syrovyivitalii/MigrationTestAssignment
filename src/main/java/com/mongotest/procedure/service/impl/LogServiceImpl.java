package com.mongotest.procedure.service.impl;

import com.mongotest.procedure.entity.SapsLog;
import com.mongotest.procedure.repository.SapsLogRepository;
import com.mongotest.procedure.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private SapsLogRepository sapsLogRepository;

    @Override
    public void logError(String message, String vPROCESS_NAME) {
        SapsLog log = new SapsLog();
        log.setProcessName(vPROCESS_NAME);
        log.setLogTime(new Date());
        log.setLogType("E");
        log.setLogDescp(message);
        sapsLogRepository.save(log);
    }

    @Override
    public void logError(String message, String vPROCESS_NAME, Exception e) {
        SapsLog log = new SapsLog();
        log.setProcessName(vPROCESS_NAME);
        log.setLogTime(new Date());
        log.setLogType("E");
        log.setLogDescp(message + "; Error: " + e.getMessage());
        sapsLogRepository.save(log);
    }
}
