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
public class Aftersale {

    private static final long serialVersionUID = 1L;

    @TableId(value = "aid", type = IdType.AUTO)
    private Integer aid;

    private String theme;

    private Integer clientid;

    private Integer contractid;

    private String maincontent;

    @TableField("Contactperson")
    private String Contactperson;

    private String fixedtelephones;

    private String mobiletelephones;

    private String post;

    private String typeservice;

    private Integer modelservice;

    private String starttime;

    private String endtime;

    private String content;

    private String feedback;

    private String personnel;

    @TableField("Servicescore")
    private String Servicescore;

    private String attachment;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    public Integer getContractid() {
        return contractid;
    }

    public void setContractid(Integer contractid) {
        this.contractid = contractid;
    }

    public String getMaincontent() {
        return maincontent;
    }

    public void setMaincontent(String maincontent) {
        this.maincontent = maincontent;
    }

    public String getContactperson() {
        return Contactperson;
    }

    public void setContactperson(String contactperson) {
        Contactperson = contactperson;
    }

    public String getFixedtelephones() {
        return fixedtelephones;
    }

    public void setFixedtelephones(String fixedtelephones) {
        this.fixedtelephones = fixedtelephones;
    }

    public String getMobiletelephones() {
        return mobiletelephones;
    }

    public void setMobiletelephones(String mobiletelephones) {
        this.mobiletelephones = mobiletelephones;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getTypeservice() {
        return typeservice;
    }

    public void setTypeservice(String typeservice) {
        this.typeservice = typeservice;
    }

    public Integer getModelservice() {
        return modelservice;
    }

    public void setModelservice(Integer modelservice) {
        this.modelservice = modelservice;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getPersonnel() {
        return personnel;
    }

    public void setPersonnel(String personnel) {
        this.personnel = personnel;
    }

    public String getServicescore() {
        return Servicescore;
    }

    public void setServicescore(String servicescore) {
        this.Servicescore = servicescore;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


