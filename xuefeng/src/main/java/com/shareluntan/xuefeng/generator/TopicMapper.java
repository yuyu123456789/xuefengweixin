package com.shareluntan.xuefeng.generator;

import com.shareluntan.xuefeng.generator.Topic;
import com.shareluntan.xuefeng.generator.TopicWithBLOBs;

import java.util.List;

public interface TopicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TopicWithBLOBs record);

    int insertSelective(TopicWithBLOBs record);

    TopicWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TopicWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TopicWithBLOBs record);

    int updateByPrimaryKey(Topic record);

    List<TopicWithBLOBs> selectByCategory(String category);

}