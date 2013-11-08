package com.perso.footcelad.core.model.dao;

import java.util.List;

/**
 * Generic interface to manage CRUD
 *
 * @author Fabien Gautreault
 *
 */
public interface IFootDAO {

	/**
	 * Create an Foot object
	 *
	 * @param o
	 *            the object to registered in the DB
	 * @return the Id o created Object
	 */
	Long create(Object o);

	/**
	 * Get Foot Object by its Id from DB
	 *
	 * @param id
	 *            Id of object to get
	 * @param theClass
	 *            Class to allowed Hibernate to get object
	 * @return the object that Id is in parameter
	 */
	<T> T getById(Long id, Class<T> theClass);

	/**
	 * Update an object in parameter in the DB
	 *
	 * @param o
	 */
	void update(Object o);

	/**
	 * Delete an object in DB
	 *
	 * @param o
	 */
	void delete(Object o);

	/**
	 * Get all objects from Table that class is in parameter
	 *
	 * @param theClazz
	 * @return
	 */
	<T> List<T> findAllObjectByClass(Class<T> theClazz);

}
