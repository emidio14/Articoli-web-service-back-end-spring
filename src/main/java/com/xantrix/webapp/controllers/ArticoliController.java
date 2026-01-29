package com.xantrix.webapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("api/articoli")
@CrossOrigin("http://localhost:8080/")
public class ArticoliController {
	
	@Autowired
	private ArticoliService service;
	
	public ArticoliController(ArticoliService service) {
		this.service = service;
	}
	
	@GetMapping()
	public List<Articoli> listaArticoli(){
		ArticoliService art = new ArticoliService();
		return art.getAllArticoli();
	}
	
	@GetMapping("{id}")
	public Articoli detailArticoli(@PathVariable int id) {
		ArticoliService art = new ArticoliService();
		return art.getArticoliById(id);
	}
	
	@PostMapping()
	public Articoli articoliInsert(@RequestBody Articoli art) {
		return service.addArticoli(art);
	}
	
}
