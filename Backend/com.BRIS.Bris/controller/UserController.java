package com.BRIS.Login.controller;

import com.BRIS.Login.entity.User;
import com.BRIS.Login.service.UserService;
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
            return "redirect:/homepage";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
    @GetMapping("/homepage")
    public String homepage() {
        return "homepage";
    }
    @Controller
    public class userGuideCon {
        @GetMapping("/userguide")
        public String userGuide() {
            return "userGuide";
        }
    }
    @Controller
    public class logOutCon {
        @GetMapping("/login")
        public String logout() {
            return "login";
        }
    }
    @Controller
    public class addResidentCon {
        @GetMapping("/newresident")
        public String newResident() {
            return "newresident";
        }
    }
    @Controller
    public class residentsRecordsCon {
        @GetMapping("/residentsrecords")
        public String residentsRecords() {
            return "residentsrecords";
        }
    }
    @Controller
    public class blotterRecordsCon {
        @GetMapping("/blotterrecords")
        public String blotterRecords() {
            return "blotterrecords";
        }
    }
    @Controller
    public class reportCaseCon {
        @GetMapping("/reportcase")
        public String reportCase() {
            return "reportcase";
        }
    }
    @Controller
    public class certificatesCon {
        @GetMapping("/certificates")
        public String certificates() {
            return "certificates";
        }
    }



}
