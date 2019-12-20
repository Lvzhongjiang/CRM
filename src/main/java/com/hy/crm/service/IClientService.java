package com.hy.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.bo.Busbo;
import com.hy.crm.bo.NewCit;
import com.hy.crm.entity.Client;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.mapper.ClientMapper;

import java.security.PrivateKey;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
public interface IClientService extends IService<Client> {

    public List<NewCit> querrClent(String cha,String xie);
    public List<Client> lindList();
    /*public IPage<Client> quallsql(String cha,String xie, Integer page,Integer limit);*/
}