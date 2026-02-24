package com.xantrix.webapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xantrix.webapp.dtos.BarcodeDto;
import com.xantrix.webapp.entities.Barcode;
import com.xantrix.webapp.repository.BarcodeRepository;

@Service
public class BarcodeService {

	@Autowired
	private BarcodeRepository repository;

	public List<BarcodeDto> barcodeListaService() {
		return repository.getAll();
	}

	public Barcode barDetailsService(String id) {
		return repository.getById(id);
	}
}
