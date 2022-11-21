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
@Table(name="maquinas")
public class Maquinas {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long  codigo;
	
	@Column(name = "piso")
	private int piso;
	
	
	@OneToMany
	@JoinColumn(name="codigo")
	private List<Venta> venta;

	
	public Maquinas() {
		
	}
	
	public Maquinas(int piso, List<Venta> venta) {
		this.piso=piso;
		this.venta=venta;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public List<Venta> getVenta() {
		return venta;
	}

	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}

	@Override
	public String toString() {
		return "Maquinas [codigo=" + codigo + ", piso=" + piso + ", venta=" + venta + "]";
	}

	
	
}