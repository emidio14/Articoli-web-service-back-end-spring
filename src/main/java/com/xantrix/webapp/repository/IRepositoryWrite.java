package com.xantrix.webapp.repository;

public interface IRepositoryWrite<T> {
	 
	boolean Insert(T obj);
	boolean Update(T obj);
	boolean Delete(int id);

}
