package ru.naburnm8.bmstu.datamanagementnirbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.naburnm8.bmstu.datamanagementnirbackend.models.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {}
