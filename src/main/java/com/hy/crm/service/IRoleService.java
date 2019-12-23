package com.hy.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.entity.Role;
import com.hy.crm.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
public interface IRoleService extends IService<Role> {
    List<String> byName_RoleName(String userName);
}
