package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.Productos;
import com.example.demo.service.ProductosServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductosController {
	
	@Autowired
	ProductosServiceImpl productosServiceImpl;
	
	@GetMapping("/productos")
	public List<Productos> listarProductos(){
		return productosServiceImpl.listarProductos();
	}
	
	@PostMapping("/productos")
	public Productos salvarProducto(@RequestBody Productos producto) {
		
		return productosServiceImpl.guardarProducto(producto);
	}
	
	@GetMapping("/producto/{codigo}")
	public Productos producto_x_ID(@PathVariable(name="codigo") Long codigo) {
		
		Productos producto_x_id= new Productos();
		
		producto_x_id=productosServiceImpl.producto_x_id(codigo);
		
		System.out.println("Producto XID: "+producto_x_id);
		
		return producto_x_id;
	}
	
	@PutMapping("/producto/{codigo}")
	public Productos actualizarProducto(@PathVariable(name="codigo")Long codigo,@RequestBody Productos producto) {
		
		Productos producto_seleccionado= new Productos();
		Productos producto_actualizado= new Productos();
		
		producto_seleccionado= productosServiceImpl.producto_x_id(codigo);
		
		producto_seleccionado.setNombre(producto.getNombre());
		producto_seleccionado.setPrecio(producto.getPrecio());
		
		producto_actualizado = productosServiceImpl.actualizarProducto(producto_seleccionado);
		
		System.out.println("El producto actualizado es: "+ producto_actualizado);
		
		return producto_actualizado;
	}
	
	@DeleteMapping("/producto/{codigo}")
	public void eliminarProducto(@PathVariable(name="codigo")Long codigo) {
		productosServiceImpl.eliminarProducto(codigo);
	}
	
	
}