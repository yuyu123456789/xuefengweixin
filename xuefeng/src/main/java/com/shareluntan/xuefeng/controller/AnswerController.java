package com.shareluntan.xuefeng.controller;


import com.shareluntan.xuefeng.generator.AnswerMapper;
import com.shareluntan.xuefeng.generator.Topic;
import com.shareluntan.xuefeng.model.AnswerVO;
import com.shareluntan.xuefeng.service.AnswerService;
import com.shareluntan.xuefeng.service.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class AnswerController {
    @Resource
    AnswerService answerService;
    @Resource
    TopicService topicService;

     @RequestMapping("/answer/{topicid}")
     public String selectTopicAndAnswer(@PathVariable("topicid") Integer topicid, Model model){
         List<AnswerVO> answerVOS = answerService.selectAnswerByTopicId(topicid);
         Topic topic = topicService.selectTopicByTopicId(topicid);
         String username = topicService.selectUsernameByTopicId(topicid);
         model.addAttribute("answer",answerVOS);
         model.addAttribute("topic",topic);
         model.addAttribute("username",username);
         return "topiccontent.html";
     }

     @RequestMapping("/addanswer")
     public String InsertAnswer(@RequestParam("answer") String answer,@RequestParam("img") byte[] img){

        return null;
     }
}
