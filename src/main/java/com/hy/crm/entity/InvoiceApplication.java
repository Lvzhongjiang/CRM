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
public class InvoiceApplication  {

    private static final long serialVersionUID = 1L;

    @TableId(value = "inId", type = IdType.AUTO)
    private Integer inId;

    @TableField("alName")
    private String alName;

    @TableField("affDept")
    private String affDept;

    @TableField("alDate")
    private String alDate;

    private String techTerm;

    private String unit;

    private String relatCont;

    @TableField("inKind")
    private String inKind;

    private String regNumber;

    @TableField("bankName_Id")
    private String banknameId;

    private String addPhone;

    @TableField("inAmount")
    private Double inAmount;

    private String caAmount;

    @TableField("inDate")
    private String inDate;

    @TableField("inNumber")
    private String inNumber;

    private String accessory;


}
