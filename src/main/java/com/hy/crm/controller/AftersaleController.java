package com.hy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.entity.Aftersale;
import com.hy.crm.service.IAftersaleService;
import com.hy.crm.util.LayuiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;


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
    @RequestMapping("afterSaleList.do")
    @ResponseBody
    public LayuiData  list(Integer page,Integer limit){
        Page<Aftersale> aftersalePage=new Page<>(page,limit);
        IPage<Aftersale> iPage=iAftersaleService.page(aftersalePage,new QueryWrapper<Aftersale>());
        LayuiData layuiData=new LayuiData();
        layuiData.setCode(0);
        layuiData.setMsg("");
        Long l=iPage.getTotal();
        layuiData.setCount(l.intValue());
        layuiData.setData(iPage.getRecords());
        return layuiData;
    }

}
