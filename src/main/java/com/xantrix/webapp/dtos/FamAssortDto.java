package com.xantrix.webapp.dtos;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class FamAssortDto 
{
	private String id;
	private String descrizione;
	private Set<ArticoliDto> articoli = new HashSet<>();
}
