package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.entity.RolePer;
import com.hy.crm.entity.UserRole;
import com.hy.crm.mapper.RolePerMapper;
import com.hy.crm.mapper.UserRoleMapper;
import com.hy.crm.service.IRolePerService;
import com.hy.crm.service.IUserRoleService;
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
public class RolePerServiceImpl extends ServiceImpl<RolePerMapper, RolePer> implements IRolePerService {
   @Autowired
    private RolePerMapper rolePerMapper;
    @Override
   public List<String> getRoleByNumber(Integer roleId){
        return rolePerMapper.getPerByRoleName(roleId);
    }

    /**
     * 更新用户权限
     * @param
     */
    public void updata(RolePer rolePer, String[] pers) {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("roleId", rolePer.getRoleId());
        rolePerMapper.delete(updateWrapper);
        if (null != pers && pers.length > 0) {
            for (String perId : pers) {
                rolePer.setPid(Integer.parseInt(perId));
                rolePerMapper.insert(rolePer);
            }
        }
    }
}
