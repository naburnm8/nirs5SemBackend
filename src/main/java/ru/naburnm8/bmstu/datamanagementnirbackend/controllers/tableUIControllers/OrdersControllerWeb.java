package ru.naburnm8.bmstu.datamanagementnirbackend.controllers.tableUIControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Orders;
import ru.naburnm8.bmstu.datamanagementnirbackend.services.OrdersService;

import java.util.Optional;

@Controller
@RequestMapping("/admin/orders")
public class OrdersControllerWeb {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/add")
    public String addOrdersForm(Model model) {
        model.addAttribute("order", new Orders());
        return "admin/orders/add";
    }

    @PostMapping("/add")
    public String addOrders(@ModelAttribute("order") Orders order) {
        ordersService.createOrder(order);
        return "redirect:/admin/orders";
    }
    @GetMapping("/edit/{id}")
    public String editOrderForm(@PathVariable("id") int id, Model model) {
        Optional<Orders> object = ordersService.getOrderById(id);
        if (object.isPresent()) {
            model.addAttribute("order", object.get());
            return "admin/orders/edit";
        } else {
            return "redirect:/admin/orders";
        }
    }
    @PostMapping("/edit/{id}")
    public String updateOrder(@PathVariable("id") int id, @ModelAttribute Orders object) {
        ordersService.updateOrderById(id, object);
        return "redirect:/admin/orders";
    }
    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable("id") int id) {
        ordersService.deleteOrderById(id);
        return "redirect:/admin/orders";
    }
}
