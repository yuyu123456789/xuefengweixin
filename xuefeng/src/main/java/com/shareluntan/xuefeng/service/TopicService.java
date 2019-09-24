package com.shareluntan.xuefeng.service;

import com.shareluntan.xuefeng.generator.Topic;
import com.shareluntan.xuefeng.generator.TopicWithBLOBs;

import java.util.List;

public interface TopicService {

    List<TopicWithBLOBs> AllTopic();
    List<TopicWithBLOBs> SomeTopic(String category);

}
