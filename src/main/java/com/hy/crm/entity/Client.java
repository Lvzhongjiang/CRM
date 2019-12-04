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
public class Client  {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cid", type = IdType.AUTO)
    private Integer cid;

    private String customername;

    private String spell;

    private Integer type;

    private String source;

    private String industry;

    @TableField("Customersite")
    private String Customersite;

    private String state;

    private String city;

    private String detailedaddress;

    @TableField("PostCode")
    private String PostCode;

    private String fax;

    private Integer contact;

    private String department;

    private String duty;

    private Integer officephones;

    private Integer mobiletelephones;

    private String post;

    private String company;

    private String registeredcapital;

    private String stated;

    private Integer bankaccount;

    @TableField("Account")
    private String Account;

    private String depositbank;

    private String bankaddress;

    private String taxnumber;

    private String bankiphone;


}
