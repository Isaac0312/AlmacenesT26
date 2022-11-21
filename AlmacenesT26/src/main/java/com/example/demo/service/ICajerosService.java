package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Cajeros;

public interface ICajerosService {
	public List<Cajeros> listarCajeros();
	
	public Cajeros guardarCajero(Cajeros cajero);
	
	public Cajeros cajero_x_id(Long codigo);
	
	public Cajeros actualizarCajero(Cajeros cajero);
	
	public void eliminarCajero(Long codigo);
}