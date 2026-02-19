package com.xantrix.webapp.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class IvaDto
{
	private String idIva;
	private String descrizione;
	private String aliquota;
}
