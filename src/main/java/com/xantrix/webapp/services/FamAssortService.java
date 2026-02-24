package com.xantrix.webapp.services;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xantrix.webapp.dtos.FamAssortDto;
import com.xantrix.webapp.entities.FamAssort;
import com.xantrix.webapp.repository.FamAssortRepository;

@Service
public class FamAssortService {
	
	@Autowired
	private FamAssortRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<FamAssortDto> famAssortListaService(){
		
		List<FamAssort> listFamAssEntity = repository.getAll();
		List<FamAssortDto> listFamAssDto = new ArrayList<FamAssortDto>();
		
		List<FamAssortDto> mapping = listFamAssEntity
				.stream()
				.map(element -> modelMapper.map(element, FamAssortDto.class))
				.collect(Collectors.toList());
		listFamAssDto.addAll(mapping);
		
		
		return listFamAssDto;
	}
	
	public FamAssortDto famAssortDetailsService(String id) {
		
		FamAssort famAss = repository.getById(id);
		
		if(famAss != null) {
			FamAssortDto famAssDto = modelMapper.map(famAss, FamAssortDto.class);
			
			return famAssDto;
		}
		
		return null;
	}
}
