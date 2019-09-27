package com.shareluntan.xuefeng.service;

import com.shareluntan.xuefeng.model.AnswerVO;
import io.swagger.models.auth.In;

import java.util.List;

public interface AnswerService {
    List<AnswerVO> selectAnswerByTopicId(Integer topicId);
    boolean insertAnswer(Integer idtopic, Integer iduser,String content,boolean useful,byte[] img);
}
