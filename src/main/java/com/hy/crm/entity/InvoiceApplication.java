package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
public class InvoiceApplication {
    private static final long serialVersionUID = 1L;

    @TableId(value = "inId", type = IdType.AUTO)
    private Integer inId;

    private String motif;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    @TableField("detailedaddress")
    private String detailedaddress1;

    @TableField("alName")
    private String alName;

    @TableField("affDept")
    private String affDept;

    @TableField("alDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date alDate;

    @TableField("tech_term")
    private String techTerm1;

    private String unit;

    @TableField("inKind")
    private String inKind;

    @TableField("reg_number")
    private String regNumber;

    @TableField("bankName_Id")
    private String banknameId;

    @TableField("add_phone")
    private String addPhone;

    @TableField("inAmount")
    private Double inAmount;

    @TableField("ca_amount")
    private String caAmount;

    @TableField("inDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inDate;

    @TableField("inNumber")
    private String inNumber;

    private String accessory;

    @TableField(exist = false)
    private Integer contId;

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


    public String getTechTerm1() {
        return techTerm1;
    }

    public void setTechTerm1(String techTerm1) {
        this.techTerm1 = techTerm1;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public Date getAlDate() {
        return alDate;
    }

    public void setAlDate(Date alDate) {
        this.alDate = alDate;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
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

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDetailedaddress1() {
        return detailedaddress1;
    }

    public void setDetailedaddress1(String detailedaddress1) {
        this.detailedaddress1 = detailedaddress1;
    }

    public Integer getContId() {
        return contId;
    }

    public void setContId(Integer contId) {
        this.contId = contId;
    }
}
