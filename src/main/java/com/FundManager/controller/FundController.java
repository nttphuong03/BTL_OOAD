package com.FundManager.controller;


import com.FundManager.domain.Fund;
import com.FundManager.domain.User;
import com.FundManager.service.FundService;
import com.FundManager.service.UserService;
import com.FundManager.validation.FundValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("fundManager")
public class FundController {

    @Autowired
    FundValidator fundValidator;

    @Autowired
    FundService fundService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/addFund" ,method = RequestMethod.GET)
    public String getNewFund (Model model){
        Fund newFund = new Fund();
        model.addAttribute("newFund",newFund);
        return "addFund";
    }

    @RequestMapping(value = "/addFund" ,method = RequestMethod.POST)
    public String processAddNewFund(@ModelAttribute("newFund") Fund newFund, BindingResult bindingResult, RedirectAttributes attributes){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User currentUser = userService.getUserByUsername(username);
        fundValidator.validate(newFund,bindingResult);
        if (bindingResult.hasErrors() ){
            return "addFund";
        }else {
            long millis=System.currentTimeMillis();
            java.sql.Timestamp dateTime = new java.sql.Timestamp(millis);

            newFund.setNgayTao(dateTime);
            newFund.setFundId(String.valueOf(newFund.getFundName().hashCode()));
            fundService.create(newFund,currentUser);
            attributes.addFlashAttribute("msg","Your fund is created successfully !");
        }
        return "redirect: /home";
    }
}
