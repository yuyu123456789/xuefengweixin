package com.shareluntan.xuefeng;

import com.shareluntan.xuefeng.generator.AnswerMapper;
import com.shareluntan.xuefeng.model.AnswerVO;
import com.shareluntan.xuefeng.service.AnswerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAnswer {

    @Autowired
    AnswerService answerService;


    @Test
    public void testselectanswer1(){
        List<AnswerVO> answerVOS = answerService.selectAnswerByTopicId(1);
        for(AnswerVO a:answerVOS){
            System.out.println(a.toString());
        }

    }
    @Test
    public void testInsertAnswer(){
        int a=answerService.insertAnswer(1,10000,"这是评论内容");
        System.out.println(a);
    }
}
