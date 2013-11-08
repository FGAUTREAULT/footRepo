/**
 *
 */
package com.perso.footcelad.core;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.perso.footcelad.core.model.championship.Stadium;
import com.perso.footcelad.core.model.championship.Team;
import com.perso.footcelad.core.model.enums.StadiumType;
import com.perso.footcelad.core.model.services.IFootServices;

/**
 * @author Fabien O.
 *
 */
public class FootServicesTest {

	private IFootServices footservices;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"context.xml");
		footservices = (IFootServices) context.getBean("footServicesBean");
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
		Assert.assertFalse(footservices.createAStadium("","",StadiumType.GRASS));
		Assert.assertFalse(footservices.createAStadium(null,""));
		Assert.assertTrue(footservices.createAStadium("Camp Nou","Carrera",StadiumType.GRASS));
	}
}
