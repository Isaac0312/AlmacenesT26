package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Venta;

public interface IVentaService {
	public List<Venta> listarVentas();
	
	public Venta guardarVenta(Venta venta);
	
	public Venta venta_x_id(Long codigo);
	
	public Venta actualizarVenta(Venta venta);
	
	public void eliminarVenta(Long codigo);
}