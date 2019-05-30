package com.codecool.web.model;

import java.io.Serializable;
import java.util.Date;

public final class Tweet implements Serializable {
    private String author;
    private String content;
    private Date date;
    private Integer id;

    public Tweet(Integer id,String author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.date = new Date();
    }

    public Tweet(Integer id, String author, String content, Date date) {
        this.id=id;
        this.author = author;
        this.content = content;
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return
            "Author: " + author + '\'' +
            ", Tweet: " + content + '\'' +
            ", Time: " + date;
    }
}
