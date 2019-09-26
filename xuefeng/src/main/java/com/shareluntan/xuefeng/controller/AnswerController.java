package com.shareluntan.xuefeng.controller;


import com.shareluntan.xuefeng.generator.AnswerMapper;
import com.shareluntan.xuefeng.model.AnswerVO;
import com.shareluntan.xuefeng.service.AnswerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class AnswerController {
    @Resource
    AnswerService answerService;
     @RequestMapping("/answer/{topicid}")
     public String selectTopicAndAnswer(@PathVariable("topicid") Integer topicid, Model model){
         List<AnswerVO> answerVOS = answerService.selectAnswerByTopicId(topicid);
         model.addAttribute("answer",answerVOS);
         return "topiccontent.html";
     }
}
