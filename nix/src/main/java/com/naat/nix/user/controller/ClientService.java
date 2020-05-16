package com.naat.nix.user.controller;

import com.naat.nix.user.model.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client findByEmail (String email){
      return clientRepository.findByEmail(email);
    }

    public void saveClient (Client client) {
      clientRepository.save(client);
    }

}
