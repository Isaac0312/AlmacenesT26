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
import com.example.demo.dto.Cajeros;
import com.example.demo.service.CajerosServiceImpl;

@RestController
@RequestMapping("/api")
public class CajerosController {
	
	@Autowired
	CajerosServiceImpl cajerosServiceImpl;
	
	@GetMapping("/cajeros")
	public List<Cajeros> listarCajeros(){
		return cajerosServiceImpl.listarCajeros();
	}
	
	@PostMapping("/cajeros")
	public Cajeros salvarCajero(@RequestBody Cajeros cajero) {
		
		return cajerosServiceImpl.guardarCajero(cajero);
	}
	
	@GetMapping("/cajeros/{codigo}")
	public Cajeros cajero_x_ID(@PathVariable(name="codigo") Long codigo) {
		
		Cajeros cajero_x_id= new Cajeros();
		
		cajero_x_id=cajerosServiceImpl.cajero_x_id(codigo);
		
		System.out.println("Cajero XID: "+cajero_x_id);
		
		return cajero_x_id;
	}
	
	@PutMapping("/cajeros/{codigo}")
	public Cajeros actualizarCajero(@PathVariable(name="codigo")Long codigo,@RequestBody Cajeros cajero) {
		
		Cajeros cajeros_seleccionado= new Cajeros();
		Cajeros cajeros_actualizado= new Cajeros();
		
		cajeros_seleccionado= cajerosServiceImpl.cajero_x_id(codigo);
		
		cajeros_seleccionado.setNomapels(cajero.getNomapels());
		
		cajeros_actualizado = cajerosServiceImpl.actualizarCajero(cajeros_seleccionado);
		
		System.out.println("El cajero actualizado es: "+ cajeros_actualizado);
		
		return cajeros_actualizado;
	}
	
	@DeleteMapping("/cajeros/{codigo}")
	public void eliminarCajero(@PathVariable(name="codigo")Long codigo) {
		cajerosServiceImpl.eliminarCajero(codigo);
	}
	
	
}
