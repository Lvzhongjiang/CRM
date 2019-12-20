package com.hy.crm.service;

import com.hy.crm.entity.Reply;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
public interface IReplyService extends IService<Reply> {
    public List<Reply> forumReplyId(Integer forumId);
    Reply deleteForumId(Integer forumId);
}
