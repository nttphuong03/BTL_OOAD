package com.FundManager.controller;

import com.FundManager.domain.User;
import com.FundManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
;

@Controller
public class HomeController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/home")
    public String home(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User currentUser = userService.getUserByUsername(username);
        model.addAttribute("currentUser",currentUser);
        return "home";
    }
}
