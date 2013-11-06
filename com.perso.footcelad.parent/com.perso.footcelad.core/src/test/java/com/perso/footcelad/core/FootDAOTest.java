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
import com.perso.footcelad.core.model.user.Player;

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
		
		//Création de 2 joueurs
		Player fabTrue = new Player("Inho", "Fab", "fab.inho@gmail.com");
		Long idPlayer1 = dao.create(fabTrue);
		assertNotNull(idPlayer1);
		
		Player fabFalse = new Player("Peggy", "Fab", "fab.peggy@gmail.com");
		Long idPlayer2 = dao.create(fabFalse);
		assertNotNull(idPlayer2);
		
		//Récupération des joueurs
		Player fab1 = (Player) dao.getById(idPlayer1, Player.class);
		assertNotNull(fab1.getId());
		Player fab2 = (Player) dao.getById(idPlayer2, Player.class);
		assertNotNull(fab2.getId());

		//Création de l'autre équipe
		Team guestTeam = new Team("CE CELAD");
		Set<Player> players = new HashSet<Player>();
		players.add(fab1);
		players.add(fab2);
		guestTeam.setPlayers(players);
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
		
		//Création du game
		Game game = new Game(teamHome, teamGuest, new Date(), macthStadium);
		Long idgame = dao.create(game);
		assertNotNull(idgame);
		
		//Récupération du game
		Game gameEx = (Game) dao.getById(idgame, Game.class);
		Set<Player> selectedPlayers = new HashSet<Player>();
		selectedPlayers.add(fab1);
		selectedPlayers.add(fab2);
		gameEx.setPlayers(selectedPlayers);
		assertNotNull(gameEx.getId());
		
		//Création d'un championnat
		Championship ch = new Championship("Exhibition");
		//Ajout des équipes
		Set<Team> teams = new HashSet<Team>();
		teams.add(teamGuest);
		teams.add(teamHome);
		ch.setTeams(teams);
		//Ajout du stade
		Set<Stadium> stadiums = new HashSet<Stadium>();
		stadiums.add(macthStadium);
		ch.setStadiums(stadiums);
		//Ajout du game
		Set<Game> games = new HashSet<Game>();
		games.add(gameEx);
		ch.setGames(games);
		
		Long idch = dao.create(ch);
		assertNotNull(idch);
	}

}
