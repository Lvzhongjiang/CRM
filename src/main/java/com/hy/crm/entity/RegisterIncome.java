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
public class RegisterIncome{

    private static final long serialVersionUID = 1L;

    @TableId(value = "regId", type = IdType.AUTO)
    private Integer regId;

    @TableField("regName")
    private String regName;

    @TableField("regClassify")
    private String regClassify;

    @TableField("regMany")
    private Double regMany;

    private String capital;

    private String paymentTerm;

    private String registrant;

    private String relatPer;

    private String relatDept;

    private String unit;

    private String relatCont;

    private String incomeSta;


}
