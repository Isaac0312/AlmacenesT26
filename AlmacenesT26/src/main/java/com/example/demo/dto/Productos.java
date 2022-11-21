package com.example.demo.dto;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Productos {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long  codigo;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "precio")
	private int precio;
	
	@OneToMany
	@JoinColumn(name="codigo")
	private List<Venta> venta;

	
	public Productos() {
		
	}
	
	public Productos(String nombre, int precio, List<Venta> venta) {
		this.nombre=nombre;
		this.precio=precio;
		this.venta=venta;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public List<Venta> getVenta() {
		return venta;
	}

	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}

	@Override
	public String toString() {
		return "Productos [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", venta=" + venta + "]";
	}


	
}
