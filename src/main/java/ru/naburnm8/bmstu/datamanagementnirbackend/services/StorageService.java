package ru.naburnm8.bmstu.datamanagementnirbackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Catalogue;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Storage;
import ru.naburnm8.bmstu.datamanagementnirbackend.repositories.StorageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StorageService {
    @Autowired
    private StorageRepository storageRepository;

    public List<Storage> getAllStorages() {
        return storageRepository.findAll();
    }
    public Storage createStorage(Storage storage) {
        return storageRepository.save(storage);
    }
    public void deleteStorageById(int idItem) {
        storageRepository.deleteById(idItem);
    }
    public Optional<Storage> getStorageById(int idItem) {
        return storageRepository.findById(idItem);
    }
    public Storage updateStorage(int id, Storage updatedStorage) {
        Optional<Storage> storageOptional = storageRepository.findById(id);
        if (storageOptional.isPresent()) {
            Storage storage = storageOptional.get();
            storage.setItem(updatedStorage.getItem());
            storage.setQuantity(updatedStorage.getQuantity());
            return storageRepository.save(storage);
        }
        else {
            return null;
        }
    }
    public void createIfNotPresent(Catalogue catalogue) {
        Optional<Storage> storageOptional = storageRepository.findByItem(catalogue);
        if (storageOptional.isPresent()) {
            storageOptional.get();
            return;
        }
        Storage storage = new Storage();
        storage.setItem(catalogue);
        storage.setQuantity(1);
        storageRepository.save(storage);
    }
    public void deleteByCatalogue(Catalogue catalogue){
        Optional<Storage> storageOptional = storageRepository.findByItem(catalogue);
        storageOptional.ifPresent(storage -> storageRepository.deleteById(storage.getId()));
    }
}
