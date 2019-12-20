package com.hy.crm.bo;

import org.springframework.format.annotation.DateTimeFormat;

public class Busbo {
    //商机id
    private Integer nid;
    //商机名称
    private  String nname;
    //商机阶段
    private String stage;
    //预计成交金额
    private Integer perdictmoney;
    //商机负责人
    private  String principal;
    //最后跟单
    @DateTimeFormat(style = "yyy-MM-dd")
    private  String docudate;
    //讨论版

    public String getNname() {
        return nname;
    }

    public void setNname(String nname) {
        this.nname = nname;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public Integer getPerdictmoney() {
        return perdictmoney;
    }

    public void setPerdictmoney(Integer perdictmoney) {
        this.perdictmoney = perdictmoney;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getDocudate() {
        return docudate;
    }

    public void setDocudate(String docudate) {
        this.docudate = docudate;
    }
}
