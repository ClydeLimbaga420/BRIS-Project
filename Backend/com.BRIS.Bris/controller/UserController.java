package com.BRIS.Bris.controller;

import com.BRIS.Bris.entity.User;
import com.BRIS.Bris.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam String username,
                              @RequestParam String password,
                              Model model) {

        User user = userService.login(username, password);

        if (user != null) {
            model.addAttribute("username", user.getUsername());
            return "homepage";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login"; 
        }
    }
}
