package com.hy.crm.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.entity.UserRole;

import java.util.List;

public interface IUserRoleService  extends IService<UserRole> {
    List<String> getRoleByNumber(Integer number);
    public void updata(UserRole userRole, String[] roles);
}