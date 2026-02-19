package com.xantrix.webapp;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xantrix.webapp.dtos.ArticoliDto;
import com.xantrix.webapp.dtos.BarcodeDto;
import com.xantrix.webapp.dtos.FamAssortDto;
import com.xantrix.webapp.dtos.IngredientiDto;
import com.xantrix.webapp.dtos.IvaDto;
import com.xantrix.webapp.entities.Articoli;
import com.xantrix.webapp.entities.Barcode;
import com.xantrix.webapp.entities.FamAssort;
import com.xantrix.webapp.entities.Ingredienti;
import com.xantrix.webapp.entities.Iva;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		
		modelMapper.getConfiguration()
			.setMatchingStrategy(MatchingStrategies.LOOSE)
			.setSkipNullEnabled(true);
		
		modelMapper.createTypeMap(Articoli.class, ArticoliDto.class)
			.addMappings( mapper -> {
				mapper.map(src -> src.getBarcode().getBarcode(), ArticoliDto::setBarcode);
			});
		modelMapper.createTypeMap(Barcode.class, BarcodeDto.class);
		modelMapper.createTypeMap(FamAssort.class, FamAssortDto.class);
		modelMapper.createTypeMap(Ingredienti.class, IngredientiDto.class);
		modelMapper.createTypeMap(Iva.class, IvaDto.class);
		
		return modelMapper;

	}
	
}
