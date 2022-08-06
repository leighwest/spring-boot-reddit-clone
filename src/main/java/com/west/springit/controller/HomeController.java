package com.west.springit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// here we're using controller instead of rest controller because the controller annotation will tell spring to look in
// resources/templates and return the specific template.
@Controller
public class HomeController {

//    @GetMapping(path = "/", consumes = "application/json")
//    public String home() {
//        return "index";
//    }
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Hello, Thymeleaf!");
        return "/link/index";
    }
}
