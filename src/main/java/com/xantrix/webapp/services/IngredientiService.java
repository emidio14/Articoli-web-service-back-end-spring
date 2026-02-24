package com.xantrix.webapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xantrix.webapp.dtos.IngredientiDto;
import com.xantrix.webapp.entities.Ingredienti;
import com.xantrix.webapp.repository.IngredientiRepository;

@Service
public class IngredientiService {
	
	@Autowired
	private IngredientiRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<IngredientiDto> ingredientiListaService(){
		List<Ingredienti> listIngredientiEntity = repository.getAll();
		List<IngredientiDto> listIngredientiDto = new ArrayList<IngredientiDto>();
		
		List<IngredientiDto> mapping = listIngredientiEntity
				.stream()
				.map(element -> modelMapper.map(element, IngredientiDto.class))
				.collect(Collectors.toList());
		listIngredientiDto.addAll(mapping);
		
		return listIngredientiDto;
	}
	
	public IngredientiDto ingredientiDetailsService(String id) {
		Ingredienti ing = repository.getById(id);
		
		if(ing != null) {
			IngredientiDto ingDto = modelMapper.map(ing, IngredientiDto.class);
			return ingDto;
		}
		
		return null;
	}
}
