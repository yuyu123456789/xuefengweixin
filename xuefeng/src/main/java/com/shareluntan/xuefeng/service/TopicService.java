package com.shareluntan.xuefeng.service;

import com.shareluntan.xuefeng.generator.Topic;
import com.shareluntan.xuefeng.generator.TopicWithBLOBs;
import com.shareluntan.xuefeng.model.TopicVO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TopicService {

    List<TopicVO> AllTopic();
    List<TopicVO> SomeTopic(String category);
    boolean addTopic(Integer userId,String category,String title,String content,byte[] img );
    TopicWithBLOBs selectTopicByTopicId(Integer topicid);
    String selectUsernameByTopicId(Integer topicid);
}
