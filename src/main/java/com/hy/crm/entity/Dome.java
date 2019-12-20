package com.hy.crm.entity;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.github.pagehelper.util.StringUtil;

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
    public  String busquerr(String nname,String stage,String principal,String branch,Integer perdictmoney ){
        StringBuffer sql=new StringBuffer("select * from newbusiness where 1=1 ");
        if(!StringUtil.isEmpty(nname)){
            sql.append(" and nname like'%"+nname+"%'");
        }
        if(!StringUtil.isEmpty(stage)){
            sql.append(" and stage like'%"+stage+"%'");
        }
        if(!StringUtil.isEmpty(principal)){
            sql.append(" and principal like'%"+principal+"%'");
        }
        if(!StringUtil.isEmpty(branch)){
            sql.append(" and branch like'%"+branch+"%'");
        }
        if(perdictmoney!=null && !"".equals(perdictmoney)){
            sql.append(" and perdictmoney like'%"+perdictmoney+"%'");
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
