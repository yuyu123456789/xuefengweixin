package com.shareluntan.xuefeng.service;

import com.shareluntan.xuefeng.generator.Topic;
import com.shareluntan.xuefeng.generator.TopicMapper;
import com.shareluntan.xuefeng.generator.TopicWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class TopicServiceImpl implements TopicService{

    @Resource
    TopicMapper topicMapper;

    @Override
    public List<TopicWithBLOBs> AllTopic() {
     return null;
    }

    @Override
    public List<TopicWithBLOBs> SomeTopic(String category) {
        return  topicMapper.selectByCategory(category);
    }


}
