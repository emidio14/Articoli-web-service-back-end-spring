package com.xantrix.webapp.dtos;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.xantrix.webapp.entities.Ingredienti;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticoliDto 
{
	private String codArt;
	private String descrizione;	
	private String um;
	private String codStat;
	private int pzCart = 0;
	private double pesoNetto = 0;
	private String idStatoArt;
	private Date dataCreaz;
	private BarcodeDto barcode;
	private Set<IngredientiDto> ingredienti = new HashSet<>();
	private IvaDto iva;
	private CategoriaDto famAssort;
	
}
