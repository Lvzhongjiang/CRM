package com.hy.crm.service.impl;

import com.hy.crm.entity.Reply;
import com.hy.crm.mapper.ReplyMapper;
import com.hy.crm.service.IReplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Service
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply> implements IReplyService {

    @Autowired
    private ReplyMapper replyMapper;
    @Override
    public List<Reply> forumReplyId(Integer forumId) {
        return replyMapper.forumReplyId(forumId);
    }

    @Override
    public Reply deleteForumId(Integer forumId) {
        return replyMapper.deleteForumId(forumId);
    }
}
