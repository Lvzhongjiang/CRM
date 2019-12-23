package com.hy.crm.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.entity.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {
    @Select("SELECT r.roleName FROM role r WHERE r.roleId " +
            "IN(SELECT ur.roleId FROM user_role ur WHERE " +
            "ur.uid=(SELECT u.uid FROM USER u WHERE u.number=#{userName}))")
    public List<String> byName_RoleName(String userName);
}