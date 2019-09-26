package com.shareluntan.xuefeng.generator;

import com.shareluntan.xuefeng.generator.Topic;
import com.shareluntan.xuefeng.generator.TopicWithBLOBs;
import com.shareluntan.xuefeng.model.TopicVO;

import java.util.List;

public interface TopicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TopicWithBLOBs record);

    int insertSelective(TopicWithBLOBs record);

    TopicWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TopicWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TopicWithBLOBs record);

    int updateByPrimaryKey(Topic record);

//    List<TopicWithBLOBs> selectByCategory(String category);

    List<TopicVO> selectTopicVOByCategory(String category);

//    List<String> selectTitleByCategory(String category);
}