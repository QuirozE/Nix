package com.naat.nix.user.controller;

import javax.validation.Valid;

import com.naat.nix.user.model.User;
import com.naat.nix.validator.UserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SigUpController {

      @Autowired
      private UserService userService;

      @Autowired
      private SecurityService securityService;

      @Autowired
      private UserValidator userValidator;

      @GetMapping("/signup")
      public String registration(Model model) {
          model.addAttribute("user", new User());
          return "signup";
      }

      @PostMapping("/signup")
      public String registration(@ModelAttribute @Valid User user, BindingResult bindingResult) {
          userValidator.validate(user, bindingResult);

          if (bindingResult.hasErrors()) {
            return "signup";
          }

          userService.saveUser(user);

          userService.newClient(user);

          securityService.autoLogin(user.getUsername(), user.getPassword());

          return "redirect:/";
      }
      
      @GetMapping("/signup/delivery")
      @Secured("ROLE_ADMIN")
      public String deliveryRegistration(Model model) {
        model.addAttribute("delivery", new User());
        return "delivery_signup";
      }

      @PostMapping("signup/delivery")
      @Secured("ROLE_ADMIN")
      public String deliveryRegistration(@ModelAttribute @Valid User user, BindingResult result) {
        userValidator.validate(user, result);

        if(result.hasErrors()) {
          return "delivery_signup";
        }

        userService.saveUser(user);

        userService.newDelivery(user);

        return "redirect:/";
      }
}
