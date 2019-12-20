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
@TableName("contract_management")
public class ContractManagement {

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date contDate;

    @TableField("commenDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date commenDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date viability;

    private String contact;

    private Long landline;

    private Long cellphone;

    @TableField("emaile_qq")
    private String emaileQq;

    @TableField("tech_term")
    private String techTerm;

    @TableField("tech_term")
    private String tech_term;

    @TableField(exist = false)
    private double s;
    @TableField(exist = false)
    private double s1;

    @TableField("com_clause")
    private String comClause;
    @TableField(exist = false)
    private String accessory;

    @TableField("coll_term")
    private String collTerm;

    @TableField("coll_term")
    private String coll_term;

    @TableField("relat_per")
    private String relatPer;

    private String status;

    @TableField(exist = false)
    private Client client;

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


    public Date getContDate() {
        return contDate;
    }

    public void setContDate(Date contDate) {
        this.contDate = contDate;
    }

    public Date getCommenDate() {
        return commenDate;
    }

    public void setCommenDate(Date commenDate) {
        this.commenDate = commenDate;
    }

    public Date getViability() {
        return viability;
    }

    public void setViability(Date viability) {
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

    public String getTech_term() {
        return tech_term;
    }

    public void setTech_term(String tech_term) {
        this.tech_term = tech_term;
    }

    public double getS() {
        return s;
    }

    public void setS(double s) {
        this.s = s;
    }

    public double getS1() {
        return s1;
    }

    public void setS1(double s1) {
        this.s1 = s1;
    }

    public String getColl_term() {
        return coll_term;
    }

    public void setColl_term(String coll_term) {
        this.coll_term = coll_term;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
