package ru.naburnm8.bmstu.datamanagementnirbackend.security.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.models.Users;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.repositories.UserRepository;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return UserDetailsImplementation.build(user);
    }

}
