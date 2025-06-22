package com.example.IT355_PZ01_5363.service;

import com.example.IT355_PZ01_5363.model.Client;
import com.example.IT355_PZ01_5363.repository.DB;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    private final DB db;

    public ClientService(DB db) {
        this.db = db;
    }

    public boolean clientAlreadyExists(String username){
        return db.getAllClients().stream().anyMatch(c -> c.getUsername().equalsIgnoreCase(username));
    }

    public void registerClient(Client client){
        db.getAllClients().add(client);
    }

    public Optional<Client> loginClient(String username, String password){
          return db.getAllClients().stream().filter(c -> c.getUsername().equalsIgnoreCase(username) && c.getPassword().equalsIgnoreCase(password)).findFirst();
    }

    //to find client by username for reviews
    public Client findClientByUsername(String username){
        return db.getAllClients().stream().filter(c -> c.getUsername().equalsIgnoreCase(username)).findFirst().orElse(null);
    }

}
