package ru.naburnm8.bmstu.datamanagementnirbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Supply;
import ru.naburnm8.bmstu.datamanagementnirbackend.repositories.SupplyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SupplyService {
    @Autowired
    private SupplyRepository supplyRepository;

    public List<Supply> getAllSupply() {
        return supplyRepository.findAll();
    }
    public Supply createSupply(Supply supply) {
        return supplyRepository.save(supply);
    }
    public Optional<Supply> getSupplyById(int id) {
        return supplyRepository.findById(id);
    }
    public void deleteSupplyById(int id) {
        supplyRepository.deleteById(id);
    }
    public Supply updateSupply(int id, Supply updatedSupply) {
        return supplyRepository.findById(id).map(supply -> {
            supply.setDateOfArrival(updatedSupply.getDateOfArrival());
            supply.setItem(updatedSupply.getItem());
            supply.setQuantity(updatedSupply.getQuantity());
            return supplyRepository.save(supply);
        }).orElseGet(() -> {
            updatedSupply.setId(id);
            return supplyRepository.save(updatedSupply);
        });
    }

}
