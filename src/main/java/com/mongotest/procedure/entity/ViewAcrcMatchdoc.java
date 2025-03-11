package com.mongotest.procedure.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "VIEW_ACRC_MATCHDOC")
public class ViewAcrcMatchdoc {

    @Id
    private String id;

    @Field("MATCH_DOC")
    private String matchDoc;

    @Field("MATCH_TYPE")
    private String matchType;

    @Field("POL_NO")
    private String polNo;

    @Field("PROD_TYPE")
    private String prodType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMatchDoc() {
        return matchDoc;
    }

    public void setMatchDoc(String matchDoc) {
        this.matchDoc = matchDoc;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getPolNo() {
        return polNo;
    }

    public void setPolNo(String polNo) {
        this.polNo = polNo;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }
}
