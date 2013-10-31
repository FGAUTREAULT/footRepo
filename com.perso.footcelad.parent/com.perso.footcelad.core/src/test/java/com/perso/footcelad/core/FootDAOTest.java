package com.perso.footcelad.core;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.perso.footcelad.core.model.championship.Championship;
import com.perso.footcelad.core.model.dao.IFootDAO;

public class FootDAOTest extends TestCase{
	
	IFootDAO dao;

	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		dao = (IFootDAO) context.getBean("footDAO");
	}

	@Test
	public void testCreate() {
		assertNotNull(dao);
		Long id = dao.create(new Championship());
		assertNotNull(id);
	}

}
