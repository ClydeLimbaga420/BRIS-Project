package com.BRIS.Bris.controller;

import com.BRIS.Bris.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @GetMapping("/")
    public String login() {
        return "login"; // Thymeleaf template: login.html
    }

    // Handles login form POST
    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute User user, Model model) {
        String username = user.getUsername();
        String password = user.getPassword();

        // Simple hardcoded check (replace with DB check later)
        if ("admin".equals(username) && "12345".equals(password)) {
            return "homepage"; // Thymeleaf template: homepage.html
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login"; // stay on login page
        }
    }
}
