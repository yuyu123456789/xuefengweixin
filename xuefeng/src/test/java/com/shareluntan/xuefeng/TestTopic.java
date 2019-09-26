package com.shareluntan.xuefeng;


import com.shareluntan.xuefeng.generator.TopicMapper;
import com.shareluntan.xuefeng.generator.TopicWithBLOBs;
import com.shareluntan.xuefeng.model.TopicVO;
import com.shareluntan.xuefeng.service.TopicService;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTopic {


    @Resource
    TopicService topicService;

    @Resource
    TopicMapper topicMapper;

    @Autowired
    protected Mapper dozerMapper;
    @Test
    public  void testcategory1(){
        List<TopicVO> s1= topicMapper.selectTopicVOByCategory("科技");

        for(TopicVO t:s1){
            System.out.println(t);
            //System.out.println(t.getContent());
        }
    }

    @Test
    public void testcategory2(){
        List<TopicVO> s= topicService.SomeTopic("科技");
        for(TopicVO t:s){
            System.out.println(t);
            //System.out.println(t.getContent());
        }

    }

    @Test
    public void testaddtopic1(){
        TopicWithBLOBs topicWithBLOBs = new TopicWithBLOBs(10000,"科技",new java.sql.Date(new Date().getTime()),"你的名字","你的名字",null);
        int insert = topicMapper.insert(topicWithBLOBs);
        System.out.println(insert);
    }

    @Test
    public void testaddtopic2(){
        TopicWithBLOBs topicWithBLOBs = new TopicWithBLOBs(10000,"科技",new java.sql.Date(new Date().getTime()),"你的名字","你的名字",null);
        boolean b = topicService.addTopic(10000, "科技", "你的名字", "你的名字", null);
        System.out.println(b);
    }

    @Test
    public void testaddtopic3(){
        String s = topicMapper.selectUsernameByTopicId(1);
        System.out.println(s);
    }
    
    
    
    
    
}
