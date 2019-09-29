package com.shareluntan.xuefeng.generator;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * answer
 * @author 
 */

@Data
public class Answer implements Serializable {
    private Integer id;

    private String img;

    private String content;

    private Date createdDate;

    private Boolean useful;

    private Integer idTopic;

    private Integer idUser;

    private static final long serialVersionUID = 1L;
    public Answer(String img,String content,Date createdDate,Boolean useful,Integer idTopic,Integer idUser){
        this.img=img;
        this.content=content;
        this.createdDate=createdDate;
        this.idTopic=idTopic;
        this.idUser=idUser;
        this.useful=useful;
    }

}