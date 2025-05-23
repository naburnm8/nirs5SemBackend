package ru.naburnm8.bmstu.datamanagementnirbackend.controllers.tableUIControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Catalogue;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Supply;
import ru.naburnm8.bmstu.datamanagementnirbackend.services.CatalogueService;
import ru.naburnm8.bmstu.datamanagementnirbackend.services.SupplyService;

import java.util.Optional;

@Controller
@RequestMapping("/admin/supply")
public class SupplyControllerWeb {
    @Autowired
    private SupplyService supplyService;
    @Autowired
    private CatalogueService catalogueService;

    @GetMapping("/add")
    public String addSupplyForm(Model model) {
        model.addAttribute("supply", new Supply());
        model.addAttribute("items", catalogueService.getAllCatalogues());
        return "admin/supply/add";
    }

    @PostMapping("/add")
    public String addSupply(@ModelAttribute("supply") Supply supply, @RequestParam("itemId") int itemId) {
        Catalogue selectedItem = catalogueService.getCatalogueById(itemId).orElse(null);
        supply.setItem(selectedItem);
        supplyService.createSupply(supply);
        return "redirect:/admin/supply";
    }
    @GetMapping("/edit/{id}")
    public String editSupplyForm(@PathVariable("id") int id, Model model) {
        Optional<Supply> object = supplyService.getSupplyById(id);
        model.addAttribute("items", catalogueService.getAllCatalogues());
        if (object.isPresent()) {
            model.addAttribute("supply", object.get());
            return "admin/supply/edit";
        } else {
            return "redirect:/admin/supply";
        }
    }
    @PostMapping("/edit/{id}")
    public String updateSupply(@PathVariable("id") int id, @ModelAttribute Supply object, @RequestParam("itemId") int itemId) {
        Catalogue selectedItem = catalogueService.getCatalogueById(itemId).orElse(null);
        object.setItem(selectedItem);
        supplyService.updateSupply(id, object);
        return "redirect:/admin/supply";
    }
    @GetMapping("/delete/{id}")
    public String deleteSupply(@PathVariable("id") int id) {
        supplyService.deleteSupplyById(id);
        return "redirect:/admin/supply";
    }
}
