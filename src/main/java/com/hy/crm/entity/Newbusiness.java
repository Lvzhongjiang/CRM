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


}
