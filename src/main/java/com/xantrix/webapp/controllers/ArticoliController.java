package com.xantrix.webapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xantrix.webapp.dtos.ArticoliDto;
import com.xantrix.webapp.entities.Articoli;
import com.xantrix.webapp.services.ArticoliService;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("api/articoli/")
@CrossOrigin("http://localhost:4200/")
public class ArticoliController {
	
	@Autowired
	private ArticoliService service;
	
	public ArticoliController(ArticoliService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<ArticoliDto> articoliListaService(){
		return service.articoliListaService();
	}
	
	@GetMapping("{id}")
	public ResponseEntity artDetailsService(@PathVariable String id) {
		ArticoliDto art = service.artDetailsService(id);
		
		if(art == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(art);
	}
	
	@PostMapping
	public ResponseEntity artInsert(@RequestBody Articoli art) {
		
		boolean insertResult = service.artInsertService(art) != null;
		
		if(insertResult)
			return ResponseEntity.ok().build();

		return ResponseEntity.unprocessableEntity().build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity artDelete(@PathVariable String id) {
		
		
		ArticoliDto deleteResult = service.artDeleteService(id);
		
		if(deleteResult != null)
			return ResponseEntity.ok().build();
		System.out.println(deleteResult);
		return ResponseEntity.notFound().build();
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity artUpdate(@PathVariable String id, @RequestBody ArticoliDto art) {
		
		if(!id.equals("0"))
			art.setCodArt(id);
		ArticoliDto artDto = service.artUpdateService(art);

			if(artDto != null)
				return ResponseEntity.ok().build();
			
		return ResponseEntity.badRequest().build();
		
	}	
	
}
