package com.example.IT355_PZ01_5363.controller.client;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String showHome(HttpSession session) {
        String role = (String) session.getAttribute("role");
        if (!"USER".equals(role)) {
            return "redirect:/";
        }
        return "client/home";
    }
}
