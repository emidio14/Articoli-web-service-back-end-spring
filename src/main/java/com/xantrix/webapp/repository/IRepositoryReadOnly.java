package com.xantrix.webapp.repository;

import java.util.List;

import com.xantrix.webapp.entities.Articoli;

public interface IRepositoryReadOnly<T> {
	//Lettura - Corrispondenti a Query Language
	
	T getById(int id);
	List<T> getAll();
	Articoli getById(String id);

}
