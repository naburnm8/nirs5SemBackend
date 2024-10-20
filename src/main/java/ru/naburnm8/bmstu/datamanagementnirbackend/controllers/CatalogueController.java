package ru.naburnm8.bmstu.datamanagementnirbackend.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Catalogue;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Storage;
import ru.naburnm8.bmstu.datamanagementnirbackend.services.CatalogueService;
import ru.naburnm8.bmstu.datamanagementnirbackend.services.StorageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/catalogue")
public class CatalogueController {

    @Autowired
    private CatalogueService catalogueService;

    @Autowired
    private StorageService storageService;

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
        Catalogue added = catalogueService.createCatalogue(catalogue);
        ArrayList<Catalogue> catalogues = new ArrayList<>(catalogueService.getAllCatalogues());
        for(Catalogue c: catalogues) {
            storageService.createIfNotPresent(c);
        }
        return added;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Catalogue> updateCatalogue(@PathVariable int id, @RequestBody Catalogue catalogue) {
        return ResponseEntity.ok(catalogueService.updateCatalogue(id, catalogue));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCatalogue(@PathVariable int id) {
        Optional<Catalogue> catalogue = catalogueService.getCatalogueById(id);
        if (catalogue.isPresent()) {
            storageService.deleteByCatalogue(catalogue.get());
            catalogueService.deleteCatalogueById(id);
        }
        return ResponseEntity.ok().build();
    }
}
