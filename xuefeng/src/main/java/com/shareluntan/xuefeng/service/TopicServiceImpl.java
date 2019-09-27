package com.shareluntan.xuefeng.service;

import com.shareluntan.xuefeng.generator.Topic;
import com.shareluntan.xuefeng.generator.TopicMapper;

import com.shareluntan.xuefeng.model.TopicVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class TopicServiceImpl implements TopicService{

    @Resource
    TopicMapper topicMapper;

    @Override
    public List<TopicVO> AllTopic() {
     return null;
    }

    @Override
    public List<TopicVO> SomeTopic(String category) {
        return topicMapper.selectTopicVOByCategory(category);
    }

    @Override
    public boolean addTopic(Integer userId,String category,String title,String content,byte[] img) {
        Topic topicWithBLOBs = new Topic(userId,category,title,new java.sql.Date(new Date().getTime()),content,img);
        int insert = topicMapper.insert(topicWithBLOBs);
        return insert == 1 ? true : false;
    }

    @Override
    public Topic selectTopicByTopicId(Integer topicid) {
        return topicMapper.selectByPrimaryKey(topicid);
    }

    @Override
    public String selectUsernameByTopicId(Integer topicid) {
      return topicMapper.selectUsernameByTopicId(topicid);
    }


}
