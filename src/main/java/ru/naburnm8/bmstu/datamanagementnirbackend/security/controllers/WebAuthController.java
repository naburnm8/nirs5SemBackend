package ru.naburnm8.bmstu.datamanagementnirbackend.security.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WebAuthController {
    @GetMapping("/login")
    public String getLoginPage(Model model) {
        return "login";
    }
    @GetMapping("/logout")
    public String getLogoutPage(Model model) {
        return "redirect:login";
    }
}
