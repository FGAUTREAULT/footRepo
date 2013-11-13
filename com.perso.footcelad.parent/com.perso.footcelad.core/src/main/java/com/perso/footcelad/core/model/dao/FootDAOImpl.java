package com.perso.footcelad.core.model.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.perso.footcelad.core.model.championship.Championship;
import com.perso.footcelad.core.model.championship.Game;
import com.perso.footcelad.core.model.championship.Team;
import com.perso.footcelad.core.model.user.Player;
import com.perso.footcelad.core.util.HibernateUtil;

/**
 *
 * @author Fabien Gautreault
 *
 *         Gestion of the DAO, factory, session and server transaction to create
 *         objects
 *
 */
/**
 * @author KT006837
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
			if (serverTransaction != null) {
				serverTransaction.rollback();
			}
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
			object = (T) getFootSession().get(theClass, id);
			// validate transaction and create object if thread available
			// different => flush on session, suspend everything to create
			// object
			initializeChilds(object);
			serverTransaction.commit();
		} catch (HibernateException e) {
			// Avoid dead lock
			if (serverTransaction != null) {
				serverTransaction.rollback();
			}
			throw e;
		} finally {
			// Close the server transaction
			getFootSession().close();
		}

		return object;
	}

	/**
	 * Initialize collections of childs
	 * @param object : the parent
	 */
	private void initializeChilds(Object object) {
		if (object instanceof Championship) {
			Hibernate.initialize(((Championship) object).getTeams());
			Hibernate.initialize(((Championship) object).getGames());
			Hibernate.initialize(((Championship) object).getStadiums());
		} else if (object instanceof Team) {
			Hibernate.initialize(((Team) object).getPlayers());
		} else if (object instanceof Game) {
			Hibernate.initialize(((Game) object).getPlayers());
		} else if (object instanceof Player) {
			Hibernate.initialize(((Player) object).getDisponibilities());
		}
	}

	public void update(Object o) {

		try {
			// call server
			serverTransaction = getFootSession().beginTransaction();
			// update reference
			getFootSession().update(o);
			// validate transaction and create object if thread available
			// different => flush on session, suspend everything to create
			// object
			serverTransaction.commit();
		} catch (HibernateException e) {
			// Avoid dead lock
			if (serverTransaction != null) {
				serverTransaction.rollback();
			}
			throw e;
		} finally {
			// Close the server transaction
			getFootSession().close();
		}

	}

	public void delete(Object o) {

		try {
			// call server
			serverTransaction = getFootSession().beginTransaction();
			// delete reference
			getFootSession().delete(o);
			// validate transaction and create object if thread available
			// different => flush on session, suspend everything to create
			// object
			serverTransaction.commit();
		} catch (HibernateException e) {
			// Avoid dead lock
			if (serverTransaction != null) {
				serverTransaction.rollback();
			}
			throw e;
		} finally {
			// Close the server transaction
			getFootSession().close();
		}

	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findAllObjectByClass(Class<T> theClazz) {
		List<T> objects = null;

		try {
			serverTransaction = getFootSession().beginTransaction();
			Query query = getFootSession().createQuery(
					"from " + theClazz.getCanonicalName());
			objects = query.list();
		} catch (HibernateException hex) {
			if (serverTransaction != null) {
				serverTransaction.rollback();
			}
			throw hex;
		} finally {
			getFootSession().close();
		}
		return objects;
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
