package com.shareluntan.xuefeng.controller;


import com.shareluntan.xuefeng.config.AjaxResponse;
import com.shareluntan.xuefeng.config.CustomException;
import com.shareluntan.xuefeng.config.CustomExceptionType;
import com.shareluntan.xuefeng.generator.Answer;
import com.shareluntan.xuefeng.generator.AnswerMapper;
import com.shareluntan.xuefeng.generator.Topic;
import com.shareluntan.xuefeng.model.AnswerVO;
import com.shareluntan.xuefeng.service.AnswerService;
import com.shareluntan.xuefeng.service.TopicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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

     @PostMapping("/answer")
     public @ResponseBody  AjaxResponse insertAnswer(@RequestBody Answer answer, Model model){
         Integer id_user=answer.getIdUser();
         Integer id_topic=answer.getIdTopic();
         String content =answer.getContent();


         if(answerService.insertAnswer(id_topic,id_user,content)!=1){
             return AjaxResponse.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR, "评论失败"));
         }else {
             model.addAttribute("content",content);
             model.addAttribute("id_user",id_user);
             return AjaxResponse.success();
         }

     }
}
