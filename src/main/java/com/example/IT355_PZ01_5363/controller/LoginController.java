package com.example.IT355_PZ01_5363.controller;

import com.example.IT355_PZ01_5363.model.Client;
import com.example.IT355_PZ01_5363.service.ClientService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Optional;

@Controller
public class LoginController {

    private final ClientService clientService;

    @Value("${admin.username}")
    private String adminUsername;

    @Value("${admin.password}")
    private String adminPassword;

    public LoginController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
    public String showLoginForm(Model model){
        model.addAttribute("error", false);
        return "login";
    }

    @PostMapping("/")
    public String handleLogin(@RequestParam String username, @RequestParam String password, HttpSession session, Model model){
        //admin
        if(username.equals(adminUsername) && password.equals(adminPassword)){
            session.setAttribute("role", "ADMIN");
            session.setAttribute("username", username);
            return "redirect:/admin/dashboard";
        }
        //client
        Optional<Client> client = clientService.loginClient(username, password);
        if(client.isPresent()){
            session.setAttribute("role", "USER");
            session.setAttribute("username", client.get().getUsername());
            return "redirect:/home";
        }
        model.addAttribute("error", true);
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
