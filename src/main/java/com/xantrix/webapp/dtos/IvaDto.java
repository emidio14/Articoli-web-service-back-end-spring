package com.xantrix.webapp.dtos;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IvaDto
{
	private String idIva;
	private String descrizione;
	private String aliquota;
	private Set<ArticoliDto> articoli = new HashSet<>();
}
