package ru.naburnm8.bmstu.datamanagementnirbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Catalogue;

public interface CatalogueRepository extends JpaRepository<Catalogue, Integer> {}
