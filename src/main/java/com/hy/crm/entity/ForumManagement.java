package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class ForumManagement{

    private static final long serialVersionUID = 1L;

    @TableId(value = "forumId", type = IdType.AUTO)
    private Integer forumId;

    private String motif;

    private String author;

    private String postType;

    private String accessory;

    private String click;

    private String reply;

    private String replytime;


}
