package com.example.IT355_PZ01_5363.controller;

import com.example.IT355_PZ01_5363.model.Client;
import com.example.IT355_PZ01_5363.repository.DB;
import com.example.IT355_PZ01_5363.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    private final ClientService clientService;

    public RegisterController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("error", false);
        return "register";
    }

    @PostMapping("/register")
    public String handleRegistration(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String phoneNumber, @RequestParam String email, @RequestParam String username, @RequestParam String password, Model model){
        if(clientService.clientAlreadyExists(username)){
            model.addAttribute("error", "User already exists!");
            return "register";
        }

        Client client = new Client(firstName, lastName, phoneNumber, email, username, password);
        clientService.registerClient(client);

        return "redirect:/";
    }

}
