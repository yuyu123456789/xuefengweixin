package com.shareluntan.xuefeng.generator;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * topic
 * @author 
 */

@Data
public class Topic implements Serializable {
    private Integer id;

    private Integer idUser;

    private String category;

    private String title;

    private Date createdDate;

    private static final long serialVersionUID = 1L;

}