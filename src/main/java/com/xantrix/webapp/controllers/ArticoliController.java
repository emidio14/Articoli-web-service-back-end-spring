package com.xantrix.webapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xantrix.webapp.entities.Articoli;
import com.xantrix.webapp.services.ArticoliService;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("api/articoli/")
@CrossOrigin("http://localhost:8080/")
public class ArticoliController {
	
	@Autowired
	private ArticoliService service;
	
	public ArticoliController(ArticoliService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Articoli> articoliListaService(){
		return service.articoliListaService();
	}
	@GetMapping("{id}")
	public Articoli artDetailsService(@PathVariable String id) {
		return service.artDetailsService(id);
	}
	
}
