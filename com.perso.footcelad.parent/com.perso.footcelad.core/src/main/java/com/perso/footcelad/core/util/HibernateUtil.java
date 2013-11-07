package com.perso.footcelad.core.util;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * 
 * @author Fabien Gautreault
 * 
 *         First bean to get session and contact server
 * 
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public HibernateUtil() {
	}

	/**
	 * Build la factory avant de récupérer l'HibernateUtil
	 */
	static {
		try {
			Configuration config = new Configuration();
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
					.applySettings(
							config.configure("hibernate.cfg.xml")
									.getProperties()).buildServiceRegistry();
			sessionFactory = config.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger(HibernateUtil.class.getName()).info(
					"Build session factory failed");
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
