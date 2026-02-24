package com.xantrix.webapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xantrix.webapp.dtos.IvaDto;
import com.xantrix.webapp.services.IvaService;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("api/iva/")
@CrossOrigin("http://localhost:8080/")
public class IvaController {

	@Autowired
	private IvaService service;

	public IvaController(IvaService service) {
		this.service = service;
	}

	@GetMapping
	public List<IvaDto> ivaListaService() {
		return service.ivaListaService();
	}

	@GetMapping("{id}")
	public ResponseEntity ivaListaService(@PathVariable String id) {
		IvaDto iva = service.ivaDetailsService(id);

		if (iva == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(iva);
	}
}
