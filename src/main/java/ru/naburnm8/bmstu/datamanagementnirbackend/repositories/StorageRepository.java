package ru.naburnm8.bmstu.datamanagementnirbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Catalogue;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Storage;

import java.util.Optional;

public interface StorageRepository extends JpaRepository<Storage, Integer> {
    Optional<Storage> findByItem(Catalogue catalogue);
}
