package ru.naburnm8.bmstu.datamanagementnirbackend.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.models.Users;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<Users> getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public Users createUser(Users user){
        return userRepository.save(user);
    }

    public void deleteUserByUsername(String username){
        userRepository.deleteByUsername(username);
    }
}
