package com.mike.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

    @GetMapping("/")
    public String home(){
        return "<a href=\"http://localhost:5550/plans\">plan</a>";
    }

}
