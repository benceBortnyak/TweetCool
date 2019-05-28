package com.codecool.web.service;

import com.codecool.web.model.Tweet;


import java.io.Serializable;
import java.util.List;

public class TweetStorage implements Serializable {
    private List<Tweet> tweetList;

    public TweetStorage(List<Tweet> tweetList) {
        this.tweetList = tweetList;
    }

    public List<Tweet> getTweetList() {
        return tweetList;
    }

    public void setTweetList(List<Tweet> tweetList) {
        this.tweetList = tweetList;
    }
}
