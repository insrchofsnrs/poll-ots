package by.ots.poll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WebController {

    private final static String INDEX = "index";

    @GetMapping
    public String homepage(){
        return INDEX;
    }
}
