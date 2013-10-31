package com.perso.footcelad.core.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.perso.footcelad.core.util.HibernateUtil;

/**
 * 
 * @author Fabien Gautreault
 * 
 *         Gestion of the DAO, factory, session and server transaction to create
 *         objects
 * 
 */
public class FootDAOImpl implements IFootDAO {

	/**
	 * Creation of a session factory
	 */
	private SessionFactory sessionFactory;
	/**
	 * Manipulate objects
	 */
	private Session footSession;
	/**
	 * Contact server
	 */
	private Transaction serverTransaction;

	public FootDAOImpl() {

	}

	public Long create(Object o) {
		Long id;
		try {
			// call server
			serverTransaction = getFootSession().beginTransaction();
			// create reference and get object id
			id = (Long) getFootSession().save(o);
			// validate transaction and create object if thread available
			// different => flush on session, suspend everything to create
			// object
			serverTransaction.commit();
		} catch (HibernateException e) {
			// Avoid dead lock
			if (serverTransaction != null)
				serverTransaction.rollback();
			throw e;
		} finally {
			// Close the server transaction
			getFootSession().close();
		}
		return id;
	}

	@SuppressWarnings("unchecked")
	public <T> T getById(Long id, Class<T> theClass) {
		T object;
		try {
			// call server
			serverTransaction = getFootSession().beginTransaction();
			// create reference and get object
			object = (T) getFootSession().load(theClass, id);
			// validate transaction and create object if thread available
			// different => flush on session, suspend everything to create
			// object
			serverTransaction.commit();
		} catch (HibernateException e) {
			// Avoid dead lock
			if (serverTransaction != null)
				serverTransaction.rollback();
			throw e;
		} finally {
			// Close the server transaction
			getFootSession().close();
		}
		return object;
	}

	public void update(Object o) {

	}

	public void delete(Object o) {

	}

	public SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			setSessionFactory(HibernateUtil.getSessionFactory());
		}
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Create or manage a session
	 * 
	 * @return
	 */
	public Session getFootSession() {
		if (footSession == null || !footSession.isOpen()) {
			setFootSession(getSessionFactory().openSession());
		}
		return footSession;
	}

	public void setFootSession(Session footSession) {
		this.footSession = footSession;
	}

}
