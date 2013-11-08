package com.perso.footcelad.core;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.junit.Assert;
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
import com.perso.footcelad.core.model.user.User;

/**
 *
 * @author Fabien Gautreault
 *
 */
public class FootDAOTest {

	/**
	 * Database
	 */
	private IFootDAO dao;

	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"context.xml");
		dao = (IFootDAO) context.getBean("footDaoBean");
	}

	/**
	 * Test create object
	 */
	@Test
	public void testCreate() {
		TestCase.assertNotNull(dao);

		// Creation d'une équipe
		Team homeTeam = new Team("FC BARCA");
		Long id = dao.create(homeTeam);
		TestCase.assertNotNull(id);

		// Création de 2 joueurs
		Player fabTrue = new Player("Inho", "Fab", "fab.inho@gmail.com");
		Long idPlayer1 = dao.create(fabTrue);
		TestCase.assertNotNull(idPlayer1);

		Player fabFalse = new Player("Peggy", "Fab", "fab.peggy@gmail.com");
		Long idPlayer2 = dao.create(fabFalse);
		TestCase.assertNotNull(idPlayer2);

		// Récupération des joueurs
		Player fab1 = dao.getById(idPlayer1, Player.class);
		TestCase.assertNotNull(fab1.getId());
		Player fab2 = dao.getById(idPlayer2, Player.class);
		TestCase.assertNotNull(fab2.getId());
		Assert.assertTrue(fab2 instanceof User);
		Assert.assertTrue(fab1 instanceof User);

		// Création de l'autre équipe
		Team guestTeam = new Team("CE CELAD");
		Set<Player> players = new HashSet<Player>();
		players.add(fab1);
		players.add(fab2);
		guestTeam.setPlayers(players);
		Long idGuest = dao.create(guestTeam);
		TestCase.assertNotNull(idGuest);

		// Creation d'un Stade
		Stadium stadium = new Stadium("Camp nou",
				"Carrer d'Aristides Maillol, 12, Barcelona", StadiumType.GRASS);
		Long idStadium = dao.create(stadium);
		TestCase.assertNotNull(idStadium);

		// Récupération des équipes et stade
		Team teamHome = dao.getById(id, Team.class);
		TestCase.assertNotNull(teamHome.getId());
		Team teamGuest = dao.getById(idGuest, Team.class);
		TestCase.assertNotNull(teamGuest.getId());
		Stadium macthStadium = dao.getById(idStadium, Stadium.class);
		TestCase.assertNotNull(macthStadium.getId());

		// Création du game
		Game game = new Game(teamHome, teamGuest, new Date(), macthStadium);
		Long idgame = dao.create(game);
		TestCase.assertNotNull(idgame);

		// Récupération du game
		Game gameEx = dao.getById(idgame, Game.class);
		Set<Player> selectedPlayers = new HashSet<Player>();
		selectedPlayers.add(fab1);
		selectedPlayers.add(fab2);
		gameEx.setPlayers(selectedPlayers);
		TestCase.assertNotNull(gameEx.getId());

		// Création d'un championnat
		Championship ch = new Championship("Exhibition");
		// Ajout des équipes
		Set<Team> teams = new HashSet<Team>();
		teams.add(teamGuest);
		teams.add(teamHome);
		ch.setTeams(teams);
		// Ajout du stade
		Set<Stadium> stadiums = new HashSet<Stadium>();
		stadiums.add(macthStadium);
		ch.setStadiums(stadiums);
		// Ajout du game
		Set<Game> games = new HashSet<Game>();
		games.add(gameEx);
		ch.setGames(games);

		Long idch = dao.create(ch);
		TestCase.assertNotNull(idch);
	}

	@Test
	public void testUpdate() {
		Player player = new Player("BEBER", "Pouf", "poufBeber@con.fr");
		Long idPlayer = dao.create(player);
		Assert.assertNotNull(idPlayer);

		Player playerToUpdate = dao.getById(idPlayer, Player.class);
		Assert.assertNotNull(playerToUpdate);

		playerToUpdate.setLicenceNumber(124563);
		playerToUpdate.setMail("poufBeber@put.fr");
		dao.update(playerToUpdate);

		Player playerToverify = dao.getById(idPlayer, Player.class);
		Assert.assertNotNull(playerToverify);
		Assert.assertEquals(playerToverify.getMail(), playerToverify.getMail());
		Assert.assertEquals(playerToverify.getLicenceNumber(),
				playerToverify.getLicenceNumber());

	}

	@Test
	public void testDelete() {
		Game game = new Game(new Team("NonoTeam"), new Team("MomoTeam"),
				new Date(), new Stadium("SAFRAN", "20 chemin laporte",
						StadiumType.STABILISED));
		Long idGame = dao.create(game);
		Assert.assertNotNull(idGame);

		Game gameToDelete = dao.getById(idGame, Game.class);
		Assert.assertNotNull(gameToDelete);

		dao.delete(gameToDelete);
		Assert.assertNull(dao.getById(idGame, Game.class));
	}

	@Test
	public void testFindAllObjectsByClass() {

		Stadium stadium = new Stadium("RING", "3 rue du fight 31000 Tlse",
				StadiumType.GRASS);
		Long idStadium = dao.create(stadium);
		Assert.assertNotNull(idStadium);

		List<Stadium> stades = dao.findAllObjectByClass(Stadium.class);
		Assert.assertNotNull(stades);
		Assert.assertTrue(!stades.isEmpty());
		Assert.assertTrue(stades.size() >= 1);
	}

}
