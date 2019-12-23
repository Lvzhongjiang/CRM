package com.hy.crm.entity;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.util.StringUtil;
import com.hy.crm.bo.Busbo;
import org.apache.ibatis.annotations.Param;

public class Dome {
   /* public  String classif(String typeid){
        StringBuffer sql=new StringBuffer("select * from client where 1=1 ");
        if(null!=typeid){
         sql.append(" and typeid like'%"+typeid+"%'");
     }
        return sql.toString();
    }*/
    public String domesql(String cha,String xie){
        StringBuffer sql =new StringBuffer("select * from client where 1=1 ");
        System.out.println("==================================================================");
        if(null!=cha && !"".equals(cha) && null!=xie &&!"".equals(xie) &&"customername".equals(cha)){
            sql.append(" and customername like '%"+xie+"%'");
        }
        if(null!=cha && !"".equals(cha) && null!=xie && "source".equals(cha)){
            sql.append(" and source like '%"+xie+"%'");
        }
        if(null!=cha && !"".equals(cha) && null!=xie && "city".equals(cha)){
            sql.append(" and city like '%"+xie+"%'");
        }
        if(null!=cha && !"".equals(cha) && null!=xie && "industry".equals(cha)){
            sql.append(" and industry like '%"+xie+"%'");
        }
        if(null!=cha && !"".equals(cha) && null!=xie && "classif".equals(cha)){
            sql.append(" and classif like '%"+xie+"%'");
        }
        return sql.toString();
    }
    public  String busquerr(@Param("bus") Newbusiness newbusiness,@Param("cid") Integer cid,@Param("name") String name){
        StringBuffer sql=new StringBuffer("select * from newbusiness where 1=1 ");
        if(!StringUtil.isEmpty(newbusiness.getNname())){
            sql.append(" and nname like'%"+newbusiness.getNname()+"%'");
        }
        if(!StringUtil.isEmpty(newbusiness.getStage())){
            sql.append(" and stage like'%"+newbusiness.getStage()+"%'");
        }
        if(!StringUtil.isEmpty(newbusiness.getBranch())){
            sql.append(" and branch like'%"+newbusiness.getBranch()+"%'");
        }
        if(newbusiness.getPerdictmoney()!=null && !"".equals(newbusiness.getPerdictmoney())){
            sql.append(" and perdictmoney like'%"+newbusiness.getPerdictmoney()+"%'");
        }
         if(null != newbusiness.getCid()){
            sql.append(" and cid=" + newbusiness.getCid());
        }
         if(null!=name&&!"".equals(name)){
             sql.append(" and principal like'%"+newbusiness.getPrincipal()+"%'");
         }

        return sql.toString();
    }


    public  String mybusquerr(String nname,String stage,String principal,String branch,Integer perdictmoney,@Param("username") String username){
        StringBuffer sql=new StringBuffer("select * from newbusiness where 1=1 ");
        if(!StringUtil.isEmpty(nname)){
            sql.append(" and nname like'%"+nname+"%'");
        }
        if(!StringUtil.isEmpty(stage)){
            sql.append(" and stage like'%"+stage+"%'");
        }
        /*if(!StringUtil.isEmpty(principal)){
            sql.append(" and principal like'%"+principal+"%'");
        }*/
        if(!StringUtil.isEmpty(branch)){
            sql.append(" and branch like'%"+branch+"%'");
        }
        if(perdictmoney!=null && !"".equals(perdictmoney)){
            sql.append(" and perdictmoney like'%"+perdictmoney+"%'");
        }
        if(username!=null && !"".equals(username)){
            sql.append(" and principal like'%"+username+"%'");
        }


        return sql.toString();
    }


    public String docm(String cha,String xie){
        StringBuffer sql =new StringBuffer("select * from documentary where 1=1 ");
        System.out.println("==================================================================");
        if(null!=cha && !"".equals(cha) && null!=xie &&!"".equals(xie) &&"docudate".equals(cha)){
            sql.append(" and docudate like '%"+xie+"%'");
        }
        if(null!=cha && !"".equals(cha) && null!=xie && "docutheme".equals(cha)){
            sql.append(" and docutheme like '%"+xie+"%'");
        }
        if(null!=cha && !"".equals(cha) && null!=xie && "dname".equals(cha)){
            sql.append(" and dname like '%"+xie+"%'");
        }
        return sql.toString();
    }
}
