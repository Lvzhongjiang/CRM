package com.hy.crm.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.entity.RolePer;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RolePerMapper extends BaseMapper<RolePer> {
    @Select("select perName from role r inner join role_per rp on r.roleId = rp.roleId inner join permission p on rp.perId=p.perId where roleId=#{roleId}")
    List<String> getPerByRoleName(Integer roleId);
}