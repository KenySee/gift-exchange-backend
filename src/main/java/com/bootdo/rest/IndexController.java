package com.bootdo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hadoop on 2017/11/30.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String homePage(){
        return "index";
    }
}
