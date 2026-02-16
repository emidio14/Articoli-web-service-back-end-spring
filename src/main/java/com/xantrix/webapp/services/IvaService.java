package com.xantrix.webapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xantrix.webapp.entities.Iva;
import com.xantrix.webapp.repository.IvaRepository;

@Service
public class IvaService {
	
	@Autowired
	private IvaRepository repository;
	
	
	public List<Iva> ivaListaService(){
		return repository.getAll();
	}
	
	public Iva ivaDetailsService(String id) {
		return repository.getById(id);
	}
}
