package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.bo.Busbo;
import com.hy.crm.entity.Newbusiness;
import com.hy.crm.mapper.DocumentaryMapper;
import com.hy.crm.mapper.NewbusinessMapper;
import com.hy.crm.service.INewbusinessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Service
public class NewbusinessServiceImpl extends ServiceImpl<NewbusinessMapper, Newbusiness> implements INewbusinessService {
    @Autowired
    private DocumentaryMapper documentaryMapper;
    @Autowired
    private NewbusinessMapper newbusinessMapper;
    public Integer perd(Integer cid){
        return newbusinessMapper.sumper(cid);
    }
    public  List<Newbusiness> selectbus(Integer cid){
        return newbusinessMapper.selectbu(cid);
    }
    public List<Busbo> busbos(String nname, String stage, String principal, String branch, Integer perdictmoney, Page<Busbo> page){
        List<Busbo>buslist=newbusinessMapper.select(nname,stage,principal,branch,perdictmoney,page);
        List<Busbo> bolist=new ArrayList<>();
        for(Busbo bus:buslist){
            Busbo butt=new Busbo();
            butt.setNid(bus.getNid());
            butt.setNname(bus.getNname());
            butt.setStage(bus.getStage());
            butt.setPrincipal(bus.getPrincipal());
            butt.setPerdictmoney(bus.getPerdictmoney());
            butt.setDocudate(documentaryMapper.docudate(bus.getNid()));
            bolist.add(butt);
        }
        return bolist;
    }

    public List<Busbo> busbose(String nname, String stage, String principal, String branch, Integer perdictmoney, Page<Busbo> page,String username){
        List<Busbo>buslist=newbusinessMapper.selecte(nname,stage,principal,branch,perdictmoney,page,username);
        List<Busbo> bolist=new ArrayList<>();
        for(Busbo bus:buslist){
            Busbo butt=new Busbo();
            butt.setNid(bus.getNid());
            butt.setNname(bus.getNname());
            butt.setStage(bus.getStage());
            butt.setPrincipal(bus.getPrincipal());
            butt.setPerdictmoney(bus.getPerdictmoney());
            butt.setDocudate(documentaryMapper.docudate(bus.getNid()));
            bolist.add(butt);
        }
        return bolist;
    }



}