package com.twitter.model;

import lombok.Data;

import java.util.Date;

@Data
public class Post {

    private String message;
    private String username;
    private Date postDate;


}
