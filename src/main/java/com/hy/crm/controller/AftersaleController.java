package com.hy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.entity.Aftersale;
import com.hy.crm.entity.Datetype;
import com.hy.crm.service.IAftersaleService;
import com.hy.crm.service.IDatetypeService;
import com.hy.crm.util.DateType;
import com.hy.crm.util.LayuiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */

@Controller
public class AftersaleController{

    @Autowired
    private IAftersaleService iAftersaleService;
    @Autowired
    private IDatetypeService datetypeService;
    @RequestMapping("afterSaleList.do")
    @ResponseBody
    public LayuiData  list(Integer page,Integer limit,String type,String title,String id){
        Page<Aftersale> aftersalePage=new Page<>(page,limit);
        QueryWrapper<Aftersale> aftersaleQueryWrapper=new QueryWrapper<>();
        if(type!=null&&!"".equals(type)&&!"".equals(title)&&title!=null){
            if(type.equals("0")){
                aftersaleQueryWrapper.like("theme",title);
            }else if(type.equals("1")){
                aftersaleQueryWrapper.like("theme",title);
            }else if(type.equals("2")){
                QueryWrapper<Datetype> queryWrapper=new QueryWrapper<>();
                queryWrapper.eq("type", DateType.AFTERSALE_TYPESERVICE);
                queryWrapper.eq("title",title);
                List<Datetype> datetypeList=datetypeService.list(queryWrapper);
                List<Integer> integerList=new ArrayList<>();
                for(Datetype datetype:datetypeList){
                    integerList.add(datetype.getId());
                }
                aftersaleQueryWrapper.in("typeservice",integerList);
            }else if(type.equals("3")){
                /*aftersaleQueryWrapper.l*/
            }else if(type.equals("4")){
                aftersaleQueryWrapper.like("personnel",title);
            }else if(type.equals("5")){
                aftersaleQueryWrapper.eq("Servicescore",title);
            }
        }
        if(id!=null&&!"".equals(id)){
            if(!"-1".equals(id)){
                aftersaleQueryWrapper.eq("status",id);
            }
        }
        IPage<Aftersale> iPage=iAftersaleService.page(aftersalePage,aftersaleQueryWrapper);
        LayuiData layuiData=new LayuiData();
        layuiData.setCode(0);
        layuiData.setMsg("");
        Long l=iPage.getTotal();
        layuiData.setCount(l.intValue());
        layuiData.setData(iPage.getRecords());
        return layuiData;
    }


}
