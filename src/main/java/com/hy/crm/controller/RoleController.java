package com.hy.crm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.entity.Role;
import com.hy.crm.entity.User;
import com.hy.crm.service.IRoleService;
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

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */

@RequestMapping("/role")
@Controller
public class RoleController {

    @Autowired
    private IRoleService iRoleService;
    /**
     * 用户管理  查询
     */
    @ResponseBody
    @RequestMapping("/roleList.do")
    public LayuiData roleList( Integer page, Integer limit) {
        Page<Role> page1 = new Page(page,limit);
        IPage<Role> iPage = iRoleService.page(page1,new QueryWrapper<Role>());
        LayuiData layui = new LayuiData();
        layui.setCode(0);
        layui.setMsg("");
        Long l = iPage.getTotal();
        layui.setCount(l.intValue());
        layui.setData(iPage.getRecords());
        return layui;

    }
}
