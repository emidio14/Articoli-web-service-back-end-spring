package com.xantrix.webapp.dtos;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FamAssortDto 
{
	private String id;
	private String descrizione;
	private Set<ArticoliDto> articoli = new HashSet<>();
}
