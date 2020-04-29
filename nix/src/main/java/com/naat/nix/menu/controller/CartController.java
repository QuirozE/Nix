package com.naat.nix.menu.controller;

import com.naat.nix.menu.controller.CartService;
import com.naat.nix.menu.controller.FoodService;
import com.naat.nix.menu.model.Food;
import com.naat.nix.menu.model.Cart;
import com.naat.nix.menu.model.CartID;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
* Controlador encargado de la lectura, manipulacion de platillos del carrito
*/
@Controller
@RequestMapping(value = "/carrito")
public class CartController {

	/* El servicio para manejar las operaciones sobre el carrito */
	@Autowired
	CartService cartService;

	/* El servicio para manejar las operaciones sobre los platillos */
	@Autowired
	FoodService foodService;

	/* Referencia al carrito actual */
	Cart carrito;

	/* Identificador del usuario actual (Solo de prueba por el momento) */
	String user ="m@ciencias.unam.mx";


	/**
	* Solicitud para ver el carrito.
	* Obtiene el carrito de la base de datos, lo referencia
	* a la variable 'carrito' y carga sus platillos.
	* en la vista VerCarritoIH.html.
	**/
	@RequestMapping( value = "/ver", method = RequestMethod.GET )
	public ModelAndView verCarrito() {
		ModelAndView modelAndView = new ModelAndView("VerCarritoIH");
		check();
		ArrayList<Food> platillos = new ArrayList<Food>(carrito.getPlatillos());
		modelAndView.addObject("carrito", platillos);
		return modelAndView;
	}


	/**
	* Solicitud para editar el carrito.
	* Carga los platillos del carrito en la vista EliminarCarritoIH
	*/
	@RequestMapping( value = "/editar", method = RequestMethod.GET)
	public ModelAndView editarCarrito() {
		ModelAndView modelAndView = new ModelAndView("EliminarCarritoIH");
		ArrayList<Food> platillos = new ArrayList<Food>(carrito.getPlatillos());
		modelAndView.addObject("carrito", platillos);
		return modelAndView;
	}

	/**
	* Solicitud para descartar un platillo.
	* Elimina el platillo del carrito.
	* @param nombre el nombre del platillo a descartar
	*/
	@RequestMapping( value = "/editar/{nombre}")
	public String descartar(@PathVariable("nombre") String nombre) {
		carrito.eliminar(nombre);
		return "redirect:/carrito/editar";
	}

	/**
	* Solicitud para eliminar los platillos descartados del carrito.
	* Actualiza en la base de datos el carrito actual.
	*/
	@RequestMapping( value = "/eliminar")
	public String eliminar() {
		try {
			cartService.actualizar(carrito);
		} catch ( Exception e) {
			/* Llamada a la pagina de error del sistema */
			return "redirect:/error";
		}
		return "redirect:/carrito/ver";
	}

	/**
	* Solicitud para agregar un platillo al carrito.
	* Obten el platillo de la base de datos, guarda en el carrito
	* y actualiza el carrito en la base de datos.
	* Finalmente deririge a la vista del menu
	* @param f el id del platillo a agregar
	*/
	@RequestMapping( value = "/agregar/{id_platillo}")
	public String agregar(@PathVariable("id_platillo") int id_platillo) {
		Food p = foodService.obtenerPlatilloPorId(id_platillo);
		check();
		carrito.agregar(p);
		// Puede que ya se haya agregado el platillo
		try {
			carrito = cartService.actualizar(carrito);
		} catch ( Exception e) { }
		// Simplemente mostramos el carrito sin cambios
		return "redirect:/carrito/ver";
	}

	/**
	* Revisa si el carrito del usuario actual existe
	* en la base de datos (porque puede que apenas se registro)
	* y asigna a la variable carrito el valor
	* de la base de datos
	*/
	private void check () {
		// Revisa si el carrito se encuentra en la base de datos
		carrito = cartService.obtenerCarritoCorreo(user);
		// El usuario apenas se registro
		if (carrito == null) {
			// Le asignamos un id
			ArrayList<Cart> c = (ArrayList<Cart>) cartService.obtenerCarritos();
			int id = (c.size() == 0) ? 1 : c.size() + 1;
			carrito = new Cart (new CartID (id, user));
			carrito = cartService.guardar(carrito);
		}
	}

}
