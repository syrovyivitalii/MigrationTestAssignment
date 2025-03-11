package com.mongotest.procedure.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Getter
@Setter
@Document(collection = "ACRC_PYMT_UPLOAD")
public class AcrcPymtUpload {

    @Id
    private String id;

    @Field("PYMT_NO")
    private String pymtNo;

    @Field("MATCH_ADV_AMT")
    private BigDecimal matchAdvAmt;

    @Field("MATCH_AMT")
    private BigDecimal matchAmt;

    @Field("DEL_IND")
    private String delInd;
}