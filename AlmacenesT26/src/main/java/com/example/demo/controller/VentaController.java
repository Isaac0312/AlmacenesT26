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
import com.example.demo.dto.Venta;
import com.example.demo.service.VentaServiceImpl;

@RestController
@RequestMapping("/api")
public class VentaController {
	
	@Autowired
	VentaServiceImpl ventaServiceImpl;
	
	@GetMapping("/venta")
	public List<Venta> listarVentas(){
		return ventaServiceImpl.listarVentas();
	}
	
	@PostMapping("/venta")
	public Venta salvarVenta(@RequestBody Venta venta) {
		
		return ventaServiceImpl.guardarVenta(venta);
	}
	
	@GetMapping("/venta/{codigo}")
	public Venta venta_x_ID(@PathVariable(name="codigo") Long codigo) {
		
		Venta venta_x_id= new Venta();
		
		venta_x_id=ventaServiceImpl.venta_x_id(codigo);
		
		System.out.println("Cajero XID: "+venta_x_id);
		
		return venta_x_id;
	}
	
	@PutMapping("/venta/{codigo}")
	public Venta actualizarVenta(@PathVariable(name="codigo")Long codigo,@RequestBody Venta venta) {
		
		Venta venta_seleccionado= new Venta();
		Venta venta_actualizado= new Venta();
		
		venta_seleccionado= ventaServiceImpl.venta_x_id(codigo);
		
		venta_seleccionado.setCajero(venta.getCajero());
		venta_seleccionado.setMaquina(venta.getMaquina());
		venta_seleccionado.setProducto(venta.getProducto());
		
		venta_actualizado = ventaServiceImpl.actualizarVenta(venta_seleccionado);
		
		System.out.println("La venta actualizada es: "+ venta_actualizado);
		
		return venta_actualizado;
	}
	
	@DeleteMapping("/venta/{codigo}")
	public void eliminarVenta(@PathVariable(name="codigo")Long codigo) {
		ventaServiceImpl.eliminarVenta(codigo);
	}
	
	
}