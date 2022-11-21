package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProductosDAO;
import com.example.demo.dto.Productos;

@Service
public class ProductosServiceImpl implements IProductosService {

	@Autowired
	IProductosDAO iProductosDAO;
	
	
	@Override
	public List<Productos> listarProductos() {
		// TODO Auto-generated method stub
		return iProductosDAO.findAll();
	}

	@Override
	public Productos guardarProducto(Productos producto) {
		// TODO Auto-generated method stub
		return iProductosDAO.save(producto);
	}

	@Override
	public Productos producto_x_id(Long id) {
		// TODO Auto-generated method stub
		return iProductosDAO.findById(id).get();
	}

	@Override
	public Productos actualizarProducto(Productos producto) {
		// TODO Auto-generated method stub
		return iProductosDAO.save(producto);
	}

	@Override
	public void eliminarProducto(Long id) {
		// TODO Auto-generated method stub
		iProductosDAO.deleteById(id);
		
	}

}