package com.xantrix.webapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xantrix.webapp.entities.FamAssort;
import com.xantrix.webapp.repository.FamAssortRepository;

@Service
public class FamAssortService {
	
	@Autowired
	private FamAssortRepository repository;
	
	
	public List<FamAssort> famAssortListaService(){
		return repository.getAll();
	}
	
	public FamAssort famAssortDetailsService(String id) {
		return repository.getById(id);
	}
}
