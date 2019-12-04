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
public class Reply{

    private static final long serialVersionUID = 1L;

    @TableId(value = "replyId", type = IdType.AUTO)
    private Integer replyId;

    @TableField("replyName")
    private String replyName;

    private String replytime;


}