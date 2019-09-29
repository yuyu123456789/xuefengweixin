package com.shareluntan.xuefeng.controller;


import com.shareluntan.xuefeng.config.CustomException;
import com.shareluntan.xuefeng.config.CustomExceptionType;
import com.shareluntan.xuefeng.config.AjaxResponse;
import com.shareluntan.xuefeng.model.TopicVO;
import com.shareluntan.xuefeng.service.AnswerService;
import com.shareluntan.xuefeng.service.TopicService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TopicController {

    @Resource
    TopicService topicService;

    @Resource
    AnswerService answerService;

    @GetMapping("/topic/{category}")
    public String SelectTopic(@PathVariable  String category, Model model){
        List<TopicVO> topics = topicService.SomeTopic(category);
        model.addAttribute("topics",topics);

        return "topic.html";
    }

    @PostMapping("/addtopic")
    public String InsertTopic(@RequestParam("category") String category,@RequestParam("title") String title,@RequestParam("content") String content,@RequestParam("img") byte[] img, HttpServletRequest request,Model model){
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        boolean b = topicService.addTopic(userId, category, title, content, img);

        if(!b){
            AjaxResponse error2 = AjaxResponse.error(new CustomException(CustomExceptionType.OTHER_ERROR, "未知错误，请联系王雪峰同学检查"));
            model.addAttribute("code", error2.getCode());
            model.addAttribute("message", error2.getMessage());
            return  "fail.html";
        }

           return SelectTopic(category, model);
    }

}
