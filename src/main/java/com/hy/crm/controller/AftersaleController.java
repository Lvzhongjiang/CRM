package com.hy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.entity.*;
import com.hy.crm.service.*;
import com.hy.crm.util.DataUtile;
import com.hy.crm.util.DateType;
import com.hy.crm.util.LayuiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
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
public class AftersaleController{

    //售后服务service 接口
    @Autowired
    private IAftersaleService iAftersaleService;
    //数据类型service 接口
    @Autowired
    private IDatetypeService datetypeService;
    //客户 Service 接口
    @Autowired
    private IClientService clientService;

    @Autowired
    private INewbusinessService newbusinessService;
    /*
    * 合同 Service 接口
    * */
    @Autowired
    private IContractManagementService contractManagementService;
    /*
    * 查询所有售后服务
    * 可用于条件查询以及分组查询及列表
    * */
    @RequestMapping("afterSaleList.do")
    @ResponseBody
    public LayuiData  list(Integer page,Integer limit,String type,String title,String id){
        //获取本周开始和结束
        String day= DataUtile.getTimeInterval(new Date());
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
        Page<Aftersale> aftersalePage=new Page<>(page,limit);
        QueryWrapper<Aftersale> aftersaleQueryWrapper=new QueryWrapper<>();
        if(type!=null&&!"".equals(type)&&!"".equals(title)&&title!=null){
            if(type.equals("0")){
                aftersaleQueryWrapper.like("theme",title);
            }else if(type.equals("1")){
                aftersaleQueryWrapper.like("theme",title);
            }else if(type.equals("2")){
                QueryWrapper<Datetype> queryWrapper=new QueryWrapper<>();
                queryWrapper.eq("type", DateType.AFTERSALE_TYPESERVICE);
                queryWrapper.eq("title",title);
                List<Datetype> datetypeList=datetypeService.list(queryWrapper);
                List<Integer> integerList=new ArrayList<>();
                for(Datetype datetype:datetypeList){
                    integerList.add(datetype.getId());
                }
                aftersaleQueryWrapper.in("typeservice",integerList);
            }else if(type.equals("3")){
                /*aftersaleQueryWrapper.l*/
            }else if(type.equals("4")){
                aftersaleQueryWrapper.like("personnel",title);
            }else if(type.equals("5")){
                aftersaleQueryWrapper.eq("Servicescore",title);
            }
        }
        if(id!=null&&!"".equals(id)){
            if("0".equals(id)|"1".equals(id)|"2".equals(id)){
                aftersaleQueryWrapper.eq("status",id);
            }
            if("3".equals(id)){
                aftersaleQueryWrapper.ge("starttime",day.split(",")[0]);
                aftersaleQueryWrapper.le("starttime",day.split(",")[1]);
            }
            if("4".equals(id)){
                aftersaleQueryWrapper.ge("starttime",day1.split(",")[0]);
                aftersaleQueryWrapper.le("starttime",day1.split(",")[1]);
            }
            if("5".equals(id)){
                aftersaleQueryWrapper.ge("starttime",day2.split(",")[0]);
                aftersaleQueryWrapper.le("starttime",day2.split(",")[1]);
            }
            if("6".equals(id)){
                aftersaleQueryWrapper.ge("starttime",day3.split(",")[0]);
                aftersaleQueryWrapper.le("starttime",day3.split(",")[1]);
            }
            if("7".equals(id)){
                aftersaleQueryWrapper.ge("starttime",day4.split(",")[0]);
                aftersaleQueryWrapper.le("starttime",day4.split(",")[1]);
            }
            if("8".equals(id)){
                aftersaleQueryWrapper.ge("starttime",day5.split(",")[0]);
                aftersaleQueryWrapper.le("starttime",day5.split(",")[1]);
            }
        }


        IPage<Aftersale> iPage=iAftersaleService.page(aftersalePage,aftersaleQueryWrapper);
        List<Aftersale> aftersales=new ArrayList<>();
        for(Aftersale aftersale:iPage.getRecords()){
            QueryWrapper<Datetype> datetypeQueryWrapper=new QueryWrapper<>();
            datetypeQueryWrapper.eq("id",aftersale.getTypeservice());
            aftersale.setTypeservice(datetypeService.getOne(datetypeQueryWrapper).getTitle());
            aftersales.add(aftersale);
        }
        LayuiData layuiData=new LayuiData();
        layuiData.setCode(0);
        layuiData.setMsg("");
        Long l=iPage.getTotal();
        layuiData.setCount(l.intValue());
        layuiData.setData(aftersales);
        return layuiData;
    }

