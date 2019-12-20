package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class ForumManagement {

    private static final long serialVersionUID = 1L;

    @TableId(value = "forumId", type = IdType.AUTO)
    private Integer forumId;

    private String motif;

    private String author;

    @TableField(exist = false)
    private Integer c;

    private String business;

    @TableField(value = "post_type")
    private String postType;

    @TableField(value = "accessory")
    private String accessory1;

    private String click;

    private String label;

    private String status;

    @DateTimeFormat(pattern = "yyyy-MM-dd ")
    private Date replytime;

    @TableField("post_content")
    private String postContent;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getForumId() {
        return forumId;
    }

    public void setForumId(Integer forumId) {
        this.forumId = forumId;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getAccessory() {
        return accessory1;
    }

    public void setAccessory(String accessory) {
        this.accessory1 = accessory;
    }

    public String getClick() {
        return click;
    }

    public void setClick(String click) {
        this.click = click;
    }


    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getReplytime() {
        return replytime;
    }

    public void setReplytime(Date replytime) {
        this.replytime = replytime;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAccessory1() {
        return accessory1;
    }

    public void setAccessory1(String accessory1) {
        this.accessory1 = accessory1;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }


}
