package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Data
public class Newbusiness{

    private static final long serialVersionUID = 1L;

    @TableId(value = "nid", type = IdType.AUTO)
    private Integer nid;

    private String nname;

    private Integer priority;

    private String bane;

    private String source;

    private Integer perdictmoney;

    private String preddate;

    private String iname;

    private String section;

    private String post;

    private String telephone;

    private String mophone;

    private String qq;

    private String demane;

    private String accessory;

    private String branch;

    private String principal;

    private String participant;

    private String concerned;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getNname() {
        return nname;
    }

    public void setNname(String nname) {
        this.nname = nname;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getBane() {
        return bane;
    }

    public void setBane(String bane) {
        this.bane = bane;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getPerdictmoney() {
        return perdictmoney;
    }

    public void setPerdictmoney(Integer perdictmoney) {
        this.perdictmoney = perdictmoney;
    }

    public String getPreddate() {
        return preddate;
    }

    public void setPreddate(String preddate) {
        this.preddate = preddate;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMophone() {
        return mophone;
    }

    public void setMophone(String mophone) {
        this.mophone = mophone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getDemane() {
        return demane;
    }

    public void setDemane(String demane) {
        this.demane = demane;
    }

    public String getAccessory() {
        return accessory;
    }

    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public String getConcerned() {
        return concerned;
    }

    public void setConcerned(String concerned) {
        this.concerned = concerned;
    }
}
