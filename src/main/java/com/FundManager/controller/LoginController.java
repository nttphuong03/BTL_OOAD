package com.FundManager.controller;

import com.FundManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @Autowired
    UserService userService;



    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginPage(Model model){
        return "loginPage";
    }

    @RequestMapping(value = "/logoutSuccessful",method = RequestMethod.GET)
    public String logoutPage(Model model){
        return "welcomePage";
    }



}
