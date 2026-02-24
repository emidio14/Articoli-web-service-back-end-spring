package com.xantrix.webapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xantrix.webapp.dtos.FamAssortDto;
import com.xantrix.webapp.entities.FamAssort;
import com.xantrix.webapp.services.FamAssortService;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("api/famAss/")
@CrossOrigin("http://localhost:8080/")
public class FamAssortController {

	@Autowired
	private FamAssortService service;

	public FamAssortController(FamAssortService service) {
		this.service = service;
	}

	@GetMapping
	public List<FamAssortDto> famAssortListaService() {
		return service.famAssortListaService();
	}

	@GetMapping("{id}")
	public ResponseEntity famAssortListaService(@PathVariable String id) {
		FamAssortDto famAss = service.famAssortDetailsService(id);

		if (famAss == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(famAss);
	}
}
