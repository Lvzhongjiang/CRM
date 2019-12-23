package com.hy.crm.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crm.entity.Client;
import com.hy.crm.entity.ContractManagement;
import com.hy.crm.entity.InvoiceApplication;
import com.hy.crm.entity.RegisterIncome;
import com.hy.crm.mapper.RegisterIncomeMapper;
import com.hy.crm.service.IClientService;
import com.hy.crm.service.IContractManagementService;
import com.hy.crm.service.IInvoiceApplicationService;
import com.hy.crm.service.IRegisterIncomeService;
import com.hy.crm.util.LayuiData;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Controller
@RequestMapping("/crm/contract-management")
public class ContractManagementController {
    @Autowired
    private IContractManagementService iContractManagementService;
    @Autowired
    private IClientService iClientService;
    @Autowired
    private IRegisterIncomeService iRegisterIncomeService;
    @Autowired
    private IInvoiceApplicationService iInvoiceApplicationService;

    /**
     * 查询
     *
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping("/contractList.do")
    public LayuiData contractList(String status,String heTong, String keyword, Integer page, Integer limit) {
        IPage<ContractManagement> iPage = iContractManagementService.queryPage(status,heTong, keyword, page, limit);
        LayuiData layui = new LayuiData();
        layui.setCode(0);
        layui.setMsg("");
        Long l = iPage.getTotal();
        layui.setCount(l.intValue());
        layui.setData(iPage.getRecords());
        return layui;

    }

    /**
     * 去添加
     *
     * @return
     */
    @RequiresRoles(value = {"管理员","项目经理","组长"},logical = Logical.OR)
    @RequestMapping("/toAddContractList.do")
    public ModelAndView toAddContractList(String contName) {
        ModelAndView modelAndView = new ModelAndView();
        List<Client> clients = iClientService.lindList();
        ContractManagement contractManagement = iContractManagementService.queryName(contName);
        modelAndView.addObject("contractManagement", contractManagement);
        modelAndView.addObject("clients", clients);
        modelAndView.setViewName("contract/addHeTongDaYin.html");
        return modelAndView;
    }

    /**
     * 添加
     *
     * @param
     * @param //client
     * @return
     */
    @RequestMapping("/addContractList.do")
    @ResponseBody
    public String addContractList(ContractManagement contractManagement, Client client) {
        String is = "1";
        try {
            iContractManagementService.save(contractManagement);
            iClientService.save(client);
        } catch (Exception e) {
            is = "2";
            e.printStackTrace();
        }
        return is;
    }
    @RequiresRoles(value = {"管理员","项目经理","组长"},logical = Logical.OR)
    @RequestMapping("/toUpdateContractList.do")
    public ModelAndView toUpdateContractList(String contName) {
        ModelAndView modelAndView = new ModelAndView();
        ContractManagement contractManagement = iContractManagementService.queryName(contName);
        modelAndView.addObject("contractManagement", contractManagement);
        List<Client> clients = iClientService.lindList();
        modelAndView.addObject("clients", clients);
        modelAndView.setViewName("contract/updateHeTongDaYin.html");
        return modelAndView;
    }


    @RequestMapping("/updateContractList.do")
    @ResponseBody
    public String UpdateContractList(ContractManagement contractManagement, Client client) {
        System.out.println("-------" + contractManagement + "--------" + client);
        String is = "1";
        try {
            iContractManagementService.updateById(contractManagement);
            iClientService.updateById(client);
        } catch (Exception e) {
            is = "2";
            e.printStackTrace();
        }
        return is;
    }
    @RequiresRoles(value = {"管理员","项目经理","组长"},logical = Logical.OR)
    @RequestMapping("/selectContractList.do")
    public ModelAndView selectContractList(String contName) {
        ModelAndView modelAndView = new ModelAndView();
        ContractManagement contractManagement = iContractManagementService.queryName(contName);
        modelAndView.addObject("contractManagement", contractManagement);
        List<Client> clients = iClientService.lindList();
        modelAndView.addObject("clients", clients);
        modelAndView.setViewName("contract/selectHeTongDaYin.html");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/cist.do")
    public Integer cist() {
        return iContractManagementService.listZx();

    }

    @ResponseBody
    @RequestMapping("/listYg.do")
    public Integer listYg() {
        return iContractManagementService.listYg();
    }
    @ResponseBody
    @RequestMapping("/listYc.do")
    public Integer listYc() {
        return iContractManagementService.listYc();
    }
    @ResponseBody
    @RequestMapping("/listYz.do")
    public Integer listYz() {
        return iContractManagementService.listYz();
    }
    @ResponseBody
    @RequestMapping("/listBenZhou.do")
    public Integer listBenZhou() {
        return iContractManagementService.listBenZhou();
    }
    @ResponseBody
    @RequestMapping("/listShangZhou.do")
    public Integer listShangZhou() {
        return iContractManagementService.listShangZhou();
    }
    @ResponseBody
    @RequestMapping("/listBenYue.do")
    public Integer listBenYue() {
        return iContractManagementService.listBenYue();
    }
    @ResponseBody
    @RequestMapping("/listShangYue.do")
    public Integer listShangYue() {
        return iContractManagementService.listShangYue();
    }
    @ResponseBody
    @RequestMapping("/listBenJiDu.do")
    public Integer listBenJiDu() {
        return iContractManagementService.listBenJiDu();
    }  @ResponseBody
    @RequestMapping("/listShangJiDu.do")
    public Integer listShangJiDu() {
        return iContractManagementService.listShangJiDu();
    }
}
