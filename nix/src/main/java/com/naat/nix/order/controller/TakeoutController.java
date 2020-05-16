package com.naat.nix.order.controller;

import com.naat.nix.user.config.UserWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/orders")
public class TakeoutController {
  @Autowired
  private TakeoutService service;

  @GetMapping
  public String getOrders(Model model, @AuthenticationPrincipal UserWrapper principal) {
    var orders = service.getOrders(principal);
    model.addAllAttributes(orders);
    return "orders";
  }

  @GetMapping("/select/{takeoutId}")
  public String selectOrder(Model model, @PathVariable Long takeoutId,
      @AuthenticationPrincipal UserWrapper principal) throws Exception {

    service.selectOrder(principal, takeoutId);
    return "redirect:/orders";
  }

  @GetMapping("update/{takeoutId}")
  public String updateOrder(Model model, @PathVariable Long takeoutId,
    @AuthenticationPrincipal UserWrapper principal) throws Exception {

    service.updateStatusOrder(principal, takeoutId);
    return "redirect:/orders";
  }
}