package com.perso.footcelad.core;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.perso.footcelad.core.model.championship.Championship;
import com.perso.footcelad.core.model.championship.Team;
import com.perso.footcelad.core.model.dao.IFootDAO;

/**
 * 
 * @author Fabien Gautreault
 * 
 */
public class FootDAOTest extends TestCase {

	/**
	 * Database
	 */
	private IFootDAO dao;

	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"context.xml");
		dao = (IFootDAO) context.getBean("footDAO");
	}

	/**
	 * Test create object
	 */
	@Test
	public void testCreate() {
		assertNotNull(dao);
		Team team = new Team("Fab O");
		Long id = dao.create(team);
		assertNotNull(id);
		Championship ch = new Championship("Moiiiiiiiiiii");
		Team teamCreated = (Team) dao.getById(id, Team.class);
		assertNotNull(teamCreated.getId());
		Set<Team> teams = new HashSet<Team>();
		teams.add(team);
		ch.setTeams(teams);
		Long idch = dao.create(ch);
		assertNotNull(idch);
//		 Championship chCreated = dao.getById(idch, Championship.class);
//		 assertNotNull(chCreated.getTeams().);
//		 assertEquals(chCreated.getTeams().get(0), teamCreated);
//		 assertNotNull(chCreated);
	}

}
