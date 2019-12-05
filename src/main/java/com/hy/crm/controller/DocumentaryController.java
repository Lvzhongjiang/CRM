package com.hy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.entity.Documentary;
import com.hy.crm.service.IDocumentaryService;
import com.hy.crm.util.LayuiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@Controller
@RequestMapping("/documentary")
public class DocumentaryController{
    @Autowired
    private IDocumentaryService iDocumentaryService;
    @RequestMapping("/dolis.do")
    @ResponseBody
    public LayuiData dolist(Integer page,Integer limit){
        Page<Documentary> docuPage=new Page<>(page,limit);
        IPage<Documentary> iPage = iDocumentaryService.page(docuPage, new QueryWrapper<Documentary>());
        LayuiData layuiData=new LayuiData();
        layuiData.setCode(0);
        layuiData.setMsg("");
        Long l= iPage.getTotal();
        layuiData.setCount(l.intValue());
        layuiData.setData(iPage.getRecords());
        return layuiData;
    }
    @RequestMapping("/toseave.do")
    public ModelAndView toseave(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("/docuadd.html");
        return modelAndView;
    }
    @RequestMapping("/seave.do")
    @ResponseBody
    public String seave(Documentary documentary){
        String msg="1";
        try {
            iDocumentaryService.save(documentary);
        } catch (Exception e) {
            msg="2";
            e.printStackTrace();
        }
        return msg;
    }
    //跟单修改
    //根据id查询一条值
    @RequestMapping("/toupdatea.do")
    public ModelAndView toupdatea(Integer id){
        ModelAndView modelAndView=new ModelAndView();
       Documentary documentary= iDocumentaryService.getById(id);
        modelAndView.addObject("documentary",documentary);
        modelAndView.setViewName("docuupdat.html");
        return modelAndView;
    }
    public String update(){
        iDocumentaryService.update(new Documentary(),new UpdateWrapper<Documentary>());
        return "";
    }

}
