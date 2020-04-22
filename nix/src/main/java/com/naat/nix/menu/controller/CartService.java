package com.naat.nix.menu.controller;

import com.naat.nix.menu.controller.CartRepository;
import com.naat.nix.menu.model.Cart;
import com.naat.nix.menu.model.CartID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CartService {

  @Autowired
  private CartRepository repository;

  /* Obtiene todos los carritos */
  public ArrayList<Cart> obtenerCarritos (){
    ArrayList<Cart> carritos = (ArrayList<Cart>) repository.findAll();
    return carritos;
  }

  /* Obtiene el carrito por el id */
  public Cart obtenerCarritoId (CartID id) {
    Optional<Cart> cart = repository.findById(id);
    if (cart.isPresent()) {
      return cart.get();
    }
    return null;
  }

  /**
  * Guarda el carrito en la base de datos
  * @param c el carrito a guardar
  */
  public Cart guardar (Cart c) {
    Cart n = repository.save(c);
    return n;
  }

  /**
  * Elimina el carrito si se encuentra en la base de datos
  * @param c el carrito a elimnar
  */

  public void eliminar (Cart c) {
    Optional<Cart> carrito = repository.findById(c.getCartId());
    if (carrito.isPresent()) {
      repository.deleteById(c.getCartId());
    }
  }

  /**
  * Si el carrito se encuentra en la base de datos, lo actualiza
  * @param c el carrito que se actualiza
  */
  public Cart actualizar (Cart c) {
    Optional<Cart> carrito = repository.findById(c.getCartId());
    Cart a = null;
    if (carrito.isPresent()) {
      a = carrito.get();
      a.setCartId(c.getCartId());
      a.setPlatillos(c.getPlatillos());
      a = repository.save(a);
    }
    return a;
  }

}
