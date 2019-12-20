package com.hy.crm.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.entity.ContractManagement;
import com.hy.crm.entity.ForumManagement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.sql.ContractSql;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
public interface ForumManagementMapper extends BaseMapper<ForumManagement> {
    /**
     * 模糊查询  分页
     *
     * @param
     * @return
     */
    @Results({
            @Result(column = "motif", property = "motif")
    })
    @SelectProvider(type = ContractSql.class, method = "selectFor")
    public List<ForumManagement> queryAll(String forum, String keyword, Page<ForumManagement> page);

    @Update("update forum_management set click=click+1 where forumId=#{forumId} ")
    void updateClick(Integer forumId);
    @Update("update forum_management set c=c+1 where forumId=#{forumId} ")
    void updateC(Integer forumId);
    @Update("update forum_management set status=#{status},post_type=#{postType} where forumId=")
    public void updateStatus(ForumManagement forumManagement);
}
