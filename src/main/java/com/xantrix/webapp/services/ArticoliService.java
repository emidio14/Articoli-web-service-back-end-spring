package com.xantrix.webapp.services;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xantrix.webapp.entities.Articoli;

@Service
public class ArticoliService {
	
	
	List<Articoli> articoli = new ArrayList<Articoli>() {{
		add(new Articoli());
		add(new Articoli());
	}};
	
	public List<Articoli> getAllArticoli(){
		return articoli;
	}
	
	public Articoli getArticoliById(int id) {
		return articoli
				.stream()
				.filter(x -> x.getCodArt() == id)
				.findFirst()
				.orElse(null);
	}
	
	public Articoli addArticoli(Articoli art) {
		art.setCodArt(articoli.size() + 1);
		articoli.add(art);
		return art;
	}
}

