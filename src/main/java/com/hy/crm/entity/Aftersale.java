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

    private Integer typeservice;

    private Integer modelservice;

    private String starttime;

    private String endtime;

    private String content;

    private String feedback;

    private String personnel;

    @TableField("Servicescore")
    private String Servicescore;

    private String attachment;


}
