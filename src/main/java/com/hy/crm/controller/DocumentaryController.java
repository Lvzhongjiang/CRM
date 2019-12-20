package com.hy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.crm.entity.Documentary;
import com.hy.crm.entity.Newbusiness;
import com.hy.crm.service.IDocumentaryService;
import com.hy.crm.service.INewbusinessService;
import com.hy.crm.util.LayuiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
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
@RequestMapping("/documentary")
public class DocumentaryController{
    @Autowired
    private IDocumentaryService iDocumentaryService;
    @Autowired
    private INewbusinessService newbusinessService;
    @RequestMapping("/dolis.do")
    @ResponseBody
    public LayuiData dolist(Integer page,Integer limit,String cha,String xie){
        Page<Documentary> docuPage=new Page<>(page,limit);
        List<Documentary> iPage = iDocumentaryService.selectall(cha,xie,docuPage);
        docuPage.setRecords(iPage);
        LayuiData layuiData=new LayuiData();
        layuiData.setCode(0);
        layuiData.setMsg("");
        Long l= docuPage.getTotal();
        layuiData.setCount(l.intValue());
        layuiData.setData(iPage);
        //List<Documentary> ispage = iPage.getRecords();
        //List<Documentary> list=new ArrayList<>();
        /*for (Documentary documentary:ispage){
            Newbusiness byteu = newbusinessService.getById(documentary.getDocutheme());
            documentary.setDocutheme(byteu.getNname());
            list.add(documentary);
        }*/
        /*iPage.setRecords(list);
       layuiData.setData(iPage.getRecords());*/

        return layuiData;
    }
    @RequestMapping("/toseave.do")
    public ModelAndView toseave(){
        ModelAndView modelAndView=new ModelAndView();
        List<Newbusiness> bulist = newbusinessService.list(new QueryWrapper<Newbusiness>());
       modelAndView.addObject("bulist",bulist);
        modelAndView.setViewName("/docuadd.html");
        return modelAndView;
    }
    @RequestMapping("/seave.do")
    @ResponseBody
    public String seave(@Validated Documentary documentary){
        String msg="1";
        try {
            iDocumentaryService.save(documentary);
        } catch (Exception e) {
            msg="2";
            e.printStackTrace();
        }
        return msg;
    }
    //跟单修改
    //根据id查询一条值
    @RequestMapping("/toupdatea.do")
    public ModelAndView toupdatea(Integer did){
        ModelAndView modelAndView=new ModelAndView();
       Documentary documentary= iDocumentaryService.getById(did);
        List<Newbusiness> bulist = newbusinessService.list(new QueryWrapper<Newbusiness>());
        modelAndView.addObject("bulist",bulist);
        modelAndView.addObject("documentary",documentary);
        modelAndView.setViewName("/docuupdat.html");
        return modelAndView;
    }
    @RequestMapping("/update.do")
    @ResponseBody
    public String myupdate(Documentary documentary){
        String msg="1";
        try {
            iDocumentaryService.updateById(documentary);
        } catch (Exception e) {
            msg="2";
            e.printStackTrace();
        }
        return msg;
    }










    @RequestMapping("/mytoseave.do")
    public ModelAndView mytoseave(){
        ModelAndView modelAndView=new ModelAndView();
        List<Newbusiness> bulists = newbusinessService.list(new QueryWrapper<Newbusiness>());
        modelAndView.addObject("bulists",bulists);
        modelAndView.setViewName("/mydocuadd.html");
        return modelAndView;
    }
    @RequestMapping("/myseave.do")
    @ResponseBody
    public String myseave(@Validated Documentary documentary){
        String msg="1";
        try {
            iDocumentaryService.save(documentary);
        } catch (Exception e) {
            msg="2";
            e.printStackTrace();
        }
        return msg;
    }
    //跟单修改
    //根据id查询一条值
    @RequestMapping("/mytoupdatea.do")
    public ModelAndView mytoupdatea(Integer did){
        ModelAndView modelAndView=new ModelAndView();
        Documentary documentary= iDocumentaryService.getById(did);
        List<Newbusiness> bulist = newbusinessService.list(new QueryWrapper<Newbusiness>());
        modelAndView.addObject("bulist",bulist);
        modelAndView.addObject("documentary",documentary);
        modelAndView.setViewName("/mydocuupdat.html");
        return modelAndView;
    }
    @RequestMapping("/myupdate.do")
    @ResponseBody
    public String update(Documentary documentary){
        String msg="1";
        try {
            iDocumentaryService.updateById(documentary);
        } catch (Exception e) {
            msg="2";
            e.printStackTrace();
        }
        return msg;
    }

}
