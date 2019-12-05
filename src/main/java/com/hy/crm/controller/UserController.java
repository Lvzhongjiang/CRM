package com.hy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.User;
import com.hy.crm.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    public String  Log(@RequestParam("number")String number,@RequestParam("password")String password){
        UsernamePasswordToken Token=new UsernamePasswordToken(number,password);
        Subject subject= SecurityUtils.getSubject();
        subject.login(Token);
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
}
