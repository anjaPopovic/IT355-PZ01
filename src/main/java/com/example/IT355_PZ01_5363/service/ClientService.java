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

    /**
     * registers a new client
     * @param client new client to be registered
     */
    public void registerClient(Client client){
        db.getAllClients().add(client);
    }

    /**
     * attempts to login a client
     * @param username username of existing client
     * @param password password of existing client
     * @return Optional containing the matched client or empty if not found
     */
    public Optional<Client> loginClient(String username, String password){
          return db.getAllClients().stream().filter(c -> c.getUsername().equalsIgnoreCase(username) && c.getPassword().equalsIgnoreCase(password)).findFirst();
    }

    /**
     * finds a client by their username
     * @param username username
     * @return the client if found, otherwise null
     */
    public Client findClientByUsername(String username){
        return db.getAllClients().stream().filter(c -> c.getUsername().equalsIgnoreCase(username)).findFirst().orElse(null);
    }

        /*public boolean clientAlreadyExists(String username){
        if (username == null || username.trim().isEmpty()) {
            return false;
        }
        return db.getAllClients().stream()
                .anyMatch(c -> c.getUsername().equalsIgnoreCase(username));
    }*/

}
