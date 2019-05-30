package com.codecool.web.service;

import com.codecool.web.model.Tweet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TweetServiceTest {
    private static List<Tweet> tweetList = new ArrayList<>();
    private static TweetService tweetService;

    static Date helper(String simpleDate){
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
    static void create(){
        tweetService = new TweetService();
        tweetList.add(new Tweet(1,"Bence","content",helper("2000-02-08")));
        tweetList.add(new Tweet(2,"Valaki","content",helper("2002-02-08")));
        tweetList.add(new Tweet(3,"Poster guy","asdkjasd",helper("2016-02-06")));
        tweetList.add(new Tweet(4,"Bence2","content",helper("2000-02-08")));
        tweetList.add(new Tweet(5,"Valaki2","content",helper("2002-02-08")));
        tweetList.add(new Tweet(6,"Poster guy2","asdkjasd",helper("2016-02-06")));
        tweetList.add(new Tweet(7,"Bence3","content",helper("2000-02-08")));
        tweetList.add(new Tweet(8,"Valaki3","content",helper("2002-02-08")));
        tweetList.add(new Tweet(9,"Poster guy3","asdkjasd",helper("2016-02-06")));
        tweetList.add(new Tweet(10,"Bence4","content",helper("2000-02-08")));
        tweetList.add(new Tweet(11,"Valaki4","content",helper("2002-02-08")));
        tweetList.add(new Tweet(12,"Poster guy4","asdkjasd",helper("2016-02-06")));
    }
    @Test
    void search() {
        List<Tweet> tryList = tweetService.search(10,0,"Bence",helper("2000-01-01"),tweetList);
        Integer maybe = 1;
        Integer ID = tryList.get(0).getId();

        assertEquals(ID,maybe);

        List<Tweet> tryList2 = tweetService.search(10,2,"",helper("2000-01-01"),tweetList);
        Integer length = tryList2.size();
        Integer expectedLength = 10;

        assertEquals(expectedLength,length);



}
}
