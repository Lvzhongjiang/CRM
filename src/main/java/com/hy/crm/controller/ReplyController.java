package com.hy.crm.controller;


import com.hy.crm.entity.Reply;
import com.hy.crm.entity.User;
import com.hy.crm.service.IForumManagementService;
import com.hy.crm.service.IReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Controller
@RequestMapping("/crm/reply")
public class ReplyController {
    @Autowired
    private IReplyService iReplyService;
    @Autowired
    private IForumManagementService iForumManagementService;

    @RequestMapping("/addReply.do")
    public String addReply(Reply reply, Integer forumIds, HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("user1");
        iForumManagementService.updateC(forumIds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        reply.setReplytime(simpleDateFormat.format(new Date()));
        reply.setReplyName(user.getNumber());
        iReplyService.save(reply);
        return "redirect:/forumManagement/forumManagement.html";
    }
}
