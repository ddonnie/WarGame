package com.dnd.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/battle" )
public class MainController {

    @RequestMapping(method = RequestMethod.GET)
    public String printArmyData() {

        return "index";

    }


}
