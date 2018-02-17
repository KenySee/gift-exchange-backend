package com.bootdo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hadoop on 2017/11/29.
 */
@Controller
public class ApiController {

    @RequestMapping("/main/index")
    public String Index(Model model){
        throw new RuntimeException("出错了!");
//        model.addAttribute("bodyData","SHOW ME THE");
//        return "/index";
    }
}
