package com.codecool.web.service;

import com.codecool.web.model.Tweet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TweetSerService {

    public void writeTweets(List<Tweet> tweetList){
        String mainDir = System.getenv("HOME");
        try {
            FileOutputStream inputStream = new FileOutputStream(mainDir + "/Documents/tweets.ser");
            ObjectOutputStream objectIn = new ObjectOutputStream(inputStream);
            objectIn.writeObject(tweetList);
            objectIn.close();
            inputStream.close();
        }catch (IOException e ){
            e.getMessage();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Tweet> readTweets(){
        String mainDir = System.getenv("HOME");
        List<Tweet> tweets = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(mainDir + "/Documents/tweets.ser"));
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            tweets = (List<Tweet>) objectInputStream.readObject();
        }catch (IOException | ClassNotFoundException e){
            e.getMessage();
        }
        return tweets;
    }
}
