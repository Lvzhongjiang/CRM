package com.hy.crm.mapper;

import com.hy.crm.entity.ContractManagement;
import com.hy.crm.entity.InvoiceApplication;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.entity.RegisterIncome;
import com.hy.crm.service.IInvoiceApplicationService;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
public interface InvoiceApplicationMapper extends BaseMapper<InvoiceApplication> {

    @Results({
            @Result(column="customername",property="client.customername"),
            @Result(column = "industry",property ="client.industry"),
            @Result(column="city",property="client.city"),
            @Result(column = "detailedaddress",property ="client.detailedaddress"),
            @Result(column = "cid",property ="client.cid"),
            @Result(column = "emaile_qq",property ="emaileQq"),
            @Result(column="tech_term",property="techTerm"),
            @Result(column = "com_clause",property ="comClause"),
            @Result(column = "relat_per",property ="relatPer"),
            @Result(column = "coll_term",property ="collTerm"),
    })
    @Select("SELECT c.customername,c.industry,c.cid,c.city,c.detailedaddress,cm.*  FROM contract_management cm,CLIENT c WHERE cm.cid =c.cid AND contName=#{contName}")
    public ContractManagement contName(String contName);
    @Insert("INSERT INTO invoice_application ( motif, endTime, detailedaddress,alName, affDept, alDate, tech_term, unit,inKind,reg_number,bankName_Id ,add_phone,inAmount,ca_amount,inDate,inNumber,accessory,contId) VALUES  (#{motif}, #{endTime}, #{detailedaddress1}, #{alName},  #{affDept}, #{alDate}, #{techTerm1}, #{unit}, #{inKind},#{regNumber},#{banknameId},#{addPhone},#{inAmount},#{caAmount},#{inDate},#{inNumber},#{accessory},#{contId})")
    public void saveInvoice(InvoiceApplication invoiceApplication);
}
