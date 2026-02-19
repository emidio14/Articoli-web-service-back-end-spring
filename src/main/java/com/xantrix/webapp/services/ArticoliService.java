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

		List<ArticoliDto> mapping = listArticoliEntity.stream()
				.map(element -> modelMapper.map(element, ArticoliDto.class)).collect(Collectors.toList());
		listaArticoliDto.addAll(mapping);

		return listaArticoliDto;
	}

	public ArticoliDto artDetailsService(String id) {

		Articoli art = repository.getById(id);
		ArticoliDto artDto = modelMapper.map(art, ArticoliDto.class);

		return artDto;
	}

	public ArticoliDto artUpdateService(ArticoliDto artDto) {
		
		Articoli artEntity = modelMapper.map(artDto, Articoli.class);
		boolean artic = repository.Update(artEntity);
		
		if(artic) {
			ArticoliDto articDto = modelMapper.map(artEntity, ArticoliDto.class);
			System.out.println(articDto);
			
			return articDto;
		}else {
			
			return null;
		}
				
	}

	public boolean artDeleteService(String id) {
		return repository.Delete(id);
	}

	public boolean artInsertService(Articoli art) {
		return repository.Insert(art);
	}
}
