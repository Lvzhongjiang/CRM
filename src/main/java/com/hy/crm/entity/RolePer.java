package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class RolePer {

    private Integer roleId;

    private Integer pid;

    @TableField(exist = false)
    private String[] pers;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String[] getPers() {
        return pers;
    }

    public void setPers(String[] pers) {
        this.pers = pers;
    }
}