package ru.naburnm8.bmstu.datamanagementnirbackend.controllers.tableUIControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Clients;
import ru.naburnm8.bmstu.datamanagementnirbackend.services.ClientsService;

import java.util.Optional;

@Controller
@RequestMapping("/admin/clients")
public class ClientsControllerWeb {

    @Autowired
    private ClientsService clientService;

    @GetMapping("/add")
    public String addClientForm(Model model) {
        model.addAttribute("clients", new Clients());
        return "admin/clients/add";
    }

    @PostMapping("/add")
    public String addClient(@ModelAttribute Clients client) {
        clientService.createClient(client);
        return "redirect:/admin/clients";
    }

    @GetMapping("/edit/{id}")
    public String editClientForm(@PathVariable("id") int id, Model model) {
        Optional<Clients> client = clientService.getClientById(id);
        if (client.isPresent()) {
            model.addAttribute("client", client.get());
            return "admin/clients/edit";
        } else {
            return "redirect:/admin/clients";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateClient(@PathVariable("id") int id, @ModelAttribute Clients client) {
        clientService.updateClient(id, client);
        return "redirect:/admin/clients";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") int id) {
        clientService.deleteClientById(id);
        return "redirect:/admin/clients";
    }

}
