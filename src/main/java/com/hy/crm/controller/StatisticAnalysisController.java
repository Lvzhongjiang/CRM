package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.ContractManagement;
import com.hy.crm.entity.CountUtils;
import com.hy.crm.entity.Documentary;
import com.hy.crm.entity.Newbusiness;
import com.hy.crm.service.IContractManagementService;
import com.hy.crm.service.IDocumentaryService;
import com.hy.crm.service.INewbusinessService;
import com.hy.crm.util.DataUtile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class StatisticAnalysisController {
    @Autowired
    private INewbusinessService newbusinessService;
    @Autowired
    private IContractManagementService contractManagementService;
    @Autowired
    private IDocumentaryService documentaryService;

    @RequestMapping(value = "statisticAnalysisList.do")
    public String statisticAnalysisList(Model model){
        CountUtils countUtils=new CountUtils();
        //获取本周开始和结束
        String day=DataUtile.getTimeInterval(new Date());
        //获取上一周的开始和结束
        String day1=DataUtile.getLastTimeInterval();
        //获取本月时间的开始和结束
        String day2=DataUtile.getMonth();
        //获取上一个月的开始和结束
        String day3=DataUtile.getPreviousMonth();
        //获取本季度的开始和结束
        String day4=DataUtile.getThisQuarter();
        //获取上一个季度的开始与结束
        String day5=DataUtile.getLastQuarter();
        //本周商机数
        QueryWrapper<Newbusiness> queryWrapper=new QueryWrapper<>();
        queryWrapper.ge("ntime",day.split(",")[0]);
        queryWrapper.le("ntime",day.split(",")[1]);
        countUtils.setCount1(newbusinessService.list(queryWrapper).size());
        //上周商机数
        QueryWrapper<Newbusiness> queryWrapper1=new QueryWrapper<>();
        queryWrapper1.ge("ntime",day1.split(",")[0]);
        queryWrapper1.le("ntime",day1.split(",")[1]);
        countUtils.setCount2(newbusinessService.list(queryWrapper1).size());
        //本月商机数
        QueryWrapper<Newbusiness> queryWrapper6=new QueryWrapper<>();
        queryWrapper6.ge("ntime",day2.split(",")[0]);
        queryWrapper6.le("ntime",day2.split(",")[1]);
        countUtils.setCount7(newbusinessService.list(queryWrapper6).size());
        //上一个月商机数
        QueryWrapper<Newbusiness> queryWrapper7=new QueryWrapper<>();
        queryWrapper7.ge("ntime",day3.split(",")[0]);
        queryWrapper7.le("ntime",day3.split(",")[1]);
        countUtils.setCount8(newbusinessService.list(queryWrapper7).size());
        //获取本季度的商机数
        QueryWrapper<Newbusiness> queryWrapper13=new QueryWrapper<>();
        queryWrapper13.ge("ntime",day4.split(",")[0]);
        queryWrapper13.le("ntime",day4.split(",")[1]);
        countUtils.setCount13(newbusinessService.list(queryWrapper13).size());
        //获取上一个季度的商机数
        QueryWrapper<Newbusiness> queryWrapper14=new QueryWrapper<>();
        queryWrapper14.ge("ntime",day5.split(",")[0]);
        queryWrapper14.le("ntime",day5.split(",")[1]);
        countUtils.setCount14(newbusinessService.list(queryWrapper14).size());
        //获取本周成交数
        QueryWrapper<ContractManagement> queryWrapper3=new QueryWrapper<>();
        queryWrapper3.ge("contDate",day.split(",")[0]);
        queryWrapper3.le("contDate",day.split(",")[1]);
        countUtils.setCount3(contractManagementService.list(queryWrapper3).size());
        //获取上周成交数
        QueryWrapper<ContractManagement> queryWrapper4=new QueryWrapper<>();
        queryWrapper4.ge("contDate",day1.split(",")[0]);
        queryWrapper4.le("contDate",day1.split(",")[1]);
        countUtils.setCount4(contractManagementService.list(queryWrapper4).size());
        //获取本月成交数
        QueryWrapper<ContractManagement> queryWrapper8=new QueryWrapper<>();
        queryWrapper8.ge("contDate",day2.split(",")[0]);
        queryWrapper8.le("contDate",day2.split(",")[1]);
        countUtils.setCount9(contractManagementService.list(queryWrapper8).size());
        //获取上一个月成交数
        QueryWrapper<ContractManagement> queryWrapper9=new QueryWrapper<>();
        queryWrapper9.ge("contDate",day3.split(",")[0]);
        queryWrapper9.le("contDate",day3.split(",")[1]);
        countUtils.setCount10(contractManagementService.list(queryWrapper9).size());
        //获取本季度的成交数
        QueryWrapper<ContractManagement> queryWrapper15=new QueryWrapper<>();
        queryWrapper15.ge("contDate",day4.split(",")[0]);
        queryWrapper15.le("contDate",day4.split(",")[1]);
        countUtils.setCount15(contractManagementService.list(queryWrapper15).size());
        //获取上一个季度的成交数
        QueryWrapper<ContractManagement> queryWrapper16=new QueryWrapper<>();
        queryWrapper16.ge("contDate",day5.split(",")[0]);
        queryWrapper16.le("contDate",day5.split(",")[1]);
        countUtils.setCount16(contractManagementService.list(queryWrapper16).size());
        //获取本周跟单数
        QueryWrapper<Documentary> queryWrapper5=new QueryWrapper<>();
        queryWrapper5.ge("docudata",day.split(",")[0]);
        queryWrapper5.le("docudata",day.split(",")[1]);
        countUtils.setCount5(documentaryService.list(queryWrapper5).size());
        //获取上周跟单数
        QueryWrapper<Documentary> queryWrapper10=new QueryWrapper<>();
        queryWrapper10.ge("docudata",day1.split(",")[0]);
        queryWrapper10.le("docudata",day1.split(",")[1]);
        countUtils.setCount6(documentaryService.list(queryWrapper10).size());
        //获取本月跟单数
        QueryWrapper<Documentary> queryWrapper11=new QueryWrapper<>();
        queryWrapper11.ge("docudata",day2.split(",")[0]);
        queryWrapper11.le("docudata",day2.split(",")[1]);
        countUtils.setCount11(documentaryService.list(queryWrapper11).size());
        //获取上一个月跟单数
        QueryWrapper<Documentary> queryWrapper12=new QueryWrapper<>();
        queryWrapper12.ge("docudata",day3.split(",")[0]);
        queryWrapper12.le("docudata",day3.split(",")[1]);
        countUtils.setCount12(documentaryService.list(queryWrapper12).size());
        //获取本季度的跟单数
        QueryWrapper<Documentary> queryWrapper17=new QueryWrapper<>();
        queryWrapper17.ge("docudata",day4.split(",")[0]);
        queryWrapper17.le("docudata",day4.split(",")[1]);
        countUtils.setCount17(documentaryService.list(queryWrapper17).size());
        //获取上一个季度的跟单数
        QueryWrapper<Documentary> queryWrapper18=new QueryWrapper<>();
        queryWrapper18.ge("docudata",day5.split(",")[0]);
        queryWrapper18.le("docudata",day5.split(",")[1]);
        countUtils.setCount18(documentaryService.list(queryWrapper18).size());
        model.addAttribute("countUtils",countUtils);
        return "/statisticalchart/query.html";
    }
}
