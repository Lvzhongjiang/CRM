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
public class ContractManagement{

    private static final long serialVersionUID = 1L;

    @TableId(value = "contId", type = IdType.AUTO)
    private Integer contId;

    @TableField("contName")
    private String contName;

    @TableField("contNum")
    private String contNum;

    @TableField("contMany")
    private Double contMany;

    @TableField("contDate")
    private String contDate;

    @TableField("commenDate")
    private String commenDate;

    private String viability;

    private String contact;

    private Long landline;

    private Long cellphone;

    private String emaileQq;

    private String techTerm;

    private String comClause;

    private String accessory;

    private String collTerm;

    private String relatPer;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getContId() {
        return contId;
    }

    public void setContId(Integer contId) {
        this.contId = contId;
    }

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }

    public String getContNum() {
        return contNum;
    }

    public void setContNum(String contNum) {
        this.contNum = contNum;
    }

    public Double getContMany() {
        return contMany;
    }

    public void setContMany(Double contMany) {
        this.contMany = contMany;
    }

    public String getContDate() {
        return contDate;
    }

    public void setContDate(String contDate) {
        this.contDate = contDate;
    }

    public String getCommenDate() {
        return commenDate;
    }

    public void setCommenDate(String commenDate) {
        this.commenDate = commenDate;
    }

    public String getViability() {
        return viability;
    }

    public void setViability(String viability) {
        this.viability = viability;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Long getLandline() {
        return landline;
    }

    public void setLandline(Long landline) {
        this.landline = landline;
    }

    public Long getCellphone() {
        return cellphone;
    }

    public void setCellphone(Long cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmaileQq() {
        return emaileQq;
    }

    public void setEmaileQq(String emaileQq) {
        this.emaileQq = emaileQq;
    }

    public String getTechTerm() {
        return techTerm;
    }

    public void setTechTerm(String techTerm) {
        this.techTerm = techTerm;
    }

    public String getComClause() {
        return comClause;
    }

    public void setComClause(String comClause) {
        this.comClause = comClause;
    }

    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }

    public String getCollTerm() {
        return collTerm;
    }

    public void setCollTerm(String collTerm) {
        this.collTerm = collTerm;
    }

    public String getRelatPer() {
        return relatPer;
    }

    public void setRelatPer(String relatPer) {
        this.relatPer = relatPer;
    }
}
