package com.shareluntan.xuefeng.model;

import lombok.Data;

import java.util.Date;


@Data
public class TopicVO {

    private Integer id;

    private String category;

    private String title;

    private Date createdDate;

    private String username;

    private String content;

    private byte[] img;

}
