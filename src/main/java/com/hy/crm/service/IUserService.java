package com.hy.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crm.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
public interface IUserService extends IService<User> {
    public void saves(User user);
    IPage<User> queryPage(Integer pageNum, Integer size);
}
