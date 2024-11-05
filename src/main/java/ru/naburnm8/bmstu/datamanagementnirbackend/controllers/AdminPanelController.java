package ru.naburnm8.bmstu.datamanagementnirbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.*;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.models.Users;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.services.UserService;
import ru.naburnm8.bmstu.datamanagementnirbackend.services.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminPanelController {
    @Autowired
    private CatalogueService catalogueService;
    @Autowired
    private ClientsService clientsService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private StorageService storageService;
    @Autowired
    private SupplyService supplyService;
    @Autowired
    private UserService userService;

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
        List<Orders> ordersList = ordersService.getAllOrders();
        model.addAttribute("orders", ordersList);
        return "admin/orders";
    }

    @GetMapping("/storage")
    public String storage(Model model) {
        List<Storage> storageList = storageService.getAllStorages();
        model.addAttribute("storage", storageList);
        return "admin/storage";
    }

    @GetMapping("/supply")
    public String supply(Model model) {
        List<Supply> supplyList = supplyService.getAllSupply();
        model.addAttribute("supply", supplyList);
        return "admin/supply";
    }

    @GetMapping("/users")
    public String users(Model model) {
        List<Users> usersList = userService.getAllUsers();
        model.addAttribute("users", usersList);
        return "admin/users";
    }
}
