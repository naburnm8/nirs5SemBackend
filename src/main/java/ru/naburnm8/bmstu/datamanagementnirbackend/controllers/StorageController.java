package ru.naburnm8.bmstu.datamanagementnirbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Storage;
import ru.naburnm8.bmstu.datamanagementnirbackend.services.StorageService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @GetMapping
    public List<Storage> getAllStorages() {
        return storageService.getAllStorages();
    }

    @GetMapping("/{idItem}")
    public ResponseEntity<Storage> getStorageById(@PathVariable int id) {
        Optional<Storage> storage = storageService.getStorageById(id);
        return storage.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Storage createStorage(@RequestBody Storage storage) {
        return storageService.createStorage(storage);
    }

    @PutMapping("/{idItem}")
    public ResponseEntity<Storage> updateStorage(@PathVariable int idItem, @RequestBody Storage storage) {
        return ResponseEntity.ok(storageService.updateStorage(idItem, storage));
    }

    @DeleteMapping("/{idItem}")
    public ResponseEntity<Void> deleteStorage(@PathVariable int idItem) {
        storageService.deleteStorageById(idItem);
        return ResponseEntity.ok().build();
    }
}
