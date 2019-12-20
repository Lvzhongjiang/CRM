package com.hy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.crm.bo.Busbo;
import com.hy.crm.bo.NewCit;
import com.hy.crm.entity.Client;
import com.hy.crm.entity.Newbusiness;
import com.hy.crm.entity.User;
import com.hy.crm.service.IClientService;
import com.hy.crm.service.INewbusinessService;
import com.hy.crm.util.LayuiData;
import org.apache.poi.util.SystemOutLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/newbusiness")
public class NewbusinessController {
    @Autowired
    private IClientService clientService;
    @Autowired
    private INewbusinessService newbusinessService;

    @RequestMapping("/busquall.do")
    @ResponseBody
    public ModelAndView busquall(Integer cid) {
        ModelAndView modelAndView = new ModelAndView();
        List<Newbusiness> newbusinessList = newbusinessService.selectbus(cid);
        modelAndView.addObject("newbusinessList", newbusinessList);
        modelAndView.setViewName("/selectsjs.html");
        return modelAndView;
    }

    @RequestMapping("/tobuqu.do")
    public String tobuqu() {


        return "";
    }

    @RequestMapping("/querrall.do")
    @ResponseBody
    public LayuiData querrall(Newbusiness business,Integer page, Integer limit) {
        Page<Busbo> page1=new Page<>(page,limit);
        List<Busbo> citlist = newbusinessService.busbos(business.getNname(),business.getStage(),business.getPrincipal(),business.getBranch(),business.getPerdictmoney(),page1);
        //PageInfo<Busbo>pageInfo=new PageInfo<>(citlist);
        page1.setRecords(citlist);
        LayuiData layuiData = new LayuiData();
        layuiData.setCode(0);
        layuiData.setMsg("");
        Long l = page1.getTotal();
        layuiData.setCount(l.intValue());
        layuiData.setData(citlist);
        return layuiData;
    }





    @RequestMapping("/querralle.do")
    @ResponseBody
    public LayuiData querralle(Newbusiness business, Integer page, Integer limit, HttpServletRequest request) {
        Page<Busbo> page1=new Page<>(page,limit);
        User user=(User) request.getSession().getAttribute("users");
       String username= user.getNumber();

        List<Busbo> citlist = newbusinessService.busbose(business.getNname(),business.getStage(),business.getPrincipal(),business.getBranch(),business.getPerdictmoney(),page1,username);
        //PageInfo<Busbo>pageInfo=new PageInfo<>(citlist);
        page1.setRecords(citlist);
        LayuiData layuiData = new LayuiData();
        layuiData.setCode(0);
        layuiData.setMsg("");
        Long l = page1.getTotal();
        layuiData.setCount(l.intValue());
        layuiData.setData(citlist);
        return layuiData;
    }

    @RequestMapping("/tosave.do")
    public ModelAndView tosave() {
        ModelAndView modelAndView = new ModelAndView();
        List<Client> listche = clientService.list(new QueryWrapper<Client>());
        modelAndView.addObject("listche", listche);
        modelAndView.setViewName("/businadd.html");
        return modelAndView;
    }

    @RequestMapping("/save.do")
    @ResponseBody
    public String save(Newbusiness newbusiness, Client client) {
        String msg = "1";
        try {
            /*clientService.save(client);*/
            newbusinessService.save(newbusiness);
        } catch (Exception e) {
            msg = "2";
            e.printStackTrace();
        }
        return msg;
    }
    @RequestMapping("/byid.do")
    @ResponseBody
    public  Client byid(String cid){
       Client cl=clientService.getOne(new QueryWrapper<Client>().eq("cid",cid));
       return cl;
    }
    @RequestMapping("/toupda.do")
    public ModelAndView toupda(Integer nid){
        ModelAndView modelAndView=new ModelAndView();
      Newbusiness newbusiness=  newbusinessService.getById(nid);
       List<Client>listcl= clientService.list(new QueryWrapper<Client>());
        modelAndView.addObject("newbusiness",newbusiness);
       modelAndView.addObject("listcl",listcl);
        modelAndView.setViewName("/businupda.html");
        return modelAndView;
    }
    @RequestMapping("/upda.do")
    @ResponseBody
    public  String upda(Newbusiness newbusiness){
        String msg="1";
        try {
            newbusinessService.updateById(newbusiness);
        } catch (Exception e) {
            msg="2";
            e.printStackTrace();
        }
        return msg;
    }

}
