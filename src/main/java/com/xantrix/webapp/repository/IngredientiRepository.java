package com.xantrix.webapp.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xantrix.webapp.entities.Articoli;
import com.xantrix.webapp.entities.Ingredienti;

@Repository
public class IngredientiRepository implements IRepository<Ingredienti>{

	@Override
	public Articoli getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Articoli> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Insert(Articoli obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Articoli obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
