package com.zamoga.portafolioweb.controller;

import com.zamoga.portafolioweb.service.ZemogaProfileService;
import com.zamoga.portafolioweb.twitter.client.ClientTwitter;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("twitter-api")
public class ProfileUserController {

    private ZemogaProfileService profileService;
    private ClientTwitter clientTwitter;

    @Autowired
    public ProfileUserController(ZemogaProfileService profileService, ClientTwitter clientTwitter) {
        this.profileService = profileService;
        this.clientTwitter = clientTwitter;
    }

    public ProfileUserController(ZemogaProfileService profileService) {
        this.profileService = profileService;
    }


    @ApiOperation(
            value = "Returns twitter latest posts in JSON by user currently logged",
            response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns twitter latest posts in JSON by user currently logged"),})
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<String> findAll() {
        return clientTwitter.getLatestTweets();
    }

    @ApiOperation(
            value = "Returns twitter latest posts",
            response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns twitter latest posts in JSON by user"),})
    @RequestMapping(value = "/{user}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<String> findByUser( @PathVariable("user") String user) {
        return clientTwitter.getLatestTweetsByUser(user);
    }


}
