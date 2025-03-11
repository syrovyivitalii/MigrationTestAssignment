package com.mongotest.procedure.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "SAPS_LOG")
public class SapsLog {

    @Id
    private String id;

    @Field("PROCESS_NAME")
    private String processName;

    @Field("LOG_TIME")
    private Date logTime;

    @Field("LOG_TYPE")
    private String logType;

    @Field("LOG_DESCP")
    private String logDescp;

    @Field("LOG_CODE")
    private String logCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getLogDescp() {
        return logDescp;
    }

    public void setLogDescp(String logDescp) {
        this.logDescp = logDescp;
    }

    public String getLogCode() {
        return logCode;
    }

    public void setLogCode(String logCode) {
        this.logCode = logCode;
    }
}

