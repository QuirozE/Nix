package com.naat.nix.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Entity representing users of our system. Extends UserDetails to use with
 * Spring Security.
 */
@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "Usuario")
public class User {

  @Id
  @NonNull
  @Column(name = "correo")
  private String email;

  @Column(name = "nombre")
  private String username;

  @NonNull
  @Column(name = "contraseña")
  private String password;

  @Transient
  private String passwordConfirm;

  @OneToOne(mappedBy = "user")
  @NotFound(action=NotFoundAction.IGNORE)
  private Admin admin;

  @OneToOne(mappedBy = "user")
  @NotFound(action=NotFoundAction.IGNORE)
  private Client client;

  @OneToOne(mappedBy = "user")
  @NotFound(action=NotFoundAction.IGNORE)
  private DeliveryMan deliveryMan;
}
