package com.hy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.entity.Role;
import com.hy.crm.entity.RolePer;
import com.hy.crm.entity.UserRole;
import com.hy.crm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */

@RequestMapping("/rolePer")
@Controller
public class RolePerController {
    @Autowired
    private IRolePerService iRolePerService;
    @Autowired
    private IPermissionService iPermissionService;
    @Autowired
    private IRoleService iRoleService;
    /**
     * 根据用户id查询用户、用户角色、所有角色
     * @param
     * @return
     */
    @RequestMapping("/queryById.do")
    //@RequiresPermissions("userRole/queryById.do")
    public String  queryById(Integer roleId, Model model){
        Role role=iRoleService.getById(roleId);
        System.out.println(role);
        //根据id查询用户信息
        model.addAttribute("role",role);
        //查询所有角色信息
        model.addAttribute("perList",iPermissionService.listMaps(null));
        //根据id查询用户角色信息
        QueryWrapper queryWrapper=new QueryWrapper<UserRole>();
        queryWrapper.eq("roleId",roleId);
        model.addAttribute("rolePerList",iRolePerService.list(queryWrapper));
        return "permissions/settingPermissions.html";
    }

    /**
     * 更新用户角色
     */
    @RequestMapping("/update.do")
    @ResponseBody
    public String update(RolePer rolePer, String str){
        String i="1";
        try {
            iRolePerService.updata(rolePer,str.split(","));
        } catch (Exception e) {
            i="0";
            e.printStackTrace();
        }
        return i;
    }
}
