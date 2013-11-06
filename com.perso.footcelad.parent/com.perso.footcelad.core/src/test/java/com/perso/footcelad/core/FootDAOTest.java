package com.perso.footcelad.core;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.perso.footcelad.core.model.championship.Championship;
import com.perso.footcelad.core.model.championship.Game;
import com.perso.footcelad.core.model.championship.Stadium;
import com.perso.footcelad.core.model.championship.Team;
import com.perso.footcelad.core.model.dao.IFootDAO;
import com.perso.footcelad.core.model.enums.StadiumType;

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

		//Creation d'une équipe
		Team homeTeam = new Team("FC BARCA");
		Long id = dao.create(homeTeam);
		assertNotNull(id);

		//Création de l'autre équipe
		Team guestTeam = new Team("CE CELAD");
		Long idGuest = dao.create(guestTeam);
		assertNotNull(idGuest);
		
		//Creation d'un Stade
		Stadium stadium = new Stadium("Camp nou", "Carrer d'Aristides Maillol, 12, Barcelona", StadiumType.GRASS);
		Long idStadium = dao.create(stadium);
		assertNotNull(idStadium);
		
		//Récupération des équipes et stade
		Team teamHome = (Team) dao.getById(id, Team.class);
		assertNotNull(teamHome.getId());
		Team teamGuest = (Team) dao.getById(idGuest, Team.class);
		assertNotNull(teamGuest.getId());
		Stadium macthStadium = (Stadium) dao.getById(idStadium, Stadium.class);
		assertNotNull(macthStadium.getId());
		
		//Création du match
		Game match = new Game(teamHome, teamGuest, new Date(), macthStadium);
		Long idMatch = dao.create(match);
		assertNotNull(idMatch);
		
		//Récupération du match
//		Match matchEx = (Match) dao.getById(idMatch, Match.class);
//		assertNotNull(matchEx.getId());

		//Création d'un championnat
		Championship ch = new Championship("Exhibition");
		//Ajout des équipes
		Set<Team> teams = new HashSet<Team>();
		teams.add(teamGuest);
		teams.add(teamHome);
		ch.setTeams(teams);
//		//Ajout du stade
		Set<Stadium> stadiums = new HashSet<Stadium>();
		stadiums.add(macthStadium);
		ch.setStadiums(stadiums);
//		//Ajout du match
//		Set<Match> matchs = new HashSet<Match>();
//		matchs.add(matchEx);
//		ch.setMatchs(matchs);
		
		Long idch = dao.create(ch);
		assertNotNull(idch);
	}

}
