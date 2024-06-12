package ru.naburnm8.bmstu.datamanagementnirbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Catalogue;
import ru.naburnm8.bmstu.datamanagementnirbackend.repositories.CatalogueRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogueService {
    @Autowired
    private CatalogueRepository catalogueRepository;

    public List<Catalogue> getAllCatalogues() {
        return catalogueRepository.findAll();
    }

    public Optional<Catalogue> getCatalogueById(int id) {
        return catalogueRepository.findById(id);
    }

    public Catalogue createCatalogue(Catalogue catalogue) {
        return catalogueRepository.save(catalogue);
    }

    public void deleteCatalogueById(int id) {
        catalogueRepository.deleteById(id);
    }

    public Catalogue updateCatalogue(int id, Catalogue updatedCatalogue) {
        return catalogueRepository.findById(id).map(catalogue -> {
            catalogue.setItemName(updatedCatalogue.getItemName());
            catalogue.setItemPrice(updatedCatalogue.getItemPrice());
            return catalogueRepository.save(catalogue);
        }).orElseGet(() -> {
            updatedCatalogue.setId(id);
            return catalogueRepository.save(updatedCatalogue);
        });
    }
}
