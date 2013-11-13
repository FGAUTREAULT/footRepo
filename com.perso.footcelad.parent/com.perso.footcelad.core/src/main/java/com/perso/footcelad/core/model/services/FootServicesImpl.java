/**
 *
 */
package com.perso.footcelad.core.model.services;

import java.util.Date;
import java.util.logging.Logger;

import com.perso.footcelad.core.model.championship.Championship;
import com.perso.footcelad.core.model.championship.Game;
import com.perso.footcelad.core.model.championship.Stadium;
import com.perso.footcelad.core.model.championship.Team;
import com.perso.footcelad.core.model.dao.IFootDAO;
import com.perso.footcelad.core.model.enums.StadiumType;
import com.perso.footcelad.core.model.user.Player;

/**
 * @author KT006837
 *
 */
/**
 * @author KT006837
 *
 */
/**
 * @author KT006837
 *
 */
/**
 * @author KT006837
 *
 */
/**
 * @author KT006837
 *
 */
/**
 * @author KT006837
 *
 */
/**
 * @author KT006837
 *
 */
public class FootServicesImpl implements IFootServices {

	private final Logger logger = Logger.getLogger(FootServicesImpl.class
			.getName());

	/**
	 * dao forwarded by spring with empty constructor initialization
	 */
	private IFootDAO footDao;

	/**
	 *
	 */
	public FootServicesImpl() {
	}

	/**
	 * @return the footDao
	 */
	public IFootDAO getFootDao() {
		return footDao;
	}

	/**
	 * @param footDao
	 *            the footDao to set
	 */
	public void setFootDao(IFootDAO footDao) {
		this.footDao = footDao;
	}

	public boolean createAChampionship(String csName) {
		if (csName != null && !"".equals(csName)) {
			Championship champship = new Championship(csName);
			Long id = footDao.create(champship);
			if (id != null) {
				logger.info("Championship created: " + id);
				return true;
			} else {
				logger.info("Championship creation failed: " + csName);
			}
		} else {
			logger.info("Championship name must not be null or empty: "
					+ csName);
		}

		return false;
	}

	public boolean createAPlayer(String familyName, String firstName,
			String mail) {

		if (familyName != null && !"".equals(familyName) && firstName != null
				&& !"".equals(firstName) && mail != null && !"".equals(mail)) {
			Player player = new Player(familyName, firstName, mail);
			Long id = footDao.create(player);
			if (id != null) {
				logger.info("Player created: " + id);
				return true;
			} else {
				logger.info("Player creation failed: " + "Family name: "
						+ familyName + ", First name: " + firstName
						+ ", Mail: " + mail);
			}

		} else {
			logger.info("Player family name, first name and mail must not be null or empty: "
					+ "Family name: "
					+ familyName
					+ ", First name: "
					+ firstName + ", Mail: " + mail);
		}
		return false;
	}

	public boolean createAmicalGame(Team homeTeam, Team guestTeam,
			Date gameDate, Stadium stadium) {
		return createJourneyGame(homeTeam, guestTeam, gameDate, stadium, -1);
	}

	public boolean createJourneyGame(Team homeTeam, Team guestTeam,
			Date gameDate, Stadium stadium, int journey) {
		if (homeTeam != null && guestTeam != null && gameDate != null
				&& stadium != null) {
			Game game = null;
			if (journey == -1) {
				game = new Game(homeTeam, guestTeam, gameDate, stadium);
			} else {
				game = new Game(homeTeam, guestTeam, gameDate, stadium, journey);
			}
			Long idGame = footDao.create(game);
			if (idGame != null) {
				logger.info("Game created : " + idGame);
				return true;
			} else {
				logger.info("Game creation failed " + idGame);
				logger.info("Please check Entities(homeTeam, guestTeam and stadium) for non nullable parameters ...");
			}
		} else {
			logger.info("Parameters must not be null! Please check: "
					+ "Home team : " + homeTeam + " Guest team : " + guestTeam
					+ " Game Date : " + gameDate + " Stadium : " + stadium);
		}

		return false;
	}

	public boolean createAStadium(String stadiumName, String address) {
		return createAStadium(stadiumName, address, StadiumType.UNKNOWN);
	}

	public boolean createAStadium(String stadiumName, String address,
			StadiumType stadiumType) {

		if (stadiumName != null && !stadiumName.isEmpty() && address != null
				&& !address.isEmpty() && stadiumType != null) {
			Stadium stadium = new Stadium(stadiumName, address, stadiumType);
			Long idStadium = footDao.create(stadium);
			if (idStadium != null) {
				logger.info("Stadium created : " + idStadium);
				return true;
			} else {
				logger.info("Stadium creation failed " + idStadium);
				logger.info("Please check Entity stadium for non nullable parameters ...");
			}
		} else {
			logger.info("Parameters must not be null or empty! Please check: "
					+ "Stadium name: " + stadiumName + ", Address: " + address
					+ ", Stadium track type " + stadiumType.name());
		}

		return false;
	}

	public boolean createATeam(String teamName) {

		if (teamName != null && !teamName.isEmpty()) {
			Team team = new Team(teamName);
			Long idTeam = footDao.create(team);
			if (idTeam != null) {
				logger.info("Team created : " + idTeam);
				return true;
			} else {
				logger.info("Team creation failed " + idTeam);
			}
		} else {
			logger.info("Team name must not be null or empty." + "Team name: "
					+ teamName);
		}
		return false;
	}

	public void updateAChampionship(Championship championship) {
		if (championship != null) {
			if (championship.getChampionshipName() != null
					&& !"".equals(championship.getChampionshipName())) {
				try {
					footDao.update(championship);
					logger.info("Championship updated: " + championship.getId());
				} catch (Exception ex) {
					ex.printStackTrace();
					logger.info("Championship update failed: "
							+ ex.getMessage());
				}

			} else {
				logger.info("Championship name must not be null or empty: "
						+ championship.getChampionshipName());
			}
		} else {
			logger.info("Championship must not be null. ");
		}
	}

	public void updateAPlayer(Player player) {
		if (player != null) {
			if (player.getUserFamilyName() != null
					&& !"".equals(player.getUserFamilyName())
					&& player.getUserFirstName() != null
					&& !"".equals(player.getUserFirstName())
					&& player.getMail() != null && !"".equals(player.getMail())) {
				try {
					footDao.update(player);
					logger.info("Player updated: " + player.getId());
				} catch (Exception ex) {
					logger.info("Player update failed: " + ex.getMessage());
				}

			} else {
				logger.info("Player family name, first name and mail must not be null or empty: "
						+ "Family name: "
						+ player.getUserFamilyName()
						+ ", First name: "
						+ player.getUserFirstName()
						+ ", Mail: " + player.getMail());
			}
		} else {
			logger.info("Player must not be null.");
		}
	}

	public void updateAGame(Game game) {
		if (game != null) {
			if (game.getDate() != null && game.getGuestTeam() != null
					&& game.getHomeTeam() != null && game.getStadium() != null) {
				try {
					footDao.update(game);
					logger.info("Game updated: " + game.getId());
				} catch (Exception ex) {
					logger.info("Game update failed: " + ex.getMessage());
				}

			} else {
				logger.info("Parameters must not be null! Please check: "
						+ "Home team : " + game.getHomeTeam()
						+ " Guest team : " + game.getGuestTeam()
						+ " Game Date : " + game.getDate() + " Stadium : "
						+ game.getStadium());
			}
		} else {
			logger.info("Game must not be null.");
		}

	}

}
