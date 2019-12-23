package com.hy.crm.mapper;

import com.hy.crm.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
public interface PermissionMapper extends BaseMapper<Permission> {
    @Select("SELECT p.perUrl FROM permission p WHERE p.perId " +
            "IN (SELECT rp.pid FROM role_per rp WHERE rp.roleid " +
            "IN(SELECT r.roleId FROM role r WHERE r.roleName IN(#{name})))")
    public List<String> getPname(String name);
}