    /*
    *查询所有客户
    * 用户添加售后服务选择客户的下拉框
    * */
    @RequestMapping(value = "queryClient.do")
    @ResponseBody
    public List<Client>  queryClient(){
        return clientService.list(new QueryWrapper<Client>());
    }

    /*
     * 根据客户id查询出该客户的所有合同
     * */
    @RequestMapping(value = "queryCont.do")
    @ResponseBody
    public List<ContractManagement>  queryCont(String cid){
        QueryWrapper<ContractManagement> contractManagementQueryWrapper=new QueryWrapper<>();
        contractManagementQueryWrapper.eq("cid",cid);
        return contractManagementService.list(contractManagementQueryWrapper);
    }

    /*
     *查询所有售后服务类型
     * 用户添加售后服务服务类型的下拉框
     * */
    @RequestMapping(value = "modelServiceList.do")
    @ResponseBody
    public List<Datetype>  modelserviceList(){
        QueryWrapper<Datetype> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("type", DateType.AFTERSALE_TYPESERVICE);
        List<Datetype> datetypeList=datetypeService.list(queryWrapper);
        return datetypeList;
    }

    /*
     *查询所有售后服务方式
     * 用户添加售后服务服务方式的下拉框
     * */
    @RequestMapping(value = "typeServiceList.do")
    @ResponseBody
    public List<Datetype>  typeServiceList(){
        QueryWrapper<Datetype> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("type", DateType.AFTERSALE_MODELSERVICE);
        List<Datetype> datetypeList=datetypeService.list(queryWrapper);
        return datetypeList;
    }

    /*
     *
     * 生成合同主要信息
     * */
    @RequestMapping(value = "contMessage.do",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  contMessage(String cid){
        QueryWrapper<ContractManagement> contractManagementQueryWrapper=new QueryWrapper<>();
        contractManagementQueryWrapper.eq("contId",cid);
        ContractManagement contractManagement=contractManagementService.getOne(contractManagementQueryWrapper);
        /*
        * 【合同全称】江西南昌机电有限公司-ＰＭ系统    【合同所属部门】销售部    【关联人员】李萌,
            contName                                  coll_term               relat_per
           【签约日期】2015/12/12    【生效日期】    【合同状态】执行中    【服务期至】2016/12/12
            contDate                 commenDate                          viability
        * */
        StringBuilder stringBuilder=new StringBuilder("【合同全称】"+contractManagement.getContName()+"   【合同所属部门】"+
                contractManagement.getCollTerm()+"    【关联人员】"+contractManagement.getRelatPer()+",\n【签约日期】"+
                contractManagement.getContDate()+"    【生效日期】"+contractManagement.getCommenDate()+"    【合同状态】执行中" +
                "    【服务期至】"+contractManagement.getViability());
        return stringBuilder.toString();
    }

    @RequestMapping(value = "afterSaleSave.do")
    @ResponseBody
    public String afterSaleSave(Aftersale aftersale,HttpServletRequest request) {
        String is = "0";
        aftersale.setAttachment((String) request.getSession().getAttribute("filename"));
        Boolean b = iAftersaleService.save(aftersale);
        if (b) {
            is = "1";
        }
        return is;
    }

    @RequestMapping(value = "afterSaleXQ.do")
    public String afterSaleXQ(Model model,Integer id) {
        AfterSaleBo afterSaleBo=iAftersaleService.selectByAid(id);
        String modelService=afterSaleBo.getModelservice();
        QueryWrapper<Datetype> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",modelService);
        afterSaleBo.setModelservice(datetypeService.getOne(queryWrapper).getTitle());
        model.addAttribute("aftersale",afterSaleBo);
        return "/aftersale/AfterSaleXQ.html";
    }

    @RequestMapping(value = "myHome.do")
    public String myHome(Model model) {
        model.addAttribute("clientCount",clientService.list(new QueryWrapper<Client>()).size());
        model.addAttribute("businessCount",newbusinessService.list(new QueryWrapper<Newbusiness>()).size());
        model.addAttribute("contractCount",clientService.list(new QueryWrapper<Client>()).size());
        return "/aftersale/mydesktop.html";
    }
    @RequestMapping(value = "myHomeAF.do",produces = "application/json; charset=utf-8")
    @ResponseBody
    public  List<Utils> myHomeAF(){

        List<Utils> sums=new ArrayList<>();
        for(int i=0;i<4;i++){
            Utils utils=new Utils();
            utils.setMoneys(iAftersaleService.countSum(i).getS().intValue());
            if(i==0){
                utils.setTitles("已成交");
            }
            if(i==1){
                utils.setTitles("已搁置");
            }
            if(i==2){
                utils.setTitles("已丢单");
            }
            if(i==3){
                utils.setTitles("进行中");
            }
            sums.add(utils);
        }
        return sums;
    }
}
