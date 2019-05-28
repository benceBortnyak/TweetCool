package com.codecool.web.servlet;


import com.codecool.web.model.Tweet;
import com.codecool.web.service.TweetSerService;
import com.codecool.web.service.TweetStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/new-tweet"})
public class TweetServlet extends HttpServlet {
    private List<Tweet> tweetList = new ArrayList<>();
    private TweetStorage tweetStorage = new TweetStorage(tweetList);
    private TweetSerService serService = new TweetSerService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Poster = req.getParameter("poster");
        String Tweet = req.getParameter("tweet");
        if ((Poster.equals("") || Tweet.equals(""))){
            resp.sendRedirect("errorpage.html");
        }
        else {
            tweetStorage.setTweetList(serService.readTweets());
            Integer newId = tweetStorage.getTweetList().size() + 1;
            Tweet tweet = new Tweet(newId, Poster, Tweet);
            tweetStorage.getTweetList().add(tweet);
            System.out.println(tweetList);
            serService.writeTweets(tweetStorage.getTweetList());
            resp.sendRedirect("index.html");
        }
    }
}
