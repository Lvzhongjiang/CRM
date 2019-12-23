package com.hy.crm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.bo.Busbo;
import com.hy.crm.entity.Dome;
import com.hy.crm.entity.Newbusiness;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
public interface NewbusinessMapper extends BaseMapper<Newbusiness> {
    @Select("SELECT SUM(perdictmoney) FROM newbusiness where cid=#{cid}")
    public Integer sumper(Integer cid);
    @Select("SELECT count(*) FROM newbusiness where cid=#{cid}")
    public Integer count(Integer cid);
    @Select("SELECT  n.nname,n.post,n.perdictmoney,n.principal FROM CLIENT c,newbusiness n WHERE c.cid=n.cid AND c.cid=#{value}")
    public  List<Newbusiness> selectbu(Integer cid);
    public List<Newbusiness> querrall(Newbusiness newbusiness, Page<Newbusiness> page);
    public Integer nname(Integer cid);
    public Integer stage(Integer cid);
    public Integer perdictmoney(Integer cid);
    public Integer docudate(Integer cid);

    @SelectProvider(type = Dome.class,method = "busquerr")
    public List<Busbo> select(Page<Busbo> page,@Param("bus") Newbusiness newbusiness,@Param("cid") Integer cid,@Param("name") String name);

    @SelectProvider(type = Dome.class,method = "mybusquerr")
    public List<Busbo> selecte(String nname,String stage,String principal,String branch,Integer perdictmoney,Page<Busbo> page,@Param("username") String username);
}