package ru.naburnm8.bmstu.datamanagementnirbackend.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Catalogue;
import ru.naburnm8.bmstu.datamanagementnirbackend.services.CatalogueService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/catalogue")
public class CatalogueController {

    @Autowired
    private CatalogueService catalogueService;

    @GetMapping
    public List<Catalogue> getAllCatalogues() {
        return catalogueService.getAllCatalogues();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Catalogue> getCatalogueById(@PathVariable int id) {
        Optional<Catalogue> catalogue = catalogueService.getCatalogueById(id);
        return catalogue.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Catalogue createCatalogue(@RequestBody Catalogue catalogue) {
        return catalogueService.createCatalogue(catalogue);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Catalogue> updateCatalogue(@PathVariable int id, @RequestBody Catalogue catalogue) {
        Optional<Catalogue> catalogueOptional = catalogueService.getCatalogueById(id);
        return catalogueOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCatalogue(@PathVariable int id) {
        catalogueService.deleteCatalogueById(id);
        return ResponseEntity.ok().build();
    }
}
