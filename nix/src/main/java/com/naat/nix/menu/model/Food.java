package com.naat.nix.menu.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Platillo")
public class Food {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int idPlatillo;

	@Column(name="precio")
	private int precio;

	@Column(name="descripcion")
	private String descripcion;

	@Column(name="foto")
	private String foto;

	@Column(name="nombre")
	private String nombre;

	@ManyToOne
	@JoinColumn(name="categoria")
	private Category categoria;

	@ManyToMany(mappedBy="platillos")
	private List<Cart> carritos;

	public Food(String nombre, String descripcion, String foto, int precio, Category categoria) {
		this.nombre = nombre; this.descripcion = descripcion; this.foto = foto;
		this.precio = precio; this.categoria = categoria;
	}

}
