package com.xantrix.webapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xantrix.webapp.dtos.ArticoliDto;
import com.xantrix.webapp.entities.Articoli;
import com.xantrix.webapp.repository.ArticoliRepository;

@Service
public class ArticoliService {

	@Autowired
	private ArticoliRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public List<ArticoliDto> articoliListaService() {
		
			List<Articoli> listArticoliEntity = repository.getAll();
			List<ArticoliDto> listaArticoliDto = new ArrayList<ArticoliDto>();
			
			List<ArticoliDto> mapping = listArticoliEntity
				.stream()
				.map(element -> modelMapper.map(element, ArticoliDto.class))
				.collect(Collectors.toList());
			listaArticoliDto.addAll(mapping);
			
			System.out.println(listaArticoliDto);
		return listaArticoliDto;
	}

	public Articoli artDetailsService(String id) {
		return repository.getById(id);
	}

	public boolean artUpdateService(Articoli art) {
		return repository.Update(art);
	}

	public boolean artDeleteService(String id) {
		return repository.Delete(id);
	}

	public boolean artInsertService(Articoli art) {
		return repository.Insert(art);
	}
}
