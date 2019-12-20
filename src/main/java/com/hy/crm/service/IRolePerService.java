package com.hy.crm.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.entity.RolePer;
import com.hy.crm.entity.UserRole;

import java.util.List;

public interface IRolePerService extends IService<RolePer> {
    List<String> getRoleByNumber(Integer number);
    public void updata(RolePer rolePer, String[] pers);
}