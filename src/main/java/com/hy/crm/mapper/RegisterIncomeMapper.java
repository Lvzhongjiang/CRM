package com.hy.crm.mapper;

import com.hy.crm.entity.ContractManagement;
import com.hy.crm.entity.RegisterIncome;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
public interface RegisterIncomeMapper extends BaseMapper<RegisterIncome> {
    @Select("SELECT SUM(r.regMany) FROM register_income r WHERE cid=#{cid}")
    public Integer regsum(Integer cid);

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

    @Insert("INSERT INTO register_income ( regDate, regClassify, regMany, capital, payment_term, registrant, relat_per, relat_dept, unit, relat_cont, income_sta,contId ) VALUES (#{regDate}, #{regClassify}, #{regMany}, #{capital}, #{paymentTerm}, #{registrant}, #{relatPer1}, #{relatDept}, #{unit}, #{relatCont}, #{incomeSta},#{contId})")
    public void save(RegisterIncome registerIncome);


}