package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IMaquinasDAO;
import com.example.demo.dto.Maquinas;

@Service
public class MaquinasServiceImpl implements IMaquinasService {

	@Autowired
	IMaquinasDAO iMaquinasDAO;
	
	
	@Override
	public List<Maquinas> listarMaquinas() {
		// TODO Auto-generated method stub
		return iMaquinasDAO.findAll();
	}

	@Override
	public Maquinas guardarMaquina(Maquinas maquina) {
		// TODO Auto-generated method stub
		return iMaquinasDAO.save(maquina);
	}

	@Override
	public Maquinas maquina_x_id(Long id) {
		// TODO Auto-generated method stub
		return iMaquinasDAO.findById(id).get();
	}

	@Override
	public Maquinas actualizarMaquina(Maquinas maquina) {
		// TODO Auto-generated method stub
		return iMaquinasDAO.save(maquina);
	}

	@Override
	public void eliminarMaquinas(Long id) {
		// TODO Auto-generated method stub
		iMaquinasDAO.deleteById(id);
		
	}

}