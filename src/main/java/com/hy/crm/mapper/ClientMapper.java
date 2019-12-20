package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.entity.Client;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.entity.Dome;
import com.hy.crm.entity.Newbusiness;
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
public interface ClientMapper extends BaseMapper<Client> {
    @Select("SELECT COUNT(*) FROM contract_management r WHERE r.did IN(SELECT d.did FROM documentary d WHERE d.nid IN(SELECT b.nid FROM newbusiness b WHERE b.cid=#{cid}))")
    public Integer count(Integer cid);
    @Select("SELECT SUM(r.contMany) FROM contract_management r WHERE r.did IN(SELECT d.did FROM documentary d WHERE d.nid IN(SELECT b.nid FROM newbusiness b WHERE b.cid=#{cid}))")
    public Integer sum(Integer cid);

    @SelectProvider(type = Dome.class,method = "domesql")
    public List<Client> querrsql(String cha,String xie);
   /* @SelectProvider(type = Dome.class,method = "classif")
    public List<Client> classif(String typeid);*/
   @Select("select industry from client")
   public List<Client> lindList();
}