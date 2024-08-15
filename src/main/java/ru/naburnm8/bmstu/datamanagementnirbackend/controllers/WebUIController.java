package ru.naburnm8.bmstu.datamanagementnirbackend.controllers;



import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WebUIController {
    @GetMapping
    public String index(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", "Your username: " + authentication.getName());
        model.addAttribute("role", "Your role: " + authentication.getAuthorities());
        return "index";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        //no model interaction
        return "admin";
    }

}
