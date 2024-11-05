package ru.naburnm8.bmstu.datamanagementnirbackend.controllers.tableUIControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Orders;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Storage;
import ru.naburnm8.bmstu.datamanagementnirbackend.services.OrdersService;
import ru.naburnm8.bmstu.datamanagementnirbackend.services.StorageService;

import java.util.Optional;

@Controller
@RequestMapping("/admin/storage")
public class StorageControllerWeb {
    @Autowired
    private StorageService storageService;

    @GetMapping("/add")
    public String addStorageForm(Model model) {
        model.addAttribute("storage", new Storage());
        return "admin/storage/add";
    }

    @PostMapping("/add")
    public String addStorage(@ModelAttribute("storage") Storage storage) {
        storageService.createStorage(storage);
        return "redirect:/admin/storage";
    }
    @GetMapping("/edit/{id}")
    public String editStorageForm(@PathVariable("id") int id, Model model) {
        Optional<Storage> object = storageService.getStorageById(id);
        if (object.isPresent()) {
            model.addAttribute("storage", object.get());
            return "admin/storage/edit";
        } else {
            return "redirect:/admin/storage";
        }
    }
    @PostMapping("/edit/{id}")
    public String updateStorage(@PathVariable("id") int id, @ModelAttribute Storage object) {
        storageService.updateStorage(id, object);
        return "redirect:/admin/storage";
    }
    @GetMapping("/delete/{id}")
    public String deleteStorage(@PathVariable("id") int id) {
        storageService.deleteStorageById(id);
        return "redirect:/admin/storage";
    }
}
