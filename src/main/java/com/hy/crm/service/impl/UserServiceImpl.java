package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.entity.ContractManagement;
import com.hy.crm.entity.User;
import com.hy.crm.mapper.UserMapper;
import com.hy.crm.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    public void saves(User user){
        userMapper.inser(user);
    }

    public IPage<User> queryPage(Integer pageNum, Integer size) {
        Page<User> page = new Page<>(pageNum,size);
        page.setRecords(userMapper.queryAll(page));
        return page;
    }
}
