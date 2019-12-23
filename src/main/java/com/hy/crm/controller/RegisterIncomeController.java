package com.hy.crm.controller;


import com.hy.crm.entity.Client;
import com.hy.crm.entity.ContractManagement;
import com.hy.crm.entity.RegisterIncome;
import com.hy.crm.service.IContractManagementService;
import com.hy.crm.service.IRegisterIncomeService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@RequestMapping("/crm/register-income")
public class RegisterIncomeController {
    @Autowired
    private IRegisterIncomeService iRegisterIncomeService;

    /**
     * 去添加
     *
     * @return
     */
    @RequestMapping("/toAddRegisterList.do")
    @RequiresRoles(value = {"管理员","项目经理"},logical = Logical.OR)
    public ModelAndView toAddRegisterList(String contName) {
        ModelAndView modelAndView = new ModelAndView();
        ContractManagement contract = iRegisterIncomeService.contId(contName);
        modelAndView.addObject("contract", contract);
        modelAndView.setViewName("contract/addRegister.html");
        return modelAndView;
    }

    /**
     * 添加
     *
     * @param
     * @param //client
     * @return
     */
    @RequestMapping("/addRegisterList.do")
    @ResponseBody
    public String addRegisterList(RegisterIncome registerIncome) {
        String is = "1";
        try {
            iRegisterIncomeService.saveR(registerIncome);
        } catch (Exception e) {
            is = "2";
            e.printStackTrace();
        }
        return is;
    }
}
