package com.xantrix.webapp.repository;

import java.util.List;

public interface IRepository<T> {
	
	T getById(int id);
	List<T> getAll();
	
	boolean Insert(T obj);
	boolean Update(T obj);
	boolean Delete(int id);

}
