package com.hy.crm.mapper;

import com.hy.crm.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;

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
}
