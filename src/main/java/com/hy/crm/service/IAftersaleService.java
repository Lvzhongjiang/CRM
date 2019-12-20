package com.hy.crm.service;

import com.hy.crm.entity.*;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
public interface IAftersaleService extends IService<Aftersale> {
    public AfterSaleBo selectByAid(Integer id);
    public List<Industry> industrySelect(List<Datetype> list);
    public List<Industry> sourceSelect(List<Datetype> list);
    public NewCount selectCount2();
    public NewCount countSum(Integer status);
    public NewCount selectCount1(String sta,String end);
    public NewCount countSum1(Integer status,String sta,String end);
}
