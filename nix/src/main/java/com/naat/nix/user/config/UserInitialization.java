package com.naat.nix.user.config;

import javax.annotation.PostConstruct;

import com.naat.nix.user.controller.AdminRepository;
import com.naat.nix.user.controller.UserService;
import com.naat.nix.user.model.Admin;
import com.naat.nix.user.model.ClientForm;
import com.naat.nix.user.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserInitialization {

  @Autowired
  private PasswordEncoder encoder;

  @Autowired
  private AdminRepository adminDao;

  @Autowired
  private UserService userService;

  @PostConstruct
  public void addUsers() {

    // Administrador
    var adminUser = new User("admin@naat.io", encoder.encode("admin123"));
    var admin = new Admin(adminUser);
    adminUser.setAdmin(admin);
    adminDao.save(admin);

    // Cliente
    var titoForm = new ClientForm();
    titoForm.setUsername("Tito");
    titoForm.setPhone("5589675432"); 
    titoForm.setAddress("Av. Paz, 15, Los Pinos, Ciudad de México");

    var clientTitoUser = new User("tito@correo.com", encoder.encode("12345678"));
    var clientTito = userService.newClient(clientTitoUser, titoForm);
    clientTito.setScore(0);

    var mariaForm = new ClientForm();
    mariaForm.setUsername("Maria");
    mariaForm.setPhone("5543546789");
    mariaForm.setAddress("Árbol, 64, Jardín, Ciudad de México");

    var clientMariaUser = new User("maria@correo.com", encoder.encode("qwertui"));
    var clientMaria = userService.newClient(clientMariaUser, mariaForm);
    clientMaria.setScore(0);

    // Repartidores
    var deliveryUser1 = new User("adrian@correo.com", encoder.encode("1q2w3e4r"));
    userService.newDelivery(deliveryUser1);

    var deliveryUser2 = new User("eduardo@correo.com", encoder.encode("r4e3w2q1"));
    userService.newDelivery(deliveryUser2);

    var deliveryUser3 = new User("jessica@correo.com", encoder.encode("asdfghjk"));
    userService.newDelivery(deliveryUser3);
  }
}
