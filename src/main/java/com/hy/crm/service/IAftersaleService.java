package com.hy.crm.service;

import com.hy.crm.entity.AfterSaleBo;
import com.hy.crm.entity.Aftersale;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
