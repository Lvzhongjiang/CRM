package com.hy.crm.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.entity.ContractManagement;
import com.hy.crm.entity.ForumManagement;
import com.hy.crm.mapper.ForumManagementMapper;
import com.hy.crm.service.IForumManagementService;
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
public class ForumManagementServiceImpl extends ServiceImpl<ForumManagementMapper, ForumManagement> implements IForumManagementService {
    @Autowired
    private ForumManagementMapper forumManagementMapper;
    @Override
    public IPage<ForumManagement> queryPage(String forum, String keyword, Integer pageNum, Integer size) {
        Page<ForumManagement> page = new Page<>(pageNum,size);
        page.setRecords(forumManagementMapper.queryAll(forum,keyword,page));
        return page;
    }

    @Override
    public void updateClick(Integer forumId) {
        forumManagementMapper.updateClick(forumId);
    }

    @Override
    public void updateC(Integer forumId) {
        forumManagementMapper.updateC(forumId);
    }

    @Override
    public void updateStatus(ForumManagement forumManagement) {
        forumManagementMapper.updateStatus(forumManagement);
    }
}
