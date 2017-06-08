package com.company.controller;

import com.company.persistence.dto.UserDto;
import com.company.persistence.entity.User;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new UserDto());
        return "auth/register";
    }

    @PostMapping(value = "/registerProcess")
    public String addUser(@ModelAttribute("user") @Valid UserDto user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "auth/register";
        }
        if (userService.exists(user.getLogin())) {
            model.addAttribute("errorMessage", "User with that login already exists!");
            return "auth/register";
        } else {
            User userForSave = new User();
            userForSave.setLogin(user.getLogin());
            userForSave.setPassword(user.getPassword());
            userService.save(userForSave);
        }
        model.addAttribute("firstName", user.getLogin());
        return "auth/login";
    }

}
