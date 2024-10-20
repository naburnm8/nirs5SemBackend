package ru.naburnm8.bmstu.datamanagementnirbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Catalogue;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Clients;
import ru.naburnm8.bmstu.datamanagementnirbackend.services.CatalogueService;
import ru.naburnm8.bmstu.datamanagementnirbackend.services.ClientsService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminPanelController {
    @Autowired
    private CatalogueService catalogueService;
    @Autowired
    private ClientsService clientsService;

    @GetMapping("/catalogue")
    public String catalogue(Model model) {
        List<Catalogue> catalogueList = catalogueService.getAllCatalogues();
        model.addAttribute("catalogueList", catalogueList);
        return "admin/catalogue";
    }

    @GetMapping("/clients")
    public String clients(Model model) {
        List<Clients> clientsList = clientsService.getAllClients();
        model.addAttribute("clients", clientsList);
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
