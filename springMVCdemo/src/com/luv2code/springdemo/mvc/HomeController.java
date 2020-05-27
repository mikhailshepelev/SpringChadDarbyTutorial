package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/main-menu") //this is path added to URL
    //we can use any method name for MVC controller
    public String showPage(){
        return "main-menu"; //this returns the view name from view folder without suffix and prefix
    }
}
