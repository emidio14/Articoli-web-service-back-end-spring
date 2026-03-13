package com.xantrix.webapp.dtos;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
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
	private String barcode;
	private IngredientiDto ingredienti;
	private IvaDto iva;
	private FamAssortDto famAssort;
	
}
