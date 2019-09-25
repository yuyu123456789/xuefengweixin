package com.shareluntan.xuefeng.model;

import lombok.Data;

import java.util.Date;


@Data
public class UserVO {
    private Integer id;

    private Date createdDate;

    private String email;

    private String password;

    private String username;
}
