package com.example.journal.controlar;

import org.springframework.ui.Model;
import com.example.journal.Entity.User;
import com.example.journal.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class loginControler {
//    @GetMapping("/login")
//    public String login() {
//        return "login"; // src/main/resources/templates/login.html
//    }
//
//    @GetMapping("/customers/home")
//    public String home() {
//        return "home"; // src/main/resources/templates/home.html
//    }

    private final UserService service;

    public loginControler(UserService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute("user") User user, Model model) {
        boolean isValid = service.checkLogin(user.getUsername(), user.getPassword()); // check DB

        if (isValid) {
            return "home";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
