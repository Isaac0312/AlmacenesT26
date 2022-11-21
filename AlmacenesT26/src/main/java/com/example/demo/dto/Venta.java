package com.example.demo.dto;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="venta")
public class Venta {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long  codigo;
	
	@ManyToOne
	@JoinColumn(name="codigo_maquina")
	private Maquinas maquina;
	
	@ManyToOne
	@JoinColumn(name="codigo_cajero")
	private Cajeros cajero;
	
	@ManyToOne
	@JoinColumn(name="codigo_producto")
	private Productos producto;

	
	public Venta() {
		
	}
	
	public Venta(Cajeros cajero, Maquinas maquina, Productos producto) {
		this.maquina=maquina;
		this.cajero=cajero;
		this.producto=producto;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public Maquinas getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquinas maquina) {
		this.maquina = maquina;
	}

	public Cajeros getCajero() {
		return cajero;
	}

	public void setCajero(Cajeros cajero) {
		this.cajero = cajero;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Venta [codigo=" + codigo + ", maquina=" + maquina + ", cajero=" + cajero + ", producto=" + producto
				+ "]";
	}
	
}