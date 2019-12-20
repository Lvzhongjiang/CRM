package com.hy.crm.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.entity.UserRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserRoleMapper extends BaseMapper<UserRole> {
    @Select("select roleName from role r inner join user_role ur on r.roleId = ur.roleId inner join user u on ur.uid=u.uid where uid=#{uid}")
    List<String> getRoleByNumber(Integer uid);
}