package com.mongotest.procedure.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "SAPS_PROCESS")
public class SapProcess {
    @Id
    private String id;

    @Field("PROCESS_NAME")
    private String processName;

    @Field("LAST_END_DATE")
    private LocalDateTime lastEndDate;

    @Field("LAST_RUN_STAT")
    private String lastRunStat;
}
