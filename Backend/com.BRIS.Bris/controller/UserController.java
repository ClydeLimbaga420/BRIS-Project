package com.BRIS.Login.controller;

import com.BRIS.Login.entity.User;
import com.BRIS.Login.service.UserService;
import com.BRIS.Login.service.UpdateService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UpdateService updateService;

    private boolean isLoggedIn(HttpSession session) {
        return session != null && session.getAttribute("user") != null;
    }

    private void preventCaching(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
    }


    @GetMapping("/")
    public String loginPage(HttpSession session, Model model,
                            @RequestParam(value = "logout", required = false) String logout) {
        if (session != null) session.invalidate();
        if (logout != null) model.addAttribute("logoutMsg", "You have successfully logged out.");
        return "login";
    }


    @PostMapping("/login")
    public String loginSubmit(@RequestParam String gmail_account,
                              @RequestParam String password,
                              HttpSession session, Model model) {

        User user = userService.login(gmail_account, password);
        if (user != null) {
            session.setAttribute("user", user);
            updateService.updateData();
            return "redirect:/homepage";
        } else {
            model.addAttribute("error", "Invalid gmail account or password");
            return "login";
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        if (session != null) session.invalidate();
        return "redirect:/?logout";
    }


    @GetMapping("/homepage")
    public String homepage(HttpSession session, HttpServletResponse response) {
        if (!isLoggedIn(session)) return "redirect:/";
        preventCaching(response);
        return "homepage";
    }

    @GetMapping("/userguide")
    public String userGuide(HttpSession session, HttpServletResponse response) {
        if (!isLoggedIn(session)) return "redirect:/";
        preventCaching(response);
        return "userGuide";
    }

    @GetMapping("/history")
    public String history(HttpSession session, HttpServletResponse response) {
        if (!isLoggedIn(session)) return "redirect:/";
        preventCaching(response);
        return "history";
    }

    @GetMapping("/newresident")
    public String newResident(HttpSession session, HttpServletResponse response) {
        if (!isLoggedIn(session)) return "redirect:/";
        preventCaching(response);
        return "newresident";
    }

    @GetMapping("/residentsrecords")
    public String residentsRecords(HttpSession session, HttpServletResponse response) {
        if (!isLoggedIn(session)) return "redirect:/";
        preventCaching(response);
        return "residentsrecords";
    }

    @GetMapping("/blotterrecords")
    public String blotterRecords(HttpSession session, HttpServletResponse response) {
        if (!isLoggedIn(session)) return "redirect:/";
        preventCaching(response);
        return "blotterrecords";
    }

    @GetMapping("/reportcase")
    public String reportCase(HttpSession session, HttpServletResponse response) {
        if (!isLoggedIn(session)) return "redirect:/";
        preventCaching(response);
        return "reportcase";
    }

    @GetMapping("/certificates")
    public String certificates(HttpSession session, HttpServletResponse response) {
        if (!isLoggedIn(session)) return "redirect:/";
        preventCaching(response);
        return "certificates";
    }

    @GetMapping("/blotterinfo")
    public String blotterInfo(HttpSession session, HttpServletResponse response) {
        if (!isLoggedIn(session)) return "redirect:/";
        preventCaching(response);
        return "blotterinfo";
    }
}
