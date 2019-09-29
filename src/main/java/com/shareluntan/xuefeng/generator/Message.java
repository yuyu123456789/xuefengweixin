package com.shareluntan.xuefeng.generator;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * message
 * @author 
 */
@Data
public class Message implements Serializable {
    private Integer id;
  //发送的用户
    private Integer fromId;
 //收到的用户
    private Integer toId;

    private String content;

    private Date createdDate;

    private static final long serialVersionUID = 1L;

    private Message(){}

    public Message(Integer fromId, Integer toId, String content, Date createdDate) {
        this.fromId = fromId;
        this.toId = toId;
        this.content = content;
        this.createdDate = createdDate;
    }
}