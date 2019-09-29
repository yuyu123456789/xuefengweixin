package com.shareluntan.xuefeng.model;

import com.shareluntan.xuefeng.generator.Topic;

import lombok.Data;

import java.util.Date;


@Data
public class AnswerVO {
    private Integer id;

    private String img;

    private String content;

    private Date createdDate;
   //评论是否有用
    private Boolean useful;
  //评论属于哪个文章
    private Integer idTopic;
  //谁发表的评论
    private String username;

}
