package com.hy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crm.entity.User;
import com.hy.crm.service.IUserService;
import com.hy.crm.util.LayuiData;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */

@RequestMapping("/user")
@Controller
public class UserController{
    //登录
    @Autowired
    private IUserService userService;
    @RequestMapping("/log.do")
    public String  Log(@RequestParam("number")String number, @RequestParam("password")String password, HttpServletRequest request){
        UsernamePasswordToken Token=new UsernamePasswordToken(number,password);
        Subject subject= SecurityUtils.getSubject();
        subject.login(Token);
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("number",number);
        User user=userService.getOne(queryWrapper);
        request.getSession().setAttribute("user1",user);
       User users=userService.getOne(new QueryWrapper<User>());
       subject.getSession().setAttribute("users",users);
        return "redirect:/index.html";

    }
    //注册
    @RequestMapping("/reis.do")
    public String reis(User user){
        userService.saves(user);
        return "redirect:/login.html";
    }


    /**
     * 用户管理  查询
     */
    @ResponseBody
    @RequestMapping("/UserList.do")
    public LayuiData UserList(Integer page, Integer limit) {
        IPage<User> iPage = userService.queryPage(page, limit);
        LayuiData layui = new LayuiData();
        layui.setCode(0);
        layui.setMsg("");
        Long l = iPage.getTotal();
        layui.setCount(l.intValue());
        layui.setData(iPage.getRecords());
        return layui;

    }
}
