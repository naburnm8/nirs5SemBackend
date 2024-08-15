package ru.naburnm8.bmstu.datamanagementnirbackend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminPanelController {
    @GetMapping("/catalogue")
    public String catalogue(Model model) {
        //need model interaction
        return "admin/catalogue";
    }

    @GetMapping("/clients")
    public String clients(Model model) {
        //need model interaction
        return "admin/clients";
    }

    @GetMapping("/orders")
    public String orders(Model model) {
        //need model interaction
        return "admin/orders";
    }

    @GetMapping("/storage")
    public String storage(Model model) {
        //need model interaction
        return "admin/storage";
    }

    @GetMapping("/supply")
    public String supply(Model model) {
        //need model interaction
        return "admin/supply";
    }

    @GetMapping("/users")
    public String users(Model model) {
        //need model interaction
        return "admin/users";
    }
}
