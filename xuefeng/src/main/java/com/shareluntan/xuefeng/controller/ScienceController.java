package com.shareluntan.xuefeng.controller;


import com.shareluntan.xuefeng.generator.TopicWithBLOBs;
import com.shareluntan.xuefeng.service.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ScienceController {

    @Resource
    TopicService topicService;

    @GetMapping("/science/{category}")
    public String SelectScience(@PathVariable  String category, Model model){
        List<TopicWithBLOBs> topics = topicService.SomeTopic(category);
        model.addAttribute("topics",topics);

        return "topic.html";
    }
}
