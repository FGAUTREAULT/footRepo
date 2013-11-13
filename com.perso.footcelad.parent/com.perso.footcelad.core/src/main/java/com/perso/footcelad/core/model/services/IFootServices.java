/**
 *
 */
package com.perso.footcelad.core.model.services;

import java.util.Date;

import com.perso.footcelad.core.model.championship.Championship;
import com.perso.footcelad.core.model.championship.Game;
import com.perso.footcelad.core.model.championship.Stadium;
import com.perso.footcelad.core.model.championship.Team;
import com.perso.footcelad.core.model.enums.StadiumType;
import com.perso.footcelad.core.model.user.Player;

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
	 * Service method to create an amical game
	 *
	 * @param homeTeam
	 *            : The home team
	 * @param guestTeam
	 *            : The guest team
	 * @param gameDate
	 *            : The date of the game
	 * @param stadium
	 *            : The place to play
	 * @return
	 */
	public boolean createAmicalGame(Team homeTeam, Team guestTeam,
			Date gameDate, Stadium stadium);

	/**
	 * Service method to create a journey game
	 *
	 * @param homeTeam
	 *            : The home team
	 * @param guestTeam
	 *            : The guest team
	 * @param gameDate
	 *            : The date of the game
	 * @param stadium
	 *            : The place to play
	 * @param journey
	 *            : The journey number
	 * @return
	 */
	public boolean createJourneyGame(Team homeTeam, Team guestTeam,
			Date gameDate, Stadium stadium, int journey);

	/**
	 * Service method to create a stadium
	 *
	 * @param stadiumName
	 *            : The stadium name
	 * @param address
	 *            : The address of the stadium
	 * @param stadiumType
	 *            : The type of track
	 * @return
	 */
	public boolean createAStadium(String stadiumName, String address,
			StadiumType stadiumType);

	/**
	 * Service method to create a stadium with unknown type track
	 *
	 * @param stadiumName
	 *            : The stadium name
	 * @param address
	 *            : The address of the stadium
	 * @return
	 */
	public boolean createAStadium(String stadiumName, String address);

	/**
	 * Service method to create a team
	 *
	 * @param teamName
	 *            : the name of the team
	 * @return
	 */
	public boolean createATeam(String teamName);

	/**
	 * Service method to update a {@link Championship}
	 *
	 * @param championship
	 */
	public void updateAChampionship(Championship championship);

	/**
	 * Service method to update a {@link Player}
	 *
	 * @param player
	 */
	public void updateAPlayer(Player player);

	/**
	 * Service method to update a {@link Game}
	 *
	 * @param game
	 */
	public void updateAGame(Game game);
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
