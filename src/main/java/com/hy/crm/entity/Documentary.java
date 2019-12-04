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
public class Documentary {

    private static final long serialVersionUID = 1L;

    @TableId(value = "did", type = IdType.AUTO)
    private Integer did;

    private String docudate;

    private String docutheme;

    private String dname;

    private String content;

    private String accessory;


}
