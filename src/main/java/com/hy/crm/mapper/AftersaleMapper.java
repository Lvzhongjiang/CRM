package com.hy.crm.mapper;

import com.hy.crm.entity.AfterSaleBo;
import com.hy.crm.entity.Aftersale;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

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

}
