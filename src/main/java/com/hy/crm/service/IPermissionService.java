package com.hy.crm.service;

import com.hy.crm.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
public interface IPermissionService extends IService<Permission> {
    public List<String> getPname(String name);
}
