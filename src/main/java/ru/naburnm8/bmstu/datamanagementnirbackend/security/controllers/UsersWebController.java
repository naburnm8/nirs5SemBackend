package ru.naburnm8.bmstu.datamanagementnirbackend.security.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.additionals.authmodels.RegisterRequest;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.models.Users;
import ru.naburnm8.bmstu.datamanagementnirbackend.security.services.UserService;

import java.util.Optional;

@Controller
@RequestMapping("/admin/users")
public class UsersWebController {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/add")
    public String getAddForm(Model model) {
        model.addAttribute("reg_req", new RegisterRequest());
        return "admin/users/add";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute() RegisterRequest registerRequest) {
        if(userService.getUserByUsername(registerRequest.getUsername()).isPresent()) {
            return "redirect:/admin/users";
        }
        Users user = new Users();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole(registerRequest.getRole());
        userService.createUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable int id, Model model) {
        Optional<Users> user = userService.getUserById(id);
        if(user.isPresent()){
            model.addAttribute("user", user.get());
            return "admin/users/edit";
        }
        else {
            return "redirect:/admin/users";
        }
    }
    @PostMapping("/edit/{id}")
    public String editUser(@ModelAttribute() Users user, @PathVariable int id) {
        Optional<Users> userInDB = userService.getUserById(id);
        if(userInDB.isPresent()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentUserName = authentication.getName();
            boolean toLogout = userInDB.get().getUsername().equals(currentUserName);
            userInDB.get().setRole(user.getRole());
            userInDB.get().setUsername(user.getUsername());
            if (!userInDB.get().getPassword().equals(user.getPassword())) {
                userInDB.get().setPassword(passwordEncoder.encode(user.getPassword()));
            }
            userService.updateUser(id, userInDB.get());
            if (toLogout){
                return "redirect:/logout";
            }
        }
        return "redirect:/admin/users";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        Optional<Users> user = userService.getUserById(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        if (user.isPresent()){
            if(user.get().getUsername().equals(currentUserName)) {
                return "redirect:/admin/users";
            }
            userService.deleteUserById(id);
        }
        return "redirect:/admin/users";
    }
}
