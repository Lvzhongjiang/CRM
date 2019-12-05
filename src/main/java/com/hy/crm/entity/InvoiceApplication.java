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
public class InvoiceApplication  {

    private static final long serialVersionUID = 1L;

    @TableId(value = "inId", type = IdType.AUTO)
    private Integer inId;

    @TableField("alName")
    private String alName;

    @TableField("affDept")
    private String affDept;

    @TableField("alDate")
    private String alDate;

    private String techTerm;

    private String unit;

    private String relatCont;

    @TableField("inKind")
    private String inKind;

    private String regNumber;

    @TableField("bankName_Id")
    private String banknameId;

    private String addPhone;

    @TableField("inAmount")
    private Double inAmount;

    private String caAmount;

    @TableField("inDate")
    private String inDate;

    @TableField("inNumber")
    private String inNumber;

    private String accessory;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getInId() {
        return inId;
    }

    public void setInId(Integer inId) {
        this.inId = inId;
    }

    public String getAlName() {
        return alName;
    }

    public void setAlName(String alName) {
        this.alName = alName;
    }

    public String getAffDept() {
        return affDept;
    }

    public void setAffDept(String affDept) {
        this.affDept = affDept;
    }

    public String getAlDate() {
        return alDate;
    }

    public void setAlDate(String alDate) {
        this.alDate = alDate;
    }

    public String getTechTerm() {
        return techTerm;
    }

    public void setTechTerm(String techTerm) {
        this.techTerm = techTerm;
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

    public String getInKind() {
        return inKind;
    }

    public void setInKind(String inKind) {
        this.inKind = inKind;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getBanknameId() {
        return banknameId;
    }

    public void setBanknameId(String banknameId) {
        this.banknameId = banknameId;
    }

    public String getAddPhone() {
        return addPhone;
    }

    public void setAddPhone(String addPhone) {
        this.addPhone = addPhone;
    }

    public Double getInAmount() {
        return inAmount;
    }

    public void setInAmount(Double inAmount) {
        this.inAmount = inAmount;
    }

    public String getCaAmount() {
        return caAmount;
    }

    public void setCaAmount(String caAmount) {
        this.caAmount = caAmount;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getInNumber() {
        return inNumber;
    }

    public void setInNumber(String inNumber) {
        this.inNumber = inNumber;
    }

    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }
}
