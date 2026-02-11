package com.xantrix.webapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity artDetailsService(@PathVariable String id) {
		Articoli art = service.artDetailsService(id);
		
		if(art == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok().build();
	}
	
	@PostMapping
	public ResponseEntity artInsert(@RequestBody Articoli art) {
		
		boolean insertResult = service.artInsertService(art);
		
		if(insertResult)
			return ResponseEntity.ok().build();
		else
			return ResponseEntity.unprocessableEntity().build();
	}
	
	@DeleteMapping
	public ResponseEntity artDelete(@PathVariable String id) {
		
		if(service.artDeleteService(id))
			return ResponseEntity.ok().build();
		
		return ResponseEntity.notFound().build();
		
	}
	
}
