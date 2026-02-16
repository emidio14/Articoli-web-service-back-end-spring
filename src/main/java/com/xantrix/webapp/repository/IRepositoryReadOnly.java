package com.xantrix.webapp.repository;

import java.util.List;

public interface IRepositoryReadOnly<T> {
	
	List<T> getAll();
	T getById(String id);

}
