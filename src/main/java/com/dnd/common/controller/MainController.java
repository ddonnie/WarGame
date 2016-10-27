package com.dnd.common.controller;

import com.dnd.common.entity.Army;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/battle" )
public class MainController {

    @RequestMapping(method = RequestMethod.GET)
    public String armyForm(Model model) {
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(Model model, @ModelAttribute Army army) {
        return "index";
    }


}
