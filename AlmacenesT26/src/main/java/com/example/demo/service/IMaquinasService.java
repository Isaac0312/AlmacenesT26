package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Maquinas;

public interface IMaquinasService {
	public List<Maquinas> listarMaquinas();
	
	public Maquinas guardarMaquina(Maquinas maquina);
	
	public Maquinas maquina_x_id(Long codigo);
	
	public Maquinas actualizarMaquina(Maquinas maquina);
	
	public void eliminarMaquinas(Long codigo);
}