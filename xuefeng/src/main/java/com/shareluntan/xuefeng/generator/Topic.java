package com.shareluntan.xuefeng.generator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * topic
 * @author 
 */

@NoArgsConstructor

@Data
public class Topic implements Serializable {
    private Integer id;

    private Integer idUser;

    private String category;

    private String title;

    private Date createdDate;

    private static final long serialVersionUID = 1L;

    public Topic(Integer idUser, String category, String title, Date createdDate) {
        this.idUser = idUser;
        this.category = category;
        this.title = title;
        this.createdDate = createdDate;
    }
}