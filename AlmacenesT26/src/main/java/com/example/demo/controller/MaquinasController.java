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
import com.example.demo.dto.Maquinas;
import com.example.demo.service.MaquinasServiceImpl;

@RestController
@RequestMapping("/api")
public class MaquinasController {
	
	@Autowired
	MaquinasServiceImpl maquinasServiceImpl;
	
	@GetMapping("/maquinas")
	public List<Maquinas> listarMaquinas(){
		return maquinasServiceImpl.listarMaquinas();
	}
	
	@PostMapping("/maquinas")
	public Maquinas salvarMaquina(@RequestBody Maquinas maquina) {
		
		return maquinasServiceImpl.guardarMaquina(maquina);
	}
	
	@GetMapping("/maquinas/{codigo}")
	public Maquinas maquina_x_ID(@PathVariable(name="codigo") Long codigo) {
		
		Maquinas maquina_x_id= new Maquinas();
		
		maquina_x_id=maquinasServiceImpl.maquina_x_id(codigo);
		
		System.out.println("Maquina XID: "+maquina_x_id);
		
		return maquina_x_id;
	}
	
	@PutMapping("/maquinas/{codigo}")
	public Maquinas actualizarMaquina(@PathVariable(name="codigo")Long codigo,@RequestBody Maquinas maquina) {
		
		Maquinas maquinas_seleccionado= new Maquinas();
		Maquinas maquina_actualizado= new Maquinas();
		
		maquinas_seleccionado= maquinasServiceImpl.maquina_x_id(codigo);
		
		maquinas_seleccionado.setPiso(maquina.getPiso());
		
		maquina_actualizado = maquinasServiceImpl.actualizarMaquina(maquinas_seleccionado);
		
		System.out.println("La maquina actualizada es: "+ maquina_actualizado);
		
		return maquina_actualizado;
	}
	
	@DeleteMapping("/maquinas/{codigo}")
	public void eliminarMaquina(@PathVariable(name="codigo")Long codigo) {
		maquinasServiceImpl.eliminarMaquinas(codigo);
	}
	
	
}
