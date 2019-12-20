package com.hy.crm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crm.entity.ContractManagement;
import com.hy.crm.entity.ForumManagement;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
public interface IForumManagementService extends IService<ForumManagement> {
    public IPage<ForumManagement> queryPage(String forum, String keyword, Integer pageNum, Integer size);
    void updateStatus(ForumManagement forumManagement);
    void updateClick(Integer forumId);
    void updateC(Integer forumId);

}
