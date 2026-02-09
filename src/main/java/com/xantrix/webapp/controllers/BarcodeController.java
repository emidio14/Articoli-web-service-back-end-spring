package com.xantrix.webapp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xantrix.webapp.entities.Barcode;
import com.xantrix.webapp.services.BarcodeService;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping
@CrossOrigin("http//:localhost:8080/")
public class BarcodeController {
	
	@GetMapping
	public List<Barcode> getAllBarcode(BarcodeService service){
		return service.getAllBarcode();
	}
	

}
