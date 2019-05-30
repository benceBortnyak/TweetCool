package com.codecool.web.service;

import com.codecool.web.model.Tweet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TweetServiceTest {

    Date helper(String simpleDate){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = format.parse(simpleDate);
        }catch (ParseException e ){
            e.getMessage();
        }
        return date;
    }

    @BeforeAll
    void create(){
        List<Tweet> tweetList = new ArrayList<>();
        tweetList.add(new Tweet(1,"Bence","content",helper("2000-02-08")));
        tweetList.add(new Tweet(2,"Valaki","content",helper("2002-02-08")));
        tweetList.add(new Tweet(3,"Poster guy","asdkjasd",helper("2016-02-06")));
    }
    @Test
    void search() {
        assertEquals();
    }
}
