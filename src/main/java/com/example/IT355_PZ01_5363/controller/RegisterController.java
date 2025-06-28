package com.example.IT355_PZ01_5363.controller;

import com.example.IT355_PZ01_5363.model.Client;
import com.example.IT355_PZ01_5363.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    private final ClientService clientService;
    public RegisterController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("client", new Client());
        return "register";
    }

    @PostMapping("/register")
    public String handleRegistration(@ModelAttribute("client") @Valid Client client, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Please fill out all the fields");
            return "register";
        }
        if (clientService.clientAlreadyExists(client.getUsername())) {
            model.addAttribute("error", "User already exists!");
            return "register";
        }
        clientService.registerClient(client);
        return "redirect:/";
    }
}
