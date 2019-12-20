package com.hy.crm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.entity.ContractManagement;
import com.hy.crm.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.sql.ContractSql;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
public interface UserMapper extends BaseMapper<User> {
    @Insert("insert into user(uid,number,password,title)values(#{uid},#{number},#{password},#{title})")
    @SelectKey(statement="select LAST_INSERT_ID()",keyProperty="uid",keyColumn = "uid",before = true,resultType = Integer.class)
    public void inser(User user);

    @Select("select * from user ")
    public List<User> queryAll(Page<User> page);
}
