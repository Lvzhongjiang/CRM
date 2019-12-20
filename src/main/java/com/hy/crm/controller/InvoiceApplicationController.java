package com.hy.crm.controller;


import com.hy.crm.entity.ContractManagement;
import com.hy.crm.entity.InvoiceApplication;
import com.hy.crm.service.IInvoiceApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@RestController
@RequestMapping("/crm/invoice-application")
public class InvoiceApplicationController{
    @Autowired
    private IInvoiceApplicationService iInvoiceApplicationService;

    /**
     * 去添加
     *
     * @return
     */
    @RequestMapping("/toAddInvoiceList.do")
    public ModelAndView toAddInvoiceList(String contName) {
        ModelAndView modelAndView = new ModelAndView();
        ContractManagement contract = iInvoiceApplicationService.contId(contName);
        modelAndView.addObject("contract", contract);
        modelAndView.setViewName("contract/addInvoiceApplication.html");
        return modelAndView;
    }

    /**
     * 添加
     *
     * @param
     * @param //client
     * @return
     */
    @RequestMapping("/addInvoiceList.do")
    @ResponseBody
    public String addInvoiceList(InvoiceApplication invoiceApplication) {
        String is = "1";
        try {
            iInvoiceApplicationService.saveInvoice(invoiceApplication);
        } catch (Exception e) {
            is = "2";
            e.printStackTrace();
        }
        return is;
    }
}
