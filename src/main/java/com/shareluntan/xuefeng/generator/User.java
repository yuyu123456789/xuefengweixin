package com.shareluntan.xuefeng.generator;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    private Integer id;

    private Date createdDate;

    private String email;

    private String password;

    private String username;

    private Boolean ismanager;

    private static final long serialVersionUID = 1L;

    public User(Date createdDate, String email, String password, String username) {
        this.createdDate = createdDate;
        this.email = email;
        this.password = password;
        this.username = username;
    }
}