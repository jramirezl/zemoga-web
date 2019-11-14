package com.zamoga.portafolioweb.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.ArrayList;
import java.util.List;

@Service
public class TwitterService {

    private Twitter twitter = null;
    private final static int MAX_TWEETS_TO_SHOW=5;

    @Autowired
    public TwitterService(Twitter twitter) {
        this.twitter = twitter;
    }

    public List<String> getLatestTweets(){
        List<String> tweets = new ArrayList<>();
        try {
            ResponseList<Status> homeTimeline = twitter.getHomeTimeline();
            for (Status status : homeTimeline) {
                tweets.add(status.getText());
            }
        } catch (TwitterException e) {
            throw new RuntimeException(e);
        }
        return tweets.subList(0,tweets.size()>5?MAX_TWEETS_TO_SHOW:tweets.size());
    }

    public List<String> getLatestTweetsByUser(String user){
        List<String> tweets = new ArrayList<>();
        try {
            ResponseList<Status> homeTimeline =  twitter.getUserTimeline(user);
            for (Status status : homeTimeline) {
                tweets.add(status.getText());
            }
        } catch (TwitterException e) {
            throw new RuntimeException(e);
        }
        return tweets.subList(0,tweets.size()>5?MAX_TWEETS_TO_SHOW:tweets.size());
    }
}