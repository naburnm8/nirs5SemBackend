package ru.naburnm8.bmstu.datamanagementnirbackend.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.models.CustomUserDetails;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.models.Users;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);
        return new CustomUserDetails(user);
    }
}
