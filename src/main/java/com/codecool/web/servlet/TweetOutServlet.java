package com.codecool.web.servlet;

import com.codecool.web.service.TweetSerService;
import com.codecool.web.service.TweetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet({"/tweetpage"})
public class TweetOutServlet extends HttpServlet {
    private TweetSerService serService = new TweetSerService();
    private TweetService tweetService = new TweetService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {

        int limit = Integer.valueOf(req.getParameter("limit"));
        System.out.println(limit);
        int offset = Integer.valueOf(req.getParameter("offset"));
        System.out.println(offset);
        String poster = req.getParameter("poster");
        System.out.println(poster);
        String from = req.getParameter("from");
        System.out.println(from);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = format.parse(from);
        }catch (ParseException e ){
            e.getMessage();
        }
        System.out.println(date);
        req.setAttribute("listOfTweets",tweetService.search(limit,offset,poster,date,serService.readTweets()));

        req.getRequestDispatcher("tweetpage.jsp").forward(req, resp);
    }
}
