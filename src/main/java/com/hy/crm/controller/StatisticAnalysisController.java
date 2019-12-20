package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.*;
import com.hy.crm.service.*;
import com.hy.crm.util.DataUtile;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class StatisticAnalysisController {
    @Autowired
    private INewbusinessService newbusinessService;
    @Autowired
    private IContractManagementService contractManagementService;
    @Autowired
    private IDocumentaryService documentaryService;
    @Autowired
    private IAftersaleService aftersaleService;

    @Autowired
    private IDatetypeService datetypeService;
    @RequestMapping(value = "statisticAnalysisList.do")
    public String statisticAnalysisList(Model model, HttpServletRequest request){
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
        User user=(User) request.getSession().getAttribute("user1");
        model.addAttribute("name",user.getNumber());
        queryWrapper.ge("ntime",day.split(",")[0]);
        queryWrapper.le("ntime",day.split(",")[1]);
        queryWrapper.eq("uid",user.getUid());
        countUtils.setCount1(newbusinessService.list(queryWrapper).size());
        //上周商机数
        QueryWrapper<Newbusiness> queryWrapper1=new QueryWrapper<>();
        queryWrapper1.ge("ntime",day1.split(",")[0]);
        queryWrapper1.le("ntime",day1.split(",")[1]);
        queryWrapper1.eq("uid",user.getUid());
        countUtils.setCount2(newbusinessService.list(queryWrapper1).size());
        //本月商机数
        QueryWrapper<Newbusiness> queryWrapper6=new QueryWrapper<>();
        queryWrapper6.ge("ntime",day2.split(",")[0]);
        queryWrapper6.le("ntime",day2.split(",")[1]);
        queryWrapper6.eq("uid",user.getUid());
        countUtils.setCount7(newbusinessService.list(queryWrapper6).size());
        //上一个月商机数
        QueryWrapper<Newbusiness> queryWrapper7=new QueryWrapper<>();
        queryWrapper7.ge("ntime",day3.split(",")[0]);
        queryWrapper7.le("ntime",day3.split(",")[1]);
        queryWrapper7.eq("uid",user.getUid());
        countUtils.setCount8(newbusinessService.list(queryWrapper7).size());
        //获取本季度的商机数
        QueryWrapper<Newbusiness> queryWrapper13=new QueryWrapper<>();
        queryWrapper13.ge("ntime",day4.split(",")[0]);
        queryWrapper13.le("ntime",day4.split(",")[1]);
        queryWrapper13.eq("uid",user.getUid());
        countUtils.setCount13(newbusinessService.list(queryWrapper13).size());
        //获取上一个季度的商机数
        QueryWrapper<Newbusiness> queryWrapper14=new QueryWrapper<>();
        queryWrapper14.ge("ntime",day5.split(",")[0]);
        queryWrapper14.le("ntime",day5.split(",")[1]);
        queryWrapper14.eq("uid",user.getUid());
        countUtils.setCount14(newbusinessService.list(queryWrapper14).size());
        //获取本周成交数
        QueryWrapper<ContractManagement> queryWrapper3=new QueryWrapper<>();
        queryWrapper3.ge("contDate",day.split(",")[0]);
        queryWrapper3.le("contDate",day.split(",")[1]);
        queryWrapper3.eq("uid",user.getUid());
        countUtils.setCount3(contractManagementService.list(queryWrapper3).size());
        //获取上周成交数
        QueryWrapper<ContractManagement> queryWrapper4=new QueryWrapper<>();
        queryWrapper4.ge("contDate",day1.split(",")[0]);
        queryWrapper4.le("contDate",day1.split(",")[1]);
        queryWrapper4.eq("uid",user.getUid());
        countUtils.setCount4(contractManagementService.list(queryWrapper4).size());
        //获取本月成交数
        QueryWrapper<ContractManagement> queryWrapper8=new QueryWrapper<>();
        queryWrapper8.ge("contDate",day2.split(",")[0]);
        queryWrapper8.le("contDate",day2.split(",")[1]);
        queryWrapper8.eq("uid",user.getUid());
        countUtils.setCount9(contractManagementService.list(queryWrapper8).size());
        //获取上一个月成交数
        QueryWrapper<ContractManagement> queryWrapper9=new QueryWrapper<>();
        queryWrapper9.ge("contDate",day3.split(",")[0]);
        queryWrapper9.le("contDate",day3.split(",")[1]);
        queryWrapper9.eq("uid",user.getUid());
        countUtils.setCount10(contractManagementService.list(queryWrapper9).size());
        //获取本季度的成交数
        QueryWrapper<ContractManagement> queryWrapper15=new QueryWrapper<>();
        queryWrapper15.ge("contDate",day4.split(",")[0]);
        queryWrapper15.le("contDate",day4.split(",")[1]);
        queryWrapper15.eq("uid",user.getUid());
        countUtils.setCount15(contractManagementService.list(queryWrapper15).size());
        //获取上一个季度的成交数
        QueryWrapper<ContractManagement> queryWrapper16=new QueryWrapper<>();
        queryWrapper16.ge("contDate",day5.split(",")[0]);
        queryWrapper16.le("contDate",day5.split(",")[1]);
        queryWrapper16.eq("uid",user.getUid());
        countUtils.setCount16(contractManagementService.list(queryWrapper16).size());
        //获取本周跟单数
        QueryWrapper<Documentary> queryWrapper5=new QueryWrapper<>();
        queryWrapper5.ge("docudate",day.split(",")[0]);
        queryWrapper5.le("docudate",day.split(",")[1]);
        queryWrapper5.eq("uid",user.getUid());
        countUtils.setCount5(documentaryService.list(queryWrapper5).size());
        //获取上周跟单数
        QueryWrapper<Documentary> queryWrapper10=new QueryWrapper<>();
        queryWrapper10.ge("docudate",day1.split(",")[0]);
        queryWrapper10.le("docudate",day1.split(",")[1]);
        queryWrapper10.eq("uid",user.getUid());
        countUtils.setCount6(documentaryService.list(queryWrapper10).size());
        //获取本月跟单数
        QueryWrapper<Documentary> queryWrapper11=new QueryWrapper<>();
        queryWrapper11.ge("docudate",day2.split(",")[0]);
        queryWrapper11.le("docudate",day2.split(",")[1]);
        queryWrapper11.eq("uid",user.getUid());
        countUtils.setCount11(documentaryService.list(queryWrapper11).size());
        //获取上一个月跟单数
        QueryWrapper<Documentary> queryWrapper12=new QueryWrapper<>();
        queryWrapper12.ge("docudate",day3.split(",")[0]);
        queryWrapper12.le("docudate",day3.split(",")[1]);
        queryWrapper12.eq("uid",user.getUid());
        countUtils.setCount12(documentaryService.list(queryWrapper12).size());
        //获取本季度的跟单数
        QueryWrapper<Documentary> queryWrapper17=new QueryWrapper<>();
        queryWrapper17.ge("docudate",day4.split(",")[0]);
        queryWrapper17.le("docudate",day4.split(",")[1]);
        queryWrapper17.eq("uid",user.getUid());
        countUtils.setCount17(documentaryService.list(queryWrapper17).size());
        //获取上一个季度的跟单数
        QueryWrapper<Documentary> queryWrapper18=new QueryWrapper<>();
        queryWrapper18.ge("docudate",day5.split(",")[0]);
        queryWrapper18.le("docudate",day5.split(",")[1]);
        queryWrapper18.eq("uid",user.getUid());
        countUtils.setCount18(documentaryService.list(queryWrapper18).size());
        model.addAttribute("countUtils",countUtils);

        QueryWrapper<Datetype> queryWrapper2=new QueryWrapper<>();
        queryWrapper2.eq("type",8);
        List<Industry> industries=aftersaleService.industrySelect(datetypeService.list(queryWrapper2));

        QueryWrapper<Datetype> queryWrappers=new QueryWrapper<>();
        queryWrappers.eq("type",9);
        List<Industry> industriess=aftersaleService.sourceSelect(datetypeService.list(queryWrappers));

        request.getSession().setAttribute("industriess",industriess);
        request.getSession().setAttribute("industries",industries);
        model.addAttribute("industriess",industriess);
        model.addAttribute("industries",industries);
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        // 如果不需要四舍五入，可以使用RoundingMode.DOWN
        nf.setRoundingMode(RoundingMode.DOWN);
        NewCount newCount=aftersaleService.selectCount2();
        List<NewCount> newCounts= new ArrayList<>();
        List<NewCount> newCounts3= new ArrayList<>();
        for(int i=0;i<5;i++){
            aftersaleService.countSum(i);
            newCounts.add(aftersaleService.countSum(i));
        }
        for(NewCount count:newCounts){
            System.out.println(count);
                if(count.getC()<=0){
                    count.setC(0.0);
                    count.setCc("0.0%");
                }else{
                    count.setCc(nf.format(count.getC()/newCount.getC()*100)+"%");
                }

                if(count.getS()==null||count.getS()<=0){
                    count.setS(0.0);
                    count.setSs("0.0%");
                }else{
                    count.setSs(nf.format(count.getS()/newCount.getS()*100)+"%");
                }
            System.out.println("--"+count);
            newCounts3.add(count);
        }
        NewCount newCount2=aftersaleService.selectCount1(day4.split(",")[0],day4.split(",")[1]);
        List<NewCount> newCounts2= new ArrayList<>();
        List<NewCount> newCounts4= new ArrayList<>();
        for(int i=0;i<5;i++){
            newCounts2.add(aftersaleService.countSum1(i,day4.split(",")[0],day4.split(",")[1]));
        }
        System.out.println("------------"+newCount);
        System.out.println("------------"+newCount2);
        for(NewCount count:newCounts2){
            System.out.println(count);
            if(count.getC()<=0){
                count.setC(0.0);
                count.setCc("0.0%");
            }else{
                count.setCc(nf.format(count.getC()/newCount2.getC()*100)+"%");
            }

            if(count.getS()==null||count.getS()<=0){
                count.setS(0.0);
                count.setSs("0.0%");
            }else{
                count.setSs(nf.format(count.getS()/newCount2.getS()*100)+"%");
            }
            System.out.println("--"+count);
            newCounts4.add(count);
        }

        NewCount newCount3=aftersaleService.selectCount1(day5.split(",")[0],day5.split(",")[1]);
        List<NewCount> newCounts5= new ArrayList<>();
        List<NewCount> newCounts6= new ArrayList<>();
        for(int i=0;i<5;i++){
            newCounts5.add(aftersaleService.countSum1(i,day5.split(",")[0],day5.split(",")[1]));
        }
        for(NewCount count:newCounts5){
            System.out.println(count);
            if(count.getC()<=0){
                count.setC(0.0);
                count.setCc("0.0%");
            }else{
                count.setCc(nf.format(count.getC()/newCount3.getC()*100)+"%");
            }

            if(count.getS()==null||count.getS()<=0){
                count.setS(0.0);
                count.setSs("0.0%");
            }else{
                count.setSs(nf.format(count.getS()/newCount3.getS()*100)+"%");
            }
            System.out.println("--"+count);
            newCounts6.add(count);
        }
       //1
        model.addAttribute("newCounts",newCounts3);
        model.addAttribute("newCount",newCount);
        ///2
        model.addAttribute("newCounts2",newCounts4);
        model.addAttribute("newCount2",newCount2);
        ///3
        model.addAttribute("newCountss",newCounts6);
        model.addAttribute("newCount3",newCount3);
        request.getSession().setAttribute("newCounts",newCounts3);
        request.getSession().setAttribute("newCounts2",newCounts4);
        request.getSession().setAttribute("newCountss",newCounts6);
        return "/statisticalchart/query.html";
    }
    @RequestMapping(value = "t1.do",produces = "application/json; charset=utf-8")
    @ResponseBody
    public  List<Utils> myHomeAF(HttpServletRequest request){
        List<NewCount> newCountList=(List<NewCount>)request.getSession().getAttribute("newCounts");
        List<Utils> sums=new ArrayList<>();
        for(int i=0;i<5;i++){
            Utils utils=new Utils();
            utils.setMoneys(Integer.parseInt(newCountList.get(i).getSs().substring(0,newCountList.get(i).getCc().lastIndexOf("%"))));
            if(i==0){
                utils.setTitles("初期沟通");
            }
            if(i==1){
                utils.setTitles("方案和报价");
            }
            if(i==2){
                utils.setTitles("竞争或投标");
            }
            if(i==3){
                utils.setTitles("商务谈判");
            }if(i==4){
                utils.setTitles("成交");
            }
            sums.add(utils);
        }
        return sums;
    }

    @RequestMapping(value = "indu.do",produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<Integer> indu(HttpServletRequest request,Integer a){
        List<Industry> industries=(List<Industry>)request.getSession().getAttribute("industries");
        List<Integer> integers=new ArrayList<>();
        for(Industry industry:industries){
            if(a==0){
                integers.add(industry.getS());
            }else{
                integers.add(industry.getM());
            }
        }

        return integers;
    }

    @RequestMapping(value = "indu1.do",produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<TypeStatics> indu1(HttpServletRequest request,Integer a){
        List<Industry> industries=(List<Industry>)request.getSession().getAttribute("industries");
        List<TypeStatics> integers=new ArrayList<>();
        for(Industry industry:industries){
            if(a==0){
                TypeStatics object=new TypeStatics();
                object.setName(industry.getTitle());
                object.setValue(industry.getS());
                integers.add(object);
            }else{
                TypeStatics object=new TypeStatics();
                object.setName(industry.getTitle());
                object.setValue(industry.getM());
                integers.add(object);
            }
        }

        return integers;
    }

    @RequestMapping(value = "indu2.do",produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<Integer> indu2(HttpServletRequest request,Integer a){
        List<Industry> industries=(List<Industry>)request.getSession().getAttribute("industriess");
        List<Integer> integers=new ArrayList<>();
        for(Industry industry:industries){
            if(a==0){
                integers.add(industry.getS());
            }else{
                integers.add(industry.getM());
            }
        }

        return integers;
    }

    @RequestMapping(value = "indu3.do",produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<TypeStatics> indu3(HttpServletRequest request,Integer a){
        List<Industry> industries=(List<Industry>)request.getSession().getAttribute("industriess");
        List<TypeStatics> integers=new ArrayList<>();
        for(Industry industry:industries){
            if(a==0){
                TypeStatics object=new TypeStatics();
                object.setName(industry.getTitle());
                object.setValue(industry.getS());
                integers.add(object);
            }else{
                TypeStatics object=new TypeStatics();
                object.setName(industry.getTitle());
                object.setValue(industry.getM());
                integers.add(object);
            }
        }

        return integers;
    }

}
