package com.d38m0n.IAE.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String viewHomePage(){
        return "index";
    }
}
