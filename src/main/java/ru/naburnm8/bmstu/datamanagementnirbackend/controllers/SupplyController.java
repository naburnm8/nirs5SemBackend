package ru.naburnm8.bmstu.datamanagementnirbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Supply;
import ru.naburnm8.bmstu.datamanagementnirbackend.services.SupplyService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/supplies")
public class SupplyController {
    @Autowired
    private SupplyService supplyService;

    @GetMapping
    public List<Supply> getAllSupply() {
        return supplyService.getAllSupply();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supply> getSupplyById(@PathVariable int id) {
        Optional<Supply> supplyOptional = supplyService.getSupplyById(id);
        return supplyOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Supply createSupply(@RequestBody Supply supply) {
        return supplyService.createSupply(supply);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supply> updateSupply(@PathVariable int id, @RequestBody Supply supply) {
        return ResponseEntity.ok(supplyService.updateSupply(id, supply));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupply(@PathVariable int id) {
        supplyService.deleteSupplyById(id);
        return ResponseEntity.ok().build();
    }
}
