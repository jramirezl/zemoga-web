package com.zamoga.portafolioweb.twitter.client;


import com.zamoga.portafolioweb.twitter.service.TwitterService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientTwitter {
    private TwitterService twitterService = null;

    public ClientTwitter(TwitterService twitterService) {
        this.twitterService = twitterService;
    }

    public List<String> getLatestTweets(){
        return twitterService.getLatestTweets();
    }

    public List<String> getLatestTweetsByUser(String user){
        return twitterService.getLatestTweetsByUser(user);
    }
}
