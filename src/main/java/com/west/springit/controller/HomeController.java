package com.west.springit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;


// here we're using controller instead of rest controller because the controller annotation will tell spring to look in
// resources/templates and return the specific template.
@Controller
public class HomeController {

//    @GetMapping(path = "/", consumes = "application/json")
//    public String home() {
//        return "index";
//    }
    @GetMapping("/")
    public String home(Model model, HttpServletRequest request) {
        model.addAttribute("message", "Hello World!");
        return "index";
    }
}
