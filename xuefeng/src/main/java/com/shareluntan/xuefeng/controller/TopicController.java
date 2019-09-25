package com.shareluntan.xuefeng.controller;


import com.shareluntan.xuefeng.generator.TopicWithBLOBs;
import com.shareluntan.xuefeng.model.TopicVO;
import com.shareluntan.xuefeng.service.TopicService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class TopicController {

    @Resource
    TopicService topicService;

    @GetMapping("/topic/{category}")
    public String SelectScience(@PathVariable  String category, Model model){
        List<TopicVO> topics = topicService.SomeTopic(category);
        model.addAttribute("topics",topics);
        return "topic.html";
    }

    @PostMapping("/addtopic")
    public String InsertTopic(@RequestParam("category") String category,@RequestParam("title") String title,@RequestParam("content") String content,@RequestParam("img") byte[] img, HttpServletRequest request){
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        boolean b = topicService.addTopic(userId, category, title, content, img);

        if(b){
            return "success.html";
        }
            return  "fail.html";

    }

}
