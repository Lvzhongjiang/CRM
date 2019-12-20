package com.hy.crm.controller;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crm.entity.Client;
import com.hy.crm.entity.ContractManagement;
import com.hy.crm.entity.ForumManagement;
import com.hy.crm.entity.Reply;
import com.hy.crm.service.IForumManagementService;
import com.hy.crm.service.IReplyService;
import com.hy.crm.util.LayuiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-12-04
 */
@Controller
@RequestMapping("/crm/forum-management")
public class ForumManagementController {
    @Autowired
    private IForumManagementService iForumManagementService;
    @Autowired
    private IReplyService iReplyService;

    /**
     * 查询
     *
     * @param forum
     * @param keyword
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @RequestMapping("/forumList.do")
    public LayuiData forumList(Integer forumId,String forum, String keyword, Integer page, Integer limit) {
        IPage<ForumManagement> iPage = iForumManagementService.queryPage(forum, keyword, page, limit);
        LayuiData layui = new LayuiData();
        layui.setCode(0);
        layui.setMsg("");
        Long l = iPage.getTotal();
        layui.setCount(l.intValue());
        layui.setData(iPage.getRecords());
        return layui;

    }

    @RequestMapping("/addForumList.do")
    @ResponseBody
    public String addForumList(ForumManagement forumManagement) {
        String is = "1";
        try {
            forumManagement.setReplytime(new Date());
            iForumManagementService.save(forumManagement);
        } catch (Exception e) {
            is = "2";
            e.printStackTrace();
        }
        return is;
    }

    @RequestMapping("/tieZiById.do")
    public ModelAndView tieZiById(Integer forumId) {
        ModelAndView modelAndView = new ModelAndView();
        ForumManagement forumManagement = iForumManagementService.getById(forumId);
        iForumManagementService.updateClick(forumId);
        List<Reply> replies = iReplyService.forumReplyId(forumId);
        forumManagement.setC(replies.size());
        modelAndView.addObject("forum", forumManagement);
        modelAndView.addObject("replys", replies);
        modelAndView.setViewName("forumManagement/TieZiXiangQing.html");
        return modelAndView;
    }

    @RequestMapping(value = "/deleteForumId.do")
    // @ResponseBody
    public String deleteForumId(Integer forumId) {
        try {
            iForumManagementService.removeById(forumId);
            iReplyService.deleteForumId(forumId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/forumManagement/forumManagement.html";
    }

    @RequestMapping("/forumById.do")
    public ModelAndView forumById(Integer forumId) {
        ModelAndView modelAndView = new ModelAndView();
        ForumManagement forumManagement = iForumManagementService.getById(forumId);
        modelAndView.addObject("forum", forumManagement);
        modelAndView.setViewName("forumManagement/settingForum.html");
        return modelAndView;
    }

    @RequestMapping("/updateStatus.do")
    public String updateStatus(ForumManagement forumManagement) {
        iForumManagementService.updateById(forumManagement);
        return "redirect:/forumManagement/forumManagement.html";
    }


}
