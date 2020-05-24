package com.FundManager.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

    @RequestMapping(value = "/welcome")
    public String welcomePage(Model model){
        model.addAttribute("title","Welcome");
        model.addAttribute("message","Happy to see you ");
        return "welcomePage";
    }
}
