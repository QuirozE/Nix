package com.naat.nix.menu.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.naat.nix.menu.model.Cart;
import com.naat.nix.menu.model.CartID;

@Repository
public interface CartRepository extends CrudRepository<Cart, CartID>{}
