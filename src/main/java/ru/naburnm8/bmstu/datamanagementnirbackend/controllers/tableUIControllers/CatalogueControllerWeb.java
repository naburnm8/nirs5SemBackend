package ru.naburnm8.bmstu.datamanagementnirbackend.controllers.tableUIControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Catalogue;
import ru.naburnm8.bmstu.datamanagementnirbackend.services.CatalogueService;
import ru.naburnm8.bmstu.datamanagementnirbackend.services.StorageService;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/admin/catalogue")
public class CatalogueControllerWeb {

    @Autowired
    CatalogueService catalogueService;
    @Autowired
    StorageService storageService;

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("catalogue", new Catalogue());
        return "admin/catalogue/add";
    }
    @PostMapping("/add")
    public String addCatalogue(@ModelAttribute Catalogue catalogue, Model model) {
        catalogueService.createCatalogue(catalogue);
        ArrayList<Catalogue> catalogues = new ArrayList<>(catalogueService.getAllCatalogues());
        for(Catalogue c: catalogues) {
            storageService.createIfNotPresent(c);
        }
        return "redirect:/admin/catalogue";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Optional<Catalogue> catalogueOptional = catalogueService.getCatalogueById(id);
        Catalogue catalogue;
        if (catalogueOptional.isPresent()) {
            catalogue = catalogueOptional.get();
        }
        else {
            return "redirect:/admin/catalogue";
        }
        model.addAttribute("catalogue", catalogue);
        return "admin/catalogue/edit";
    }
    @PostMapping("/edit/{id}")
    public String editCatalogue(@PathVariable int id, @ModelAttribute Catalogue catalogue, Model model) {
        catalogueService.updateCatalogue(id, catalogue);
        return "redirect:/admin/catalogue";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        catalogueService.deleteCatalogueById(id);
        return "redirect:/admin/catalogue";
    }

}

