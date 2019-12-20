package com.hy.crm.service.impl;

import com.hy.crm.entity.*;
import com.hy.crm.mapper.AftersaleMapper;
import com.hy.crm.service.IAftersaleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

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
public class AftersaleServiceImpl extends ServiceImpl<AftersaleMapper, Aftersale> implements IAftersaleService {
    public AfterSaleBo selectByAid(Integer id){
        return this.baseMapper.selectByAid(id);
    };
    public List<Industry> industrySelect(List<Datetype> list){
        List<Industry> industries=this.baseMapper.industrySelect();
        for(Datetype datetype:list){
            boolean a=true;
            for(Industry industry:industries){
                    if(industry.getId()==datetype.getId()){
                         a=false;
                    }
             }
             if(a){
                 Industry industry=new Industry();
                 industry.setId(datetype.getId());
                 industry.setTitle(datetype.getTitle());
                 industry.setS(0);
                 industry.setM(0);
                 industries.add(industry);
             }
        }
      return industries;
    }

    public List<Industry> sourceSelect(List<Datetype> list){
        List<Industry> industries=this.baseMapper.sourceSelect();
        for(Datetype datetype:list){
            boolean a=true;
            for(Industry industry:industries){
                if(industry.getId()==datetype.getId()){
                    a=false;
                }
            }
            if(a){
                Industry industry=new Industry();
                industry.setId(datetype.getId());
                industry.setTitle(datetype.getTitle());
                industry.setS(0);
                industry.setM(0);
                industries.add(industry);
            }
        }
        return industries;
    }

    public NewCount selectCount2(){
        return this.baseMapper.selectCount2();
    }

    @Override
    public NewCount countSum(Integer status) {
        return this.baseMapper.countSum(status);
    }

    @Override
    public NewCount selectCount1(String sta, String end) {
        return this.baseMapper.selectCount1(sta,end);
    }

    @Override
    public NewCount countSum1(Integer status, String sta, String end) {
        return this.baseMapper.countSum1(status,sta,end);
    }

}
