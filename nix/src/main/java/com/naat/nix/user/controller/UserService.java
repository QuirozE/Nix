package com.naat.nix.user.controller;

import com.naat.nix.user.model.Client;
import com.naat.nix.user.model.DeliveryMan;
import com.naat.nix.user.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DeliveryManRepository deliveryRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public User findByEmail (String email){
      return userRepository.findByEmail(email);
    }

    public User findByUsername (String name) {
      return userRepository.findByUsername(name);
    }

    public Client newClient (User user) {
      Client client = new Client();
      client.setEmail(user.getEmail());
      client.setUser(user);
      user.setClient(client);
      clientRepository.save(client);
      return client;
    }

    public DeliveryMan newDelivery(User user) {
      DeliveryMan deliveryMan = new DeliveryMan();
      deliveryMan.setEmail(user.getEmail());
      deliveryMan.setUser(user);
      user.setDeliveryMan(deliveryMan);
      deliveryRepository.save(deliveryMan);
      return deliveryMan;
    }

    public void saveUser (User user){
      user.setPassword (bCryptPasswordEncoder.encode(user.getPassword()));
      userRepository.save(user);
    }

}
