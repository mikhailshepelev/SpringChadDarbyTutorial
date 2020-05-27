package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SillyController {

    //@RequestMapping("/showForm") will throw exception because there is already controller with same mapping
    public String displayTheForm(){
        return "silly";
    }
}
