package com.perso.footcelad.core.model.dao;
/**
 * Generic interface to manage CRUD
 * @author ktf01464
 *
 */
public interface IFootDAO {

	Long create(Object o);
	Object getById(Long id, Class<?> theClass);
	void update(Object o);
	void delete(Object o);
	
}
