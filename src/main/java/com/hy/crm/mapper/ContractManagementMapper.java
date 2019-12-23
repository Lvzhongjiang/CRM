package com.hy.crm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.entity.ContractManagement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.sql.ContractSql;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
public interface ContractManagementMapper extends BaseMapper<ContractManagement> {
    @Select("SELECT SUM(contMany) FROM contract_management where cid=#{value}")
    public Integer summoney(Integer cid);
    /**
     * 模糊查询  分页
     *
     * @param
     * @return
     */
    @Results({
            @Result(column = "regMany", property = "registerIncome.regMany"),
    })
    @SelectProvider(type = ContractSql.class, method = "selectCont")
    public List<ContractManagement> queryAll(String status,String heTong, String keyword, Page<ContractManagement> page);

    /**
     * 根据合同名查
     */
    @Results({
            @Result(column = "customername", property = "client.customername"),
            @Result(column = "industry", property = "client.industry"),
            @Result(column = "city", property = "client.city"),
            @Result(column = "detailedaddress", property = "client.detailedaddress"),
            @Result(column = "cid", property = "client.cid"),
            @Result(column = "emaile_qq", property = "emaileQq"),
            @Result(column = "tech_term", property = "techTerm"),
            @Result(column = "com_clause", property = "comClause"),
            @Result(column = "relat_per", property = "relatPer"),
            @Result(column = "coll_term", property = "collTerm"),
    })
    @Select("SELECT c.customername,c.industry,c.cid,c.city,c.detailedaddress,cm.*  FROM contract_management cm,CLIENT c WHERE cm.cid =c.cid AND contName=#{contName}")
    public ContractManagement contName(String contName);

    @Select("SELECT count(*) FROM contract_management cm INNER JOIN register_income ri ON cm.contId=ri.contId INNER JOIN invoice_application ia ON cm.contId=ia.contId AND commenDate < CURRENT_DATE  AND CURRENT_DATE < viability GROUP BY contName")
    public Integer listZx();
    @Select("SELECT count(*) FROM contract_management cm INNER JOIN register_income ri ON cm.contId=ri.contId INNER JOIN invoice_application ia ON cm.contId=ia.contId  AND viability < CURRENT_DATE")
    public Integer listYg();

    @Select("SELECT count(*) FROM contract_management cm INNER JOIN register_income ri ON cm.contId=ri.contId INNER JOIN invoice_application ia ON cm.contId=ia.contId AND STATUS='已撤除的合同'")
    public Integer listYc();
    @Select("SELECT count(*) FROM contract_management cm INNER JOIN register_income ri ON cm.contId=ri.contId INNER JOIN invoice_application ia ON cm.contId=ia.contId AND status='被搁置的合同'")
    public Integer listYz();
    //本周
    @Select("SELECT COUNT(*) FROM contract_management WHERE YEARWEEK(DATE_FORMAT(commenDate,'%Y-%m-%d'),1) = YEARWEEK(NOW(),1)")
    public Integer listBenZhou();
    //上周*******
    @Select("SELECT COUNT(*) FROM contract_management WHERE YEARWEEK(DATE_FORMAT(commenDate,'%Y-%m-%d')) = YEARWEEK(NOW())-1")
    public Integer listShangZhou();
    //本月
    @Select("SELECT COUNT(*) FROM contract_management WHERE DATE_FORMAT( commenDate, '%y%m' ) = DATE_FORMAT( CURDATE( ) , '%y%m' )")
    public Integer listBenYue();
    //上月
    @Select("SELECT COUNT(*) FROM contract_management WHERE PERIOD_DIFF(DATE_FORMAT(SYSDATE(),'%y%m'),DATE_FORMAT(commenDate,'%y%m')) =1")
    public Integer listShangYue();
    //本季度
    @Select("SELECT COUNT(*) FROM contract_management WHERE QUARTER(commenDate)=QUARTER(NOW())")
    public Integer listBenJiDu();
    //上季度
    @Select("SELECT COUNT(*) FROM contract_management WHERE QUARTER(commenDate)=QUARTER(DATE_SUB(NOW(),INTERVAL 1 QUARTER))")
    public Integer listShangJiDu();
}