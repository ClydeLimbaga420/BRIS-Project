package com.BRIS.Login.controller;

import com.BRIS.Login.entity.User;
import com.BRIS.Login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


@Controller
public class SignUpController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/signup")
    public String showSignupPage() {
        return "signup"; // loads signup.html
    }

    @PostMapping("/signup")
    public String signup(@RequestParam("gmail_account") String gmail,
                         @RequestParam("password") String password,
                         @RequestParam("confirm_password")String confirm,
                         Model model) {

        if (userRepository.count() > 0) {
            model.addAttribute("error","An Account already Exist and cannot create a new one.");
            return "signup";
        }

        if (!password.equals(confirm)) {
            model.addAttribute("error","Password do not Match.");
            return "signup";
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashPassword = encoder.encode(password);

        User user =new User();
        user.setGmailAccount(gmail);
        user.setPassword(hashPassword);
        userRepository.save(user);

        return "redirect:/login";
    }
}
