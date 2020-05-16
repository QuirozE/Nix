package com.naat.nix.menu.controller;

import java.util.ArrayList;

import com.naat.nix.menu.model.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MenuController {

  	/* El servicio para manejar las operaciones sobre los platillos */
  	@Autowired
  	FoodService foodService;

  	/**
    * Solicitud para ver todos los platillos del menu
  	**/
  	@RequestMapping( value = "/menu", method = RequestMethod.GET )
  	public ModelAndView verCarrito() {
  		ModelAndView modelAndView = new ModelAndView("menu");
  		ArrayList<Food> platillos = new ArrayList<Food>(foodService.obtenerPlatillos());
  		modelAndView.addObject("menu", platillos);
  		return modelAndView;
  	}

}
