package com.mongotest.procedure.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "SAPS_LOG")
public class SapLog {
    @Id
    private String id;

    @Field("PROCESS_NAME")
    private String processName;

    @Field("LOG_TIME")
    private LocalDateTime logTime;

    @Field("LOG_TYPE")
    private String logType;

    @Field("LOG_DESCP")
    private String logDesc;

    @Field("LOG_CODE")
    private String logCode;
}
