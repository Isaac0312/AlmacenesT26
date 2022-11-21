package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICajerosDAO;
import com.example.demo.dto.Cajeros;

@Service
public class CajerosServiceImpl implements ICajerosService {

	@Autowired
	ICajerosDAO iCajerosDAO;
	
	
	@Override
	public List<Cajeros> listarCajeros() {
		// TODO Auto-generated method stub
		return iCajerosDAO.findAll();
	}

	@Override
	public Cajeros guardarCajero(Cajeros cajero) {
		// TODO Auto-generated method stub
		return iCajerosDAO.save(cajero);
	}

	@Override
	public Cajeros cajero_x_id(Long id) {
		// TODO Auto-generated method stub
		return iCajerosDAO.findById(id).get();
	}

	@Override
	public Cajeros actualizarCajero(Cajeros cajero) {
		// TODO Auto-generated method stub
		return iCajerosDAO.save(cajero);
	}

	@Override
	public void eliminarCajero(Long id) {
		// TODO Auto-generated method stub
		iCajerosDAO.deleteById(id);
		
	}

}
