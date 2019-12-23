package com.hy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.crm.bo.NewCit;
import com.hy.crm.entity.Client;
import com.hy.crm.entity.Documentary;
import com.hy.crm.service.IClientService;
import com.hy.crm.util.LayuiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private IClientService clientService;

    @RequestMapping("/clienlist.do")
    @ResponseBody
    public LayuiData clienlist(String cha,String xie,Integer page,Integer limit) {
        LayuiData layuiData=new LayuiData();
        layuiData.setMsg("");
        layuiData.setCode(0);
        Page page1 = PageHelper.startPage(page, limit,true);
        List<NewCit> iPage =  clientService.querrClent(cha,xie);
        PageInfo<NewCit> pageInfo=new PageInfo<>(iPage);

        Long l=pageInfo.getTotal();
        layuiData.setCount(l.intValue());
        layuiData.setData(iPage);
        return layuiData;
    }
    @RequestMapping("/toselect.do")
    @ResponseBody
    public LayuiData dercu(String cha,String xie,Integer page,Integer limit){
        LayuiData layuiData=new LayuiData();
        layuiData.setMsg("");
        layuiData.setCode(0);
        Page ipage=PageHelper.startPage(page,limit,true);
        List<NewCit> citList=clientService.querrClent(cha,xie);
        System.out.println(citList);
        Long l= ipage.getTotal();
        layuiData.setCount(l.intValue());
        layuiData.setData(citList);
        return layuiData;
    }

    @RequestMapping("/toseave.do")
    public ModelAndView toseave(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("/clientadd.html");
        return modelAndView;
    }
    @RequestMapping("/seave.do")
    @ResponseBody
    public String seave(Client client){
        String msg="1";
        try {
            clientService.save(client);
        } catch (Exception e) {
            msg="2";
            e.printStackTrace();
        }
        return msg;
    }




    @RequestMapping("/toupda.do")
    public ModelAndView toupda(Integer cid){
        ModelAndView modelAndView=new ModelAndView();
        Client client = clientService.getById(cid);
        modelAndView.addObject("client",client);
        modelAndView.setViewName("/clientupda.html");
        return modelAndView;
    }


    @RequestMapping("/upda.do")
    @ResponseBody
    public String upda(Client client){
        String msg="1";
        try {
            clientService.updateById(client);
        } catch (Exception e) {
            msg="2";
            e.printStackTrace();
        }
        return msg;
    }
}
