package com.codecool.web.service;

import com.codecool.web.model.Tweet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TweetService {

    public List<Tweet> search(int limit, int offset, String poster, Date from,List<Tweet> clonedTweetList){


        System.out.println(clonedTweetList.size());
        List<Tweet> one = from(from,clonedTweetList);
        System.out.println(one.size());
        List<Tweet> two = poster(poster,one);
        System.out.println(two.size());
        List <Tweet> three = offset(offset,two);
        System.out.println(three.size());
        List<Tweet> finalList = limit(limit,three);
        System.out.println(finalList);
        return finalList;
    }
    private List<Tweet> from(Date date, List<Tweet> tweetList){
        List<Tweet> retList = new ArrayList<>();
        for (Tweet tweet : tweetList) {
            if(tweet.getDate().after(date)){
                retList.add(tweet);
            }
        }
        return retList;
    }

    private List<Tweet> poster(String poster,List<Tweet> tweetList) {
        List<Tweet> filteredList1 = new ArrayList<>();
        if (poster.equals("")) {
            return tweetList;
        } else {
            for (Tweet tweet : tweetList) {
                if ((tweet.getAuthor().toLowerCase()).equals(poster.toLowerCase())) {
                    filteredList1.add(tweet);
                }
            }
            return filteredList1;
        }
    }
    private List<Tweet> offset(int offset,List<Tweet> tweetList){
        List<Tweet> filteredList2 = new ArrayList<>();
        if(!(tweetList.size()<=offset)){
            for (int i = offset; i < tweetList.size(); i++) {
                filteredList2.add(tweetList.get(i));
            }
        return filteredList2;
        }else {
            return tweetList;
        }

    }
    private List<Tweet> limit(int limit,List<Tweet> tweetList){
        List<Tweet> filteredList3 = new ArrayList<>();
        if (!(tweetList.size()<=limit)){
            for (int i = limit; i < tweetList.size(); i++) {
                filteredList3.add(tweetList.get(i));
            }
            return filteredList3;
        }else {
            return tweetList;
        }
    }
}
