package com.shareluntan.xuefeng.generator;

import com.shareluntan.xuefeng.generator.Topic;
import com.shareluntan.xuefeng.model.TopicVO;

import java.util.List;

public interface TopicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Topic record);

    int insertSelective(Topic record);

    Topic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Topic record);

    int updateByPrimaryKeyWithBLOBs(Topic record);

    int updateByPrimaryKey(Topic record);

    String selectUsernameByTopicId(Integer iduser);

//    List<TopicWithBLOBs> selectByCategory(String category);

    List<TopicVO> selectTopicVOByCategory(String category);

//    List<String> selectTitleByCategory(String category);
}