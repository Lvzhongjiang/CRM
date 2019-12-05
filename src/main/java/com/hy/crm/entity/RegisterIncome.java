package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Data
public class RegisterIncome{

    private static final long serialVersionUID = 1L;

    @TableId(value = "regId", type = IdType.AUTO)
    private Integer regId;

    @TableField("regName")
    private String regName;

    @TableField("regClassify")
    private String regClassify;

    @TableField("regMany")
    private Double regMany;

    private String capital;

    private String paymentTerm;

    private String registrant;

    private String relatPer;

    private String relatDept;

    private String unit;

    private String relatCont;

    private String incomeSta;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    public String getRegName() {
        return regName;
    }

    public void setRegName(String regName) {
        this.regName = regName;
    }

    public String getRegClassify() {
        return regClassify;
    }

    public void setRegClassify(String regClassify) {
        this.regClassify = regClassify;
    }

    public Double getRegMany() {
        return regMany;
    }

    public void setRegMany(Double regMany) {
        this.regMany = regMany;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getPaymentTerm() {
        return paymentTerm;
    }

    public void setPaymentTerm(String paymentTerm) {
        this.paymentTerm = paymentTerm;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public String getRelatPer() {
        return relatPer;
    }

    public void setRelatPer(String relatPer) {
        this.relatPer = relatPer;
    }

    public String getRelatDept() {
        return relatDept;
    }

    public void setRelatDept(String relatDept) {
        this.relatDept = relatDept;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRelatCont() {
        return relatCont;
    }

    public void setRelatCont(String relatCont) {
        this.relatCont = relatCont;
    }

    public String getIncomeSta() {
        return incomeSta;
    }

    public void setIncomeSta(String incomeSta) {
        this.incomeSta = incomeSta;
    }
}
