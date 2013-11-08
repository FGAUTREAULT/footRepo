/**
 *
 */
package com.perso.footcelad.core.model.services;

import java.util.Date;

import com.perso.footcelad.core.model.championship.Stadium;
import com.perso.footcelad.core.model.championship.Team;
import com.perso.footcelad.core.model.enums.StadiumType;

/**
 * @author Fabien O
 *
 */
public interface IFootServices {

	/**
	 * Service method to create a Championship
	 *
	 * The championship must not be null
	 *
	 * @param csName
	 *            : The name of the championship
	 *
	 * @return
	 */
	public boolean createAChampionship(String csName);

	/**
	 * Service method to create a Player
	 *
	 * @param familyName
	 *            : The family name of the player
	 * @param firstName
	 *            : The first name of the player
	 * @param mail
	 *            : The mail of the player
	 * @return
	 */
	public boolean createAPlayer(String familyName, String firstName,
			String mail);

	/**
	 *Service method to create an amical game
	 * @param homeTeam	: The home team
	 * @param guestTeam	: The guest team
	 * @param gameDate	: The date of the game
	 * @param stadium	: The place to play
	 * @return
	 */
	public boolean createAmicalGame(Team homeTeam, Team guestTeam,
			Date gameDate, Stadium stadium);

	/**
	 * Service method to create a journey game
	 * @param homeTeam	: The home team
	 * @param guestTeam	: The guest team
	 * @param gameDate	: The date of the game
	 * @param stadium	: The place to play
	 * @param journey	: The journey number
	 * @return
	 */
	public boolean createJourneyGame(Team homeTeam, Team guestTeam,
			Date gameDate, Stadium stadium, int journey);

	/**
	 * Service method to create a stadium
	 * @param stadiumName	: The stadium name
	 * @param address		: The address of the stadium
	 * @param stadiumType	: The type of track
	 * @return
	 */
	public boolean createAStadium(String stadiumName, String address, StadiumType stadiumType);

	/**
	 * Service method to create a stadium with unknown type track
	 * @param stadiumName	: The stadium name
	 * @param address		: The address of the stadium
	 * @return
	 */
	public boolean createAStadium(String stadiumName, String address);

	// public boolean createATeam();
	//
	// public void updateAChampionship();
	//
	// public void updateAPlayer();
	//
	// public void updateAGame();
	//
	// public void updateAStadium();
	//
	// public void updateATeam();
	//
	// public boolean deleteAChampionship();
	//
	// public boolean deleteAPlayer();
	//
	// public boolean deleteAGame();
	//
	// public boolean deleteAStadium();
	//
	// public boolean deleteATeam();

}
