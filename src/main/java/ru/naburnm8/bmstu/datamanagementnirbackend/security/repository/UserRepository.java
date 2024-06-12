package ru.naburnm8.bmstu.datamanagementnirbackend.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.models.Users;

public interface UserRepository extends JpaRepository<Users,Integer> {
    Users findByUsername(String username);
}
