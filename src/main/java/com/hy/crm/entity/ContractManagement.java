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
public class ContractManagement{

    private static final long serialVersionUID = 1L;

    @TableId(value = "contId", type = IdType.AUTO)
    private Integer contId;

    @TableField("contName")
    private String contName;

    @TableField("contNum")
    private String contNum;

    @TableField("contMany")
    private Double contMany;

    @TableField("contDate")
    private String contDate;

    @TableField("commenDate")
    private String commenDate;

    private String viability;

    private String contact;

    private Long landline;

    private Long cellphone;

    private String emaileQq;

    private String techTerm;

    private String comClause;

    private String accessory;

    private String collTerm;

    private String relatPer;


}
