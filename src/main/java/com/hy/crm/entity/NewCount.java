package com.hy.crm.entity;

public class NewCount {
    private Double c;
    private String cc;
    private Double s;

    private String ss;

    @Override
    public String toString() {
        return "NewCount{" +
                "c=" + c +
                ", cc=" + cc +
                ", s=" + s +
                ", ss=" + ss +
                '}';
    }

    public Double getC() {
        return c;
    }

    public void setC(Double c) {
        this.c = c;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public Double getS() {
        return s;
    }

    public void setS(Double s) {
        this.s = s;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }
}
