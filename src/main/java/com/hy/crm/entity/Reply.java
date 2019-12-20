package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("reply")
public class Reply{

    private static final long serialVersionUID = 1L;

    @TableId(value = "replyId", type = IdType.AUTO)
    private Integer replyId;

    @TableField("replyName")
    private String replyName;

    private String replytime;

    private String content;

    @TableField("forumId")
    private  Integer forumIds;

    @TableField(exist = false)
    private ForumManagement forumManagement;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getReplyName() {
        return replyName;
    }

    public void setReplyName(String replyName) {
        this.replyName = replyName;
    }

    public String getReplytime() {
        return replytime;
    }

    public void setReplytime(String replytime) {
        this.replytime = replytime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getForumIds() {
        return forumIds;
    }

    public void setForumIds(Integer forumIds) {
        this.forumIds = forumIds;
    }

    public ForumManagement getForumManagement() {
        return forumManagement;
    }

    public void setForumManagement(ForumManagement forumManagement) {
        this.forumManagement = forumManagement;
    }
}
