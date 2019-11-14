package com.zamoga.portafolioweb.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("profile-view")
public class PageController {

    @GetMapping("/home")
    public String greeting( Model model) {
        return "home";
    }



}