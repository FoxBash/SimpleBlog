package com.paul.SimpleBlog.controller;

import com.paul.SimpleBlog.model.Account;
import com.paul.SimpleBlog.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    @Autowired
    private AccountService service;


    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("account", new Account());
        return "register";
    }

    @PostMapping("/register")
    public String registerAccount(@ModelAttribute Account account){
        service.save(account);
        return "redirect:/";
    }

}
