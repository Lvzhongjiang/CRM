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
public class Permission{

    private static final long serialVersionUID = 1L;

    @TableId(value = "perId", type = IdType.AUTO)
    private Integer perId;

    @TableField("perName")
    private String perName;

    @TableField("perUrl")
    private String perUrl;


}
