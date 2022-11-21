package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cajeros")
public class Cajeros {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long  codigo;
	
	@Column(name = "nomapels")
	private String nomapels;
	
	
	@OneToMany
	@JoinColumn(name="codigo")
	private List<Venta> venta;

	
	public Cajeros() {
		
	}
	
	public Cajeros(String nombre, List<Venta> venta) {
		this.nomapels=nombre;
		this.venta=venta;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNomapels() {
		return nomapels;
	}

	public void setNomapels(String nomapels) {
		this.nomapels = nomapels;
	}

	public List<Venta> getVenta() {
		return venta;
	}

	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}

	@Override
	public String toString() {
		return "Cajeros [codigo=" + codigo + ", nomapels=" + nomapels + ", venta=" + venta + "]";
	}
	
}
