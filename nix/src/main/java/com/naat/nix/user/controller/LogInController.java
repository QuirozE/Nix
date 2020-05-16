package com.naat.nix.user.controller;

import com.naat.nix.user.config.UserWrapper;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogInController {

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null){
          model.addAttribute("error", "El correo o contraseña son incorrectos");
        }
        if (logout != null){
          model.addAttribute("message", "Vuelve pronto");
        }
        return "login";
    }

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal UserWrapper user) {
        String email = user.getCustomUser().getEmail();
        model.addAttribute("currentUsername", email);
        if(user.getCustomUser().getClient() != null) {
          return "redirect:/menu";
        }
        return "redirect:/orders";
    }
}
