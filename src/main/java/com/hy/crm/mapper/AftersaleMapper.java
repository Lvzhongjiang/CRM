package com.hy.crm.mapper;

import com.hy.crm.entity.AfterSaleBo;
import com.hy.crm.entity.Aftersale;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.entity.Industry;
import com.hy.crm.entity.NewCount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
public interface AftersaleMapper extends BaseMapper<Aftersale> {

    @Select(value = "SELECT a.`aid`,a.`theme`,c.`customername`,cont.`contName`,a.`maincontent`,\n" +
            "    a.`Contactperson`,a.`fixedtelephones`,a.`mobiletelephones`,a.`post`,d.`title`,a.`modelservice`,\n" +
            "    a.`starttime`,a.`endtime`,a.`content`,a.`feedback`,a.`personnel`,a.`attachment`,a.Servicescore\n" +
            "    FROM aftersale a,CLIENT c,contract_management cont,datetype d WHERE a.`clientid`=c.cid AND\n" +
            "    a.`contractid`=cont.`contId` AND cont.`cid`=c.`cid` AND a.`typeservice`=d.`id` AND a.aid=#{id}")
    public AfterSaleBo selectByAid(Integer id);
    @Select(value = "SELECT d.`id`,d.`title`,COUNT(*) AS s,SUM(n.perdictmoney) AS m FROM datetype d ,CLIENT c,newbusiness" +
            " n WHERE d.`id`=c.`industry` AND c.`cid`=n.cid AND d.type=8 GROUP BY d.`id`")
    public List<Industry> industrySelect();

    @Select(value = "SELECT d.`id`,d.`title`,COUNT(*) AS s,SUM(n.perdictmoney) AS m FROM datetype d ,newbusiness n WHERE d.`id`=n.source AND d.type=9 GROUP BY d.`id`")
    public List<Industry> sourceSelect();

    @Select(value = " SELECT COUNT(*) c,SUM(perdictmoney) s FROM newbusiness")
    public NewCount selectCount2();
    @Select(value = "  SELECT COUNT(*) c,SUM(perdictmoney) s FROM newbusiness WHERE STATUS=#{status}")
    public NewCount countSum(Integer status);

    @Select(value = " SELECT COUNT(*) c,SUM(perdictmoney) s FROM newbusiness where ntime>=#{sta} and ntime<=#{end}")
    public NewCount selectCount1(@Param(value = "sta") String sta,@Param(value = "end") String end);
    @Select(value = "  SELECT COUNT(*) c,SUM(perdictmoney) s FROM newbusiness WHERE STATUS=#{status} and ntime>=#{sta} and ntime<=#{end}")
    public NewCount countSum1(@Param(value = "status") Integer status,@Param(value = "sta") String sta,@Param(value = "end") String end);

    @Select("SELECT COUNT(aid) FROM aftersale a,CLIENT c WHERE a.clientid=c.cid AND c.cid=#{value}")
    public Integer countaftet(Integer cid);

    @Select("SELECT AVG(a.Servicescore) FROM aftersale a,CLIENT c WHERE a.clientid=c.cid AND c.cid=#{value}")
    public Integer sumaftet(Integer cid);

}
