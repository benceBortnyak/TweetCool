package com.codecool.web.service;

import com.codecool.web.model.Tweet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TweetService {

    public List<Tweet> search(int limit, int offset, String poster, Date from,List<Tweet> tweetList){
        List<Tweet> clonedTweetList = tweetList;
        List<Tweet> workingList = new ArrayList<>();
        List<Tweet> nameFiltered = new ArrayList<>();
        from(from,clonedTweetList,workingList);
        poster(poster,workingList,nameFiltered);
        offset(offset,nameFiltered);
        limit(limit,nameFiltered);

        return workingList;
    }
    private void from(Date date,List<Tweet> clonedList,List<Tweet> workingList){
        for (int i = 0; i < clonedList.size() ; i++) {
            if(date.before(clonedList.get(i).getDate())){
                workingList.add(clonedList.get(i));
            }
        }
    }
    private void poster(String poster,List<Tweet> workingList,List<Tweet> nameFiltered){
        if(poster.equals("")){
            workingList.addAll(nameFiltered);
        }else {
            for (int i = 0; i < workingList.size(); i++) {
                if (workingList.get(i).getAuthor().equals(poster)) {
                    nameFiltered.add(workingList.get(i));
                }

            }
        }

    }
    private void offset(int offset,List<Tweet> nameFiltered){
        for (int i = 0; i < offset ; i++) {
            nameFiltered.remove(0);
        }
    }
    private void limit(int limit, List<Tweet> nameFiltered){
        if(limit < nameFiltered.size()) {
            for (int i = 0; i < limit; i++) {
                nameFiltered.remove(0);
            }
        }
    }
}
