package com.hy.crm.service.impl;

import com.hy.crm.entity.Permission;
import com.hy.crm.mapper.PermissionMapper;
import com.hy.crm.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    public List<String> getPname(String name){
        return permissionMapper.getPname(name);
    }
}
