package com.shareluntan.xuefeng.generator;

import com.shareluntan.xuefeng.generator.Answer;
import com.shareluntan.xuefeng.model.AnswerVO;
import io.swagger.models.auth.In;

import java.util.List;

public interface AnswerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Answer record);

    int insertSelective(Answer record);

    Answer selectByPrimaryKey(Integer id);

    List<AnswerVO> selectAnswerByTopicId(Integer id);

    int updateByPrimaryKeySelective(Answer record);

    int updateByPrimaryKey(Answer record);
}