package com.xantrix.webapp.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IngredientiDto 
{
	private String codArt;
	private String info;
	private ArticoliDto articolo;
}
