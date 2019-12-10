package com.hy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.entity.*;
import com.hy.crm.service.IAftersaleService;
import com.hy.crm.service.IClientService;
import com.hy.crm.service.IContractManagementService;
import com.hy.crm.service.IDatetypeService;
import com.hy.crm.util.DateType;
import com.hy.crm.util.LayuiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
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
            if(!"-1".equals(id)){
                aftersaleQueryWrapper.eq("status",id);
            }
        }
        IPage<Aftersale> iPage=iAftersaleService.page(aftersalePage,aftersaleQueryWrapper);
        for(Aftersale aftersale:iPage.getRecords()){
            System.err.println(aftersale.getServicescore()+"----");
        }
        LayuiData layuiData=new LayuiData();
        layuiData.setCode(0);
        layuiData.setMsg("");
        Long l=iPage.getTotal();
        layuiData.setCount(l.intValue());
        layuiData.setData(iPage.getRecords());
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
}
