package com.hy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.entity.Client;
import com.hy.crm.entity.ContractManagement;
import com.hy.crm.entity.Datetype;
import com.hy.crm.service.IDatetypeService;
import com.hy.crm.util.LayuiData;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@RestController
@RequestMapping("/crm/datetype")
public class DatetypeController{

    @Autowired
    private IDatetypeService iDatetypeService;

    /**
     * 查询
     *
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping("/dateTypeList.do")
    public LayuiData dateTypeList(Integer page, Integer limit) {
        Page<Datetype> page1 = new Page<>(page,limit);
        IPage<Datetype> iPage = iDatetypeService.page(page1,new QueryWrapper<Datetype>());
        LayuiData layui = new LayuiData();
        layui.setCode(0);
        layui.setMsg("");
        Long l = iPage.getTotal();
        layui.setCount(l.intValue());
        layui.setData(iPage.getRecords());
        return layui;

    }
    /**
     * 添加
     *
     * @param
     * @param //client
     * @return
     */
    @PostMapping("/addDateType.do")
    @ResponseBody
    public String addDateType(Datetype datetype) {
        String is = "1";
        try {
            iDatetypeService.save(datetype);
        } catch (Exception e) {
            is = "2";
            e.printStackTrace();
        }
        return is;
    }
    @RequiresRoles(value = {"管理员","项目经理","组长"},logical = Logical.OR)
    @RequestMapping("/toUpdateDateTypeList.do")
    public ModelAndView toUpdateDateTypeList(Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        Datetype datetype  = iDatetypeService.getById(id);
        modelAndView.addObject("datetype", datetype);
        modelAndView.setViewName("datetype/update.html");
        return modelAndView;
    }


    @RequestMapping("/updateDateType.do")
    @ResponseBody
    public String updateDateType(Datetype datetype) {
        String is = "1";
        try {
            iDatetypeService.updateById(datetype);
        } catch (Exception e) {
            is = "2";
            e.printStackTrace();
        }
        return is;
    }
    @RequiresRoles(value = {"管理员","项目经理","组长"},logical = Logical.OR)
    @RequestMapping(value = "/deleteDateType.do")
    @ResponseBody
    public String deleteDateType(Integer id) {
        String is = "1";
        try {
            iDatetypeService.removeById(id);
        } catch (Exception e) {
            is = "2";
            e.printStackTrace();
        }
        return is;
    }
}
