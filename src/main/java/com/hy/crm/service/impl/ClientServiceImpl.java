package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.bo.Busbo;
import com.hy.crm.bo.NewCit;
import com.hy.crm.entity.Aftersale;
import com.hy.crm.entity.Client;
import com.hy.crm.entity.ContractManagement;
import com.hy.crm.entity.Newbusiness;
import com.hy.crm.mapper.*;
import com.hy.crm.service.IClientService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.service.IRegisterIncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Service
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements IClientService {
    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private NewbusinessMapper newbusinessMapper;
    @Autowired
    private ContractManagementMapper contractManagementMapper;
    @Autowired
    private AftersaleMapper aftersaleMapper;
    @Autowired
    private RegisterIncomeMapper registerIncomeMapper;
    public List<NewCit> querrClent(String cha,String xie) {
        /*QueryWrapper wrapper=new QueryWrapper<Client>();
        if(null!=cha&&!"".equals(cha)&&null!=xie&&!"".equals(xie)){
            wrapper.like(cha,xie);
        }
        clientMapper.selectList(wrapper);*/
        List<Client>clients= clientMapper.querrsql(cha,xie);
        //List<Client> clients = clientMapper.selectList(new QueryWrapper<Client>());
        List<NewCit> citList =new ArrayList<>();
        for (Client client : clients) {
            NewCit cit = new NewCit();
            System.out.println(client);
            //客户的name和id
            cit.setCustomername(client.getCustomername());
            cit.setCid(client.getCid());
            System.out.println(client.getCid());
            cit.setNid(client.getNid());
            cit.setClassif(client.getClassif());
            cit.setBuscount(newbusinessMapper.count(client.getCid()));
            cit.setPerdictmoney(newbusinessMapper.sumper(client.getCid()));
            cit.setConttract(clientMapper.count(client.getCid()));
            cit.setContMany(clientMapper.sum(client.getCid()));
            Integer a=registerIncomeMapper.regsum(client.getCid());
            if(a==null){
                cit.setRetmoney(0);
            }else{
                cit.setRetmoney(a);
            }
            cit.setContafter(aftersaleMapper.countaftet(client.getCid()));
            Integer c=aftersaleMapper.sumaftet(client.getCid());
            if(c==null){
                cit.setAvgafter(0);
            }else{
                cit.setAvgafter(c);
            }

            citList.add(cit);
        }

        return citList;
    }
   /* public IPage<Client> quallsql(String cha,String xie,Integer page,Integer limit){
        Page<Client> chien=new Page<>(page,limit);
        List<Client>list= clientMapper.querrsql(cha,xie,chien);
        chien.setRecords(list);
        return chien;
    }*/
    @Override
    public List<Client> lindList() {
        return clientMapper.lindList();
    }


}