package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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

    @TableField("regDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date regDate;

    @TableField("regClassify")
    private String regClassify;

    @TableField("regMany")
    private Double regMany;

    private String capital;

    @TableField("payment_term")
    private String paymentTerm;

    private String registrant;

    @TableField("relat_per")
    private String relatPer1;
    @TableField("relat_dept")
    private String relatDept;

    private String unit;

    @TableField("relat_cont")
    private String relatCont;
    @TableField("income_sta")
    private String incomeSta;

    @TableField("contId")
    private Integer contId;

    @TableField(exist = false)
    private ContractManagement contractManagement;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
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

    public String getRelatPer1() {
        return relatPer1;
    }

    public void setRelatPer1(String relatPer1) {
        this.relatPer1 = relatPer1;
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

    public ContractManagement getContractManagement() {
        return contractManagement;
    }

    public void setContractManagement(ContractManagement contractManagement) {
        this.contractManagement = contractManagement;
    }

    public Integer getContId() {
        return contId;
    }

    public void setContId(Integer contId) {
        this.contId = contId;
    }
}
