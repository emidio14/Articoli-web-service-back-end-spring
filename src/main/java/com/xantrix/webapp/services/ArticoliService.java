package com.xantrix.webapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xantrix.webapp.entities.Articoli;
import com.xantrix.webapp.repository.ArticoliRepository;

@Service
public class ArticoliService {
	
	@Autowired
	private ArticoliRepository repository;
	
	
	public List<Articoli> articoliListaService(){
		return repository.getAll();
	}
	
	public Articoli artDetailsService(String id) {
		return repository.getById(id);
	}
	
	public boolean artUpdateService(String id) {
		return repository.Update(id);
	}
	
	public boolean artDeleteService(String id) {
		return repository.Delete(id);
	}
}

