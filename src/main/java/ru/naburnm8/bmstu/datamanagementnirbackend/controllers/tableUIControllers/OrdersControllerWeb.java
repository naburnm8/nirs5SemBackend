package ru.naburnm8.bmstu.datamanagementnirbackend.controllers.tableUIControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Catalogue;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Clients;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Orders;
import ru.naburnm8.bmstu.datamanagementnirbackend.services.CatalogueService;
import ru.naburnm8.bmstu.datamanagementnirbackend.services.ClientsService;
import ru.naburnm8.bmstu.datamanagementnirbackend.services.OrdersService;

import java.util.Optional;

@Controller
@RequestMapping("/admin/orders")
public class OrdersControllerWeb {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private CatalogueService catalogueService;
    @Autowired
    private ClientsService clientsService;

    @GetMapping("/add")
    public String addOrdersForm(Model model) {
        model.addAttribute("order", new Orders());
        model.addAttribute("items", catalogueService.getAllCatalogues());
        model.addAttribute("clients", clientsService.getAllClients());
        return "admin/orders/add";
    }

    @PostMapping("/add")
    public String addOrders(@ModelAttribute("order") Orders order, @RequestParam("itemId") int itemId,
                            @RequestParam("clientId") int clientId) {
        Clients client = clientsService.getClientById(clientId).orElse(null);
        Catalogue catalogue = catalogueService.getCatalogueById(itemId).orElse(null);
        if (client == null || catalogue == null) {
            return "redirect:/admin/orders/";
        }
        order.setClient(client);
        order.setItem(catalogue);
        ordersService.createOrder(order);
        return "redirect:/admin/orders";
    }
    @GetMapping("/edit/{id}")
    public String editOrderForm(@PathVariable("id") int id, Model model) {
        Optional<Orders> object = ordersService.getOrderById(id);
        model.addAttribute("items", catalogueService.getAllCatalogues());
        model.addAttribute("clients", clientsService.getAllClients());
        if (object.isPresent()) {
            model.addAttribute("order", object.get());
            return "admin/orders/edit";
        } else {
            return "redirect:/admin/orders";
        }
    }
    @PostMapping("/edit/{id}")
    public String updateOrder(@PathVariable("id") int id, @ModelAttribute Orders object, @RequestParam("itemId") int itemId,
                              @RequestParam("clientId") int clientId) {
        Clients client = clientsService.getClientById(clientId).orElse(null);
        Catalogue catalogue = catalogueService.getCatalogueById(itemId).orElse(null);
        if (client == null || catalogue == null) {
            return "redirect:/admin/orders/";
        }
        object.setClient(client);
        object.setItem(catalogue);
        ordersService.updateOrderById(id, object);
        return "redirect:/admin/orders";
    }
    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable("id") int id) {
        ordersService.deleteOrderById(id);
        return "redirect:/admin/orders";
    }
}
