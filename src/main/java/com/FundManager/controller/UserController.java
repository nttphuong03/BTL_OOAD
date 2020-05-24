package com.FundManager.controller;

import com.FundManager.form.UserForm;
import com.FundManager.service.UserService;
import com.FundManager.validation.SignupValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    SignupValidator signupValidator;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String getAddNewUserForm(Model model){
        UserForm userForm = new UserForm();
        model.addAttribute("userForm",userForm);
        return "signup";
    }

    @RequestMapping(value = "/signup" , method = RequestMethod.POST)
    public String processAddNewUserForm(@ModelAttribute("userForm") UserForm userForm, BindingResult result, RedirectAttributes redirectAttributes){
        signupValidator.validate(userForm,result);
        if(result.hasErrors()){
            return "signup";
        } else{
            userService.addUser(userForm);
            redirectAttributes.addFlashAttribute("msg","Your account has been created successfully!");
        }

        return "redirect: /login";
    }
}
