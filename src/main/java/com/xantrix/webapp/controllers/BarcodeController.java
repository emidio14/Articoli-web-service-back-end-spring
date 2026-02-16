package com.xantrix.webapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xantrix.webapp.entities.Barcode;
import com.xantrix.webapp.services.BarcodeService;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("api/barcode/")
@CrossOrigin("http://localhost:8080/")
public class BarcodeController {
	
	@Autowired
	private BarcodeService service;
	
	public BarcodeController(BarcodeService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Barcode> barcodeListaService(){
		return service.barcodeListaService();
	}
	

}
