package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Productos;

public interface IProductosService {
	public List<Productos> listarProductos();
	
	public Productos guardarProducto(Productos producto);
	
	public Productos producto_x_id(Long codigo);
	
	public Productos actualizarProducto(Productos producto);
	
	public void eliminarProducto(Long codigo);
}
