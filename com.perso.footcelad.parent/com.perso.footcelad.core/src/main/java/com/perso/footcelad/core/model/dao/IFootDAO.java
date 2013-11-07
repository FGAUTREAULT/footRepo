package com.perso.footcelad.core.model.dao;

/**
 * Generic interface to manage CRUD
 * 
 * @author Fabien Gautreault
 * 
 */
public interface IFootDAO {

	Long create(Object o);

	<T> T getById(Long id, Class<T> theClass);

	void update(Object o);

	void delete(Object o);

}
