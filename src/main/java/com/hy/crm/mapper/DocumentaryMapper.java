package com.hy.crm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.entity.Documentary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.entity.Dome;
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
public interface DocumentaryMapper extends BaseMapper<Documentary> {
    @Select("SELECT MAX(docudate) FROM documentary WHERE nid=#{value}")
    public String docudate(Integer nid);
    @SelectProvider(type = Dome.class,method = "docm")
    public List<Documentary> docuquerry(String cha, String xie,Page<Documentary> page);
}