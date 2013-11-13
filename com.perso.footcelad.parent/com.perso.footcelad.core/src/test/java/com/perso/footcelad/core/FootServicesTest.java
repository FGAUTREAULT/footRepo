/**
 *
 */
package com.perso.footcelad.core;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.perso.footcelad.core.model.championship.Championship;
import com.perso.footcelad.core.model.championship.Game;
import com.perso.footcelad.core.model.championship.Stadium;
import com.perso.footcelad.core.model.championship.Team;
import com.perso.footcelad.core.model.dao.IFootDAO;
import com.perso.footcelad.core.model.enums.DisponibilityType;
import com.perso.footcelad.core.model.enums.StadiumType;
import com.perso.footcelad.core.model.services.FootServicesImpl;
import com.perso.footcelad.core.model.services.IFootServices;
import com.perso.footcelad.core.model.user.Disponibility;
import com.perso.footcelad.core.model.user.Player;

/**
 * @author Fabien O.
 *
 */
public class FootServicesTest {

	private IFootServices footservices;
	private IFootDAO footDao;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"context.xml");
		footservices = (IFootServices) context.getBean("footServicesBean");
		footDao = ((FootServicesImpl) footservices).getFootDao();
	}

	@Test
	public void testCreateChampionship() {
		Assert.assertFalse(footservices.createAChampionship(""));
		Assert.assertFalse(footservices.createAChampionship(null));
		Assert.assertTrue(footservices.createAChampionship("PMT"));
	}

	@Test
	public void testCreatePlayer() {
		Assert.assertFalse(footservices.createAPlayer("", "Fab",
				"fab@gmail.com"));
		Assert.assertFalse(footservices.createAPlayer("Pegdwende", null,
				"pegdwendenull@gmail.com"));
		Assert.assertTrue(footservices.createAPlayer("Inho", "Fab",
				"fabinho@gmail.com"));
	}

	@Test
	public void testCreateGame() {
		Assert.assertFalse(footservices.createAmicalGame(null, new Team(
				"MomoTeam"), new Date(), new Stadium("SAFRAN",
				"20 chemin laporte", StadiumType.STABILISED)));
		Assert.assertTrue(footservices.createAmicalGame(new Team("DupouyTeam"),
				new Team("NabilaTeam"), new Date(), new Stadium("Jonquera",
						"2 chemin des bois", StadiumType.GRASS)));
		Assert.assertTrue(footservices.createJourneyGame(
				new Team("CricriTeam"), new Team("SylvainTeam"), new Date(),
				new Stadium("AIRBUS STADIUM", "12 passage gay",
						StadiumType.SYNTHETIC), 1));
	}

	@Test
	public void testCreateStadium() {
		Assert.assertFalse(footservices.createAStadium("", "",
				StadiumType.GRASS));
		Assert.assertFalse(footservices.createAStadium(null, ""));
		Assert.assertTrue(footservices.createAStadium("Camp Nou", "Carrera",
				StadiumType.GRASS));
	}

	@Test
	public void testCreateTeam() {
		Assert.assertFalse(footservices.createATeam(""));
		Assert.assertFalse(footservices.createATeam(null));
		Assert.assertTrue(footservices.createATeam("CE CELAD 2"));
	}

	@Test
	public void testUpdateChampionship() {
		Championship chship = footDao.getById(new Long(1), Championship.class);
		if (chship == null) {
			Assert.assertTrue(footservices.createAChampionship("BlablaCar"));
			chship = footDao.getById(new Long(1), Championship.class);
			Assert.assertEquals(chship.getChampionshipName(), "BlablaCar");

		}
		chship.setChampionshipName("Concon");

		Player playerFirst = new Player("aa", "BB", "aa@ccc.fr");
		Player playerSecond = new Player("dd", "EE", "dd@fff.fr");

		Team teamFirst = new Team("FC Concombre");
		Team teamSecond = new Team("AC Patate");

		Stadium stadium = new Stadium("Marche", "2 ARnaud Bernard",
				StadiumType.STABILISED);
		Game game = new Game(teamFirst, teamSecond, new Date(), stadium);

		Set<Disponibility> listDispo = new HashSet<Disponibility>(
				playerFirst.getDisponibilities());
		Disponibility dispoFirst = new Disponibility();
		dispoFirst.setGame(game);
		dispoFirst.setDisponibility(DisponibilityType.DISPONIBLE);
		listDispo.add(dispoFirst);

		playerFirst.setDisponibilities(listDispo);

		Set<Player> listPlayers = new HashSet<Player>(teamFirst.getPlayers());
		listPlayers.add(playerFirst);
		listPlayers.add(playerSecond);

		teamFirst.setPlayers(listPlayers);

		Set<Team> listTeam = new HashSet<Team>(chship.getTeams());
		Set<Stadium> listStadium = new HashSet<Stadium>(chship.getStadiums());
		Set<Game> listGames = new HashSet<Game>(chship.getGames());

		listTeam.add(teamFirst);
		listTeam.add(teamSecond);
		listStadium.add(stadium);
		listGames.add(game);

		chship.setStadiums(listStadium);
		chship.setGames(listGames);
		chship.setTeams(listTeam);

		footservices.updateAChampionship(chship);

		Championship chpshipUpdated = footDao.getById(new Long(1),
				Championship.class);
		Assert.assertEquals("Concon", chpshipUpdated.getChampionshipName());

		Team searchTeamFirst = null;
		Team searchTeamSecond = null;
		for (Team t : chpshipUpdated.getTeams()) {
			if ("FC Concombre".equalsIgnoreCase(t.getTeamName())) {
				searchTeamFirst = t;
			}
			if ("AC Patate".equalsIgnoreCase(t.getTeamName())) {
				searchTeamSecond = t;
			}
		}

		Assert.assertNotNull(searchTeamFirst);
		Assert.assertNotNull(searchTeamSecond);

		Team homeTeam = null;
		Team guestTeam = null;

		for (Game g : chpshipUpdated.getGames()) {
			if (g.getHomeTeam().equals(teamFirst)) {
				homeTeam = g.getHomeTeam();
			}
			if (g.getGuestTeam().equals(teamSecond)) {
				guestTeam = g.getGuestTeam();
			}
		}

		Assert.assertNotNull(homeTeam);
		Assert.assertNotNull(guestTeam);

		Stadium searchStadium = null;
		for (Stadium st : chpshipUpdated.getStadiums()) {
			if ("Marche".equalsIgnoreCase(st.getStadiumName())) {
				searchStadium = st;
			}
		}

		Assert.assertNotNull(searchStadium);
	}

	@Test
	public void testUpdatePlayer() {
		Player player = footDao.getById(new Long(1), Player.class);
		if (player == null) {
			Assert.assertTrue(footservices.createAPlayer("Family", "First",
					"mail"));
			player = footDao.getById(new Long(1), Player.class);
			Assert.assertEquals(player.getUserFamilyName(), "Family");
			Assert.assertEquals(player.getUserFirstName(), "First");
			Assert.assertEquals(player.getMail(), "mail");
		}
		player.setUserFamilyName("Ta");
		player.setUserFirstName("gueule");
		player.setMail("assane");

		Disponibility dispo = new Disponibility();
		dispo.setDisponibility(DisponibilityType.INJURED);

		Set<Disponibility> listDispo = new HashSet<Disponibility>(
				player.getDisponibilities());
		listDispo.add(dispo);
		player.setDisponibilities(listDispo);
		footservices.updateAPlayer(player);

		Player playerUpdated = footDao.getById(new Long(1), Player.class);
		Assert.assertEquals(player.getUserFamilyName(),
				playerUpdated.getUserFamilyName());
		Assert.assertEquals(player.getUserFirstName(),
				playerUpdated.getUserFirstName());
		Assert.assertEquals(player.getMail(), playerUpdated.getMail());

		Disponibility searchDispo = null;
		for (Disponibility d : playerUpdated.getDisponibilities()) {
			if (d.equals(dispo)) {
				searchDispo = d;
			}
		}

		Assert.assertNotNull(searchDispo);

	}

	@Test
	public void testUpdateGame() {
		Game game = footDao.getById(new Long(1), Game.class);
		if (game == null) {
			Assert.assertTrue(footservices.createAmicalGame(new Team("Tarin"),
					new Team("Tarascon"), new Date(), new Stadium("Soutenance",
							"CNRS")));
			game = footDao.getById(new Long(1), Game.class);
			Assert.assertNotNull(game.getHomeTeam());
			Assert.assertNotNull(game.getGuestTeam());
			Assert.assertNotNull(game.getStadium());
		}
		game.setHomeTeam(new Team("Tarani"));
		game.setGuestTeam(new Team("Tarriquet"));
		game.setStadium(new Stadium("cirimat", " route de narbonne"));

		Player playerFirst = new Player("Gautreault", "Fafa", "go@saoul.fr");
		Player playerSecond = new Player("OUEDRAOGO", "Asso", "be@dead.fr");
		Set<Player> listDispo = new HashSet<Player>(game.getPlayers());
		listDispo.add(playerFirst);
		listDispo.add(playerSecond);
		game.setPlayers(listDispo);
		footservices.updateAGame(game);

		Game gameUpdated = footDao.getById(new Long(1), Game.class);
		Assert.assertNotNull(gameUpdated.getHomeTeam());
		Assert.assertNotNull(gameUpdated.getGuestTeam());
		Assert.assertNotNull(gameUpdated.getStadium());
		Assert.assertTrue(gameUpdated.getPlayers().size() > 1);

		Player searchPlayer = null;
		for (Player p : gameUpdated.getPlayers()) {
			if (p.equals(playerFirst)) {
				searchPlayer = p;
			}
		}
		Assert.assertNotNull(searchPlayer);
	}
}
