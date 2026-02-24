package com.xantrix.webapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xantrix.webapp.dtos.IvaDto;
import com.xantrix.webapp.entities.Iva;
import com.xantrix.webapp.repository.IvaRepository;

@Service
public class IvaService {

	@Autowired
	private IvaRepository repository;

	@Autowired
	private ModelMapper modelMapper;

	public List<IvaDto> ivaListaService() {
		List<Iva> listIvaEntity = repository.getAll();
		List<IvaDto> listIvaDto = new ArrayList<IvaDto>();

		List<IvaDto> mapping = listIvaEntity.stream().map(element -> modelMapper.map(element, IvaDto.class))
				.collect(Collectors.toList());
		listIvaDto.addAll(mapping);

		return listIvaDto;
	}

	public IvaDto ivaDetailsService(String id) {
		Iva iva = repository.getById(id);

		if (iva != null) {
			IvaDto ivaDto = modelMapper.map(iva, IvaDto.class);

			return ivaDto;
		}

		return null;
	}
}
