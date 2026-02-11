package com.xantrix.webapp.repository;

import java.util.List;

import com.xantrix.webapp.entities.Articoli;

public interface IRepositoryReadOnly<T> {
	
	List<T> getAll();
	Articoli getById(String id);

}
