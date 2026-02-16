package com.xantrix.webapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xantrix.webapp.entities.Ingredienti;
import com.xantrix.webapp.services.IngredientiService;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("api/ingredienti/")
@CrossOrigin("http://localhost:8080/")
public class IngredientiController {

	@Autowired
	private IngredientiService service;

	public IngredientiController(IngredientiService service) {
		this.service = service;
	}

	@GetMapping
	public List<Ingredienti> ingredientiListaService() {
		return service.ingredientiListaService();
	}

	@GetMapping("{id}")
	public ResponseEntity ivaListaService(@PathVariable String id) {
		Ingredienti ingrediente = service.ingredientiDetailsService(id);

		if (ingrediente == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(ingrediente);
	}
}
