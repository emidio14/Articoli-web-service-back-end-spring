package com.xantrix.webapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xantrix.webapp.dtos.BarcodeDto;
import com.xantrix.webapp.entities.Barcode;
import com.xantrix.webapp.repository.BarcodeRepository;

@Service
public class BarcodeService {

	@Autowired
	private BarcodeRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;

	public List<BarcodeDto> barcodeListaService() {
		
		List<Barcode> listBarcodeEntity = repository.getAll();
		List<BarcodeDto> listBarcodeDto = new ArrayList<BarcodeDto>();
		
		List<BarcodeDto> mapping = listBarcodeEntity
				.stream()
				.map(element -> modelMapper.map(element, BarcodeDto.class))
				.collect(Collectors.toList());
		listBarcodeDto.addAll(mapping);
		
		return listBarcodeDto;
	}

	public BarcodeDto barDetailsService(String id) {
		
		Barcode bar = repository.getById(id);
		
		if(bar != null) {
			BarcodeDto barDto = modelMapper.map(bar, BarcodeDto.class);
			
			return barDto;
		}
		
		return null;
	}
}
