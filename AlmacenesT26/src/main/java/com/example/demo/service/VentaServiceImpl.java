package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IVentaDAO;
import com.example.demo.dto.Venta;

@Service
public class VentaServiceImpl implements IVentaService {

	@Autowired
	IVentaDAO iVentaDAO;
	
	
	@Override
	public List<Venta> listarVentas() {
		// TODO Auto-generated method stub
		return iVentaDAO.findAll();
	}

	@Override
	public Venta guardarVenta(Venta venta) {
		// TODO Auto-generated method stub
		return iVentaDAO.save(venta);
	}

	@Override
	public Venta venta_x_id(Long id) {
		// TODO Auto-generated method stub
		return iVentaDAO.findById(id).get();
	}

	@Override
	public Venta actualizarVenta(Venta venta) {
		// TODO Auto-generated method stub
		return iVentaDAO.save(venta);
	}

	@Override
	public void eliminarVenta(Long id) {
		// TODO Auto-generated method stub
		iVentaDAO.deleteById(id);
		
	}

}
