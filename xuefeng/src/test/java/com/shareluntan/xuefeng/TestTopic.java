package com.shareluntan.xuefeng;


import com.shareluntan.xuefeng.generator.Topic;
import com.shareluntan.xuefeng.generator.TopicMapper;
import com.shareluntan.xuefeng.generator.TopicWithBLOBs;
import com.shareluntan.xuefeng.service.TopicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTopic {


    @Resource
    TopicService topicService;

    @Resource
    TopicMapper topicMapper;


    @Test
    public  void testcategory1(){
        List<TopicWithBLOBs> s= topicMapper.selectByCategory("科技");
        for(TopicWithBLOBs t:s){
            System.out.println(t);
            System.out.println(t.getCategory());
        }

    }

    @Test
    public void testcategory2(){
        List<TopicWithBLOBs> s= topicService.SomeTopic("科技");
        for(TopicWithBLOBs t:s){
            System.out.println(t);
            //System.out.println(t.getContent());
        }

    }

}
