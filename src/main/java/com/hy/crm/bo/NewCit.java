package com.hy.crm.bo;

public class NewCit {
    //客户id
    private Integer cid;
    //客户名称
    private  String customername;
    //商机数
    private Integer buscount;
    //预计成交金额
    private Integer perdictmoney;
    //合同数
    private Integer conttract;
    //合同金额
    private  Integer contMany;
   //回款额
    private  double retmoney;
    //售后服务数
    private Integer contafter;
    //服务均分
    private double avgafter;
    private Integer nid;
    private String classif;

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getBuscount() {
        return buscount;
    }

    public void setBuscount(Integer buscount) {
        this.buscount = buscount;
    }

    public Integer getConttract() {
        return conttract;
    }

    public void setConttract(Integer conttract) {
        this.conttract = conttract;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public Integer getContMany() {
        return contMany;
    }

    public void setContMany(Integer contMany) {
        this.contMany = contMany;
    }

    public double getRetmoney() {
        return retmoney;
    }

    public void setRetmoney(double retmoney) {
        this.retmoney = retmoney;
    }

    public Integer getContafter() {
        return contafter;
    }

    public void setContafter(Integer contafter) {
        this.contafter = contafter;
    }

    public double getAvgafter() {
        return avgafter;
    }

    public void setAvgafter(double avgafter) {
        this.avgafter = avgafter;
    }

    public Integer getPerdictmoney() {
        return perdictmoney;
    }

    public String getClassif() {
        return classif;
    }

    public void setClassif(String classif) {
        this.classif = classif;
    }

    public void setPerdictmoney(Integer perdictmoney) {
        this.perdictmoney = perdictmoney;
    }

    @Override
    public String toString() {
        return "NewCit{" +
                "cid=" + cid +
                ", customername='" + customername + '\'' +
                ", buscount=" + buscount +
                ", perdictmoney=" + perdictmoney +
                ", conttract=" + conttract +
                ", contMany=" + contMany +
                ", retmoney=" + retmoney +
                ", contafter=" + contafter +
                ", avgafter=" + avgafter +
                ", nid=" + nid +
                ", classif='" + classif + '\'' +
                '}';
    }
}

