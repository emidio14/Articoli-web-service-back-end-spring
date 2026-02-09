package com.xantrix.webapp.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xantrix.webapp.entities.Articoli;
import com.xantrix.webapp.entities.Ingredienti;

@Repository
public class IngredientiRepository implements IRepositoryReadOnly<Ingredienti>{

	@Override
	public List<Ingredienti> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Articoli getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ingredienti getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
