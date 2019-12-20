package com.hy.crm.mapper;

import com.hy.crm.entity.Reply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
public interface ReplyMapper extends BaseMapper<Reply> {

    @Select("SELECT * FROM reply r  WHERE r.forumId=#{forumId}")
    public List<Reply> forumReplyId(Integer forumId);
    @Select("delete from reply  WHERE forumId=#{forumId}")
    public Reply deleteForumId(Integer forumId);
}
