package com.shareluntan.xuefeng.service;


import com.shareluntan.xuefeng.generator.AnswerMapper;
import com.shareluntan.xuefeng.generator.TopicMapper;
import com.shareluntan.xuefeng.model.AnswerVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Resource
    AnswerMapper answerMapper;
    @Resource
    TopicMapper topicMapper;

    @Override
    public List<AnswerVO> selectAnswerByTopicId(Integer topicId) {
        List<AnswerVO> answerVOS = answerMapper.selectAnswerByTopicId(topicId);
        for(AnswerVO a:answerVOS){
            a.setTopic(topicMapper.selectByPrimaryKey(a.getIdTopic()));
        }
        return answerVOS;
    }
}
