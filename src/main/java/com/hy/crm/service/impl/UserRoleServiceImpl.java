package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.User;
import com.hy.crm.entity.UserRole;
import com.hy.crm.mapper.UserMapper;
import com.hy.crm.mapper.UserRoleMapper;
import com.hy.crm.service.IUserRoleService;
import com.hy.crm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper,UserRole> implements IUserRoleService {
   @Autowired
    private UserRoleMapper userRoleMapper;
    @Override
   public List<String> getRoleByNumber(Integer number){
        return userRoleMapper.getRoleByNumber(number);
    }

    /**
     * 更新用户角色
     * @param userRole
     */
    public void updata(UserRole userRole, String[] roles) {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("uid", userRole.getUid());
        userRoleMapper.delete(updateWrapper);
        if (null != roles && roles.length > 0) {
            for (String roleid : roles) {
                userRole.setRoleId(Integer.parseInt(roleid));
                userRoleMapper.insert(userRole);
            }
        }
    }
}
