package com.xantrix.webapp.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xantrix.webapp.dtos.ArticoliDto;
import com.xantrix.webapp.entities.Articoli;
import com.xantrix.webapp.repository.ArticoliRepository;

@Service
public class ArticoliServiceImpl implements ArticoliService
{
	
	@Autowired
	private ModelMapper modelMapper;

	//@Autowired
	private ArticoliRepository articoliRepository;
	
	public ArticoliServiceImpl(ArticoliRepository articoliRepository) 
	{
		this.articoliRepository = articoliRepository;
	}
	
	@Override
	public ArticoliDto SelByBarcode(String barcode) 
	{
		return ConvertToDto(articoliRepository.selByEan(barcode));
	}

	@Override
	public ArticoliDto SelByCodArt(String codart) 
	{
		return ConvertToDto(articoliRepository.findByCodArt(codart));
	}

	@Override
	public List<ArticoliDto> SelByDescrizione(String descrizione) 
	{
		String filter = "%" + descrizione.toUpperCase() + "%";
		
		return ConvertToDto(articoliRepository.selByDescrizioneLike(filter));
	}
	
	private ArticoliDto ConvertToDto(Articoli articoli)
	{
		ArticoliDto articoliDto = null;
		
		if (articoli != null)
		{
			articoliDto =  modelMapper.map(articoli, ArticoliDto.class);
		}
		
		return articoliDto;
	}
	
	private List<ArticoliDto> ConvertToDto(List<Articoli> articoli)
	{
		List<ArticoliDto> retVal = articoli
		        .stream()
		        .map(source -> modelMapper.map(source, ArticoliDto.class))
		        .collect(Collectors.toList());
		
		return retVal;
	}

}
