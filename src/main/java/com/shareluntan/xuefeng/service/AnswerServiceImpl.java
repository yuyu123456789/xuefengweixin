package com.shareluntan.xuefeng.service;


import com.shareluntan.xuefeng.generator.Answer;
import com.shareluntan.xuefeng.generator.AnswerMapper;
import com.shareluntan.xuefeng.model.AnswerVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Resource
    AnswerMapper answerMapper;

    @Override
    public List<AnswerVO> selectAnswerByTopicId(Integer topicId) {
        return answerMapper.selectAnswerByTopicId(topicId);
    }

    public int insertAnswer(Integer id_topic,Integer id_user,String content){
        Answer answer = new Answer(null,content,new java.sql.Date(new Date().getTime()),false,id_topic,id_user);

        return answerMapper.insert(answer);
    }
}
