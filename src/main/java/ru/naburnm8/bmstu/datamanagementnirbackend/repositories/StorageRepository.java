package ru.naburnm8.bmstu.datamanagementnirbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Storage;

public interface StorageRepository extends JpaRepository<Storage, Integer> {}
