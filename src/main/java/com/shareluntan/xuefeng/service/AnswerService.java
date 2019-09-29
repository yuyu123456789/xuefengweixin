package com.shareluntan.xuefeng.service;

import com.shareluntan.xuefeng.model.AnswerVO;

import java.util.List;

public interface AnswerService {
    List<AnswerVO> selectAnswerByTopicId(Integer topicId);
    int insertAnswer(Integer id_topic,Integer id_user,String content);
}
