package com.naat.nix.menu.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Carrito")
public class Cart {

	@EmbeddedId
	private CartID cartId;

	@ManyToMany
	@JoinTable(
		name="Agregar",
		joinColumns={@JoinColumn(name="correo"),
								 @JoinColumn(name="id_carrito")},
		inverseJoinColumns=@JoinColumn(name="id_platillo")
	)
	private List<Food> platillos;

	public Cart(){		
	}

	public Cart (CartID cartId) {
	  	this.cartId = cartId;
	  	this.platillos = new ArrayList<Food>();
  }

  	public void agregar(Food p) {
	  	this.platillos.add(p);
  	}

	public void eliminar(Food p){
	    this.platillos.remove(p);
	}

	public Food eliminar(String p) {
		for (int i = 0; i < this.platillos.size(); i++) {
			Food foo = this.platillos.get(i);
			String nombre = foo.getNombre();
			if (nombre.equals(p)) {
				return platillos.remove(i);
			}
		}
		return null;
	}

	public void limpiar() {
		this.platillos.clear();
	}

	public Food getFood(String nombre) {
		for (int i = 0; i < platillos.size(); i++) {
			Food f = platillos.get(i);
			if (f.getNombre().equals(nombre)) {
				return f;
			}
		}
		return null;
	}

}
