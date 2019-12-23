package com.hy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crm.entity.User;
import com.hy.crm.entity.UserRole;
import com.hy.crm.service.IRoleService;
import com.hy.crm.service.IUserRoleService;
import com.hy.crm.service.IUserService;
import com.hy.crm.service.impl.UserServiceImpl;
import com.hy.crm.util.LayuiData;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */

@RequestMapping("/userRole")
@Controller
public class UserRoleController {
    @Autowired
    private IUserRoleService iUserRoleService;
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IRoleService iRoleService;
    /**
     * 根据用户id查询用户、用户角色、所有角色
     * @param uid
     * @return
     */
    @RequiresRoles(value = {"管理员"})
    @RequestMapping("/queryById.do")
    public String  queryById(Integer uid, Model model){
        //根据id查询用户信息
        model.addAttribute("user",iUserService.getById(uid));
        //查询所有角色信息
        model.addAttribute("roleList",iRoleService.listMaps(null));
        //根据id查询用户角色信息
        QueryWrapper queryWrapper=new QueryWrapper<UserRole>();
        queryWrapper.eq("uid",uid);
        model.addAttribute("userRoleList",iUserRoleService.list(queryWrapper));
        return "/permissions/settingRole.html";
    }

    /**
     * 更新用户角色
     */
    @RequestMapping("/update.do")
    @ResponseBody
    public String update(UserRole userRole, String str){
        String i="1";
        try {
            iUserRoleService.updata(userRole,str.split(","));
        } catch (Exception e) {
            i="0";
            e.printStackTrace();
        }
        return i;
    }

}
