package com.hy.crm.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.bo.Busbo;
import com.hy.crm.entity.Newbusiness;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
public interface INewbusinessService extends IService<Newbusiness> {
    public List<Newbusiness> selectbus(Integer cid);
    public List<Busbo> busbos(String nname, String stage, String principal, String branch, Integer perdictmoney, Page<Busbo> page);
    public List<Busbo> busbose(String nname, String stage, String principal, String branch, Integer perdictmoney, Page<Busbo> page,String username);
}