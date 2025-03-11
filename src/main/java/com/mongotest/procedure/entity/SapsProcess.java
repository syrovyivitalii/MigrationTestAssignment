package com.mongotest.procedure.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;


@Document(collection = "SAPS_PROCESS")
public class SapsProcess {

    @Id
    private String id;

    @Field("PROCESS_NAME")
    private String processName;

    @Field("LAST_END_DATE")
    private Date lastEndDate;

    @Field("LAST_RUN_STAT")
    private String lastRunStat;

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

    public Date getLastEndDate() {
        return lastEndDate;
    }

    public void setLastEndDate(Date lastEndDate) {
        this.lastEndDate = lastEndDate;
    }

    public String getLastRunStat() {
        return lastRunStat;
    }

    public void setLastRunStat(String lastRunStat) {
        this.lastRunStat = lastRunStat;
    }
}