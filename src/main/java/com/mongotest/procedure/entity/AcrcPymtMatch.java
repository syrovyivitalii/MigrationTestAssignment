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
@Document(collection = "ACRC_PYMT_MATCH")
public class AcrcPymtMatch {

    @Id
    private String id;

    @Field("PYMT_NO")
    private String pymtNo;

    @Field("MATCH_DOC")
    private String matchDoc;

    @Field("MATCH_TYPE")
    private String matchType;

    @Field("MATCH_ADV_AMT")
    private BigDecimal matchAdvAmt;

    @Field("MATCH_AMT")
    private BigDecimal matchAmt;

    @Field("PROD_TYPE")
    private String prodType;

    public void setId(String id) {
        this.id = id;
    }

    public void setPymtNo(String pymtNo) {
        this.pymtNo = pymtNo;
    }

    public void setMatchDoc(String matchDoc) {
        this.matchDoc = matchDoc;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public void setMatchAdvAmt(BigDecimal matchAdvAmt) {
        this.matchAdvAmt = matchAdvAmt;
    }

    public void setMatchAmt(BigDecimal matchAmt) {
        this.matchAmt = matchAmt;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }
}