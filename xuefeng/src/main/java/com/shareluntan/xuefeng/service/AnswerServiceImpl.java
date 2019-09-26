package com.shareluntan.xuefeng.service;


import com.shareluntan.xuefeng.generator.AnswerMapper;
import com.shareluntan.xuefeng.model.AnswerVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Resource
    AnswerMapper answerMapper;

    @Override
    public List<AnswerVO> selectAnswerByTopicId(Integer topicId) {
        return answerMapper.selectAnswerByTopicId(topicId);
    }
}
