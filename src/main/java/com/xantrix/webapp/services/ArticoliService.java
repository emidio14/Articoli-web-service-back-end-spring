package com.xantrix.webapp.services;

import java.util.List;

import com.xantrix.webapp.dtos.ArticoliDto;

public interface ArticoliService 
{

    List<ArticoliDto> SelByDescrizione(String filter);
    ArticoliDto SelByBarcode(String Ean);
    ArticoliDto SelByCodArt(String CodArt);
	
}
