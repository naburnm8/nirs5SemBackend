package ru.naburnm8.bmstu.datamanagementnirbackend.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.models.Users;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByUsername(String username);
}
