package com.xantrix.webapp.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xantrix.webapp.dtos.ArticoliDto;
import com.xantrix.webapp.exceptions.NotFoundException;
import com.xantrix.webapp.services.ArticoliService;

import lombok.SneakyThrows;
import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("api/articoli")
@CrossOrigin("http://localhost:4200/")
public class ArticoliController 
{
	private ArticoliService articoliService;
	
	public ArticoliController(ArticoliService articoliService)
	{
		this.articoliService = articoliService;
	}
	
	@SneakyThrows
	@GetMapping(value = "/cerca/barcode/{ean}", produces = "application/json")
	public ResponseEntity<ArticoliDto> listArtByEan(@PathVariable("ean") String Ean) 
	{
		ArticoliDto articolo = articoliService.SelByBarcode(Ean);
		
		if (articolo == null)
		{
			String ErrMsg = String.format("Il barcode %s non e' stato trovato!", Ean);
			
			log.warning(ErrMsg);
			
			throw new NotFoundException(ErrMsg);
		}
		
		return new ResponseEntity<ArticoliDto>(articolo, HttpStatus.OK);
	}
	
	@SneakyThrows
	@GetMapping(value = "/cerca/codice/{codart}", produces = "application/json")
	public ResponseEntity<ArticoliDto> listArtByCodArt(@PathVariable("codart") String CodArt)
	{
		log.info("****** Otteniamo l'articolo con codice " + CodArt + " *******");
		
		ArticoliDto articolo = articoliService.SelByCodArt(CodArt);
		
		if (articolo == null)
		{
			String ErrMsg = String.format("L'articolo con codice %s non e' stato trovato!", CodArt);
			
			log.warning(ErrMsg);
			
			throw new NotFoundException(ErrMsg);
		}
		
		return new ResponseEntity<ArticoliDto>(articolo, HttpStatus.OK);
	}
	
	@SneakyThrows
	@GetMapping(value = "/cerca/descrizione/{filter}", produces = "application/json")
	public ResponseEntity<List<ArticoliDto>> listArtByDesc(@PathVariable("filter") String Filter)
	{
		log.info("****** Otteniamo gli articoli con Descrizione: " + Filter + " *******");
		
		List<ArticoliDto> articoli = articoliService.SelByDescrizione(Filter);
		
		if (articoli.isEmpty())
		{
			String ErrMsg = String.format("Non e' stato trovato alcun articolo avente descrizione %s", Filter);
			
			log.warning(ErrMsg);
			
			throw new NotFoundException(ErrMsg);
			
		}
		
		return new ResponseEntity<List<ArticoliDto>>(articoli, HttpStatus.OK);
		
	}
		
}
