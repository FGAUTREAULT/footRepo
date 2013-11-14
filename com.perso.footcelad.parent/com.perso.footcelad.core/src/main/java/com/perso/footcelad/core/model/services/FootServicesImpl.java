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
 * @author Fabiensssssssssss
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

	public Long createAChampionship(String csName) {
		if (csName != null && !"".equals(csName)) {
			Championship champship = new Championship(csName);
			Long id = footDao.create(champship);
			if (id != null) {
				logger.info("Championship created: " + id);
				return id;
			} else {
				logger.info("Championship creation failed: " + csName);
			}
		} else {
			logger.info("Championship name must not be null or empty: "
					+ csName);
		}

		return null;
	}

	public Long createAPlayer(String familyName, String firstName,
			String mail) {

		if (familyName != null && !"".equals(familyName) && firstName != null
				&& !"".equals(firstName) && mail != null && !"".equals(mail)) {
			Player player = new Player(familyName, firstName, mail);
			Long id = footDao.create(player);
			if (id != null) {
				logger.info("Player created: " + id);
				return id;
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
		return null;
	}

	public Long createAmicalGame(Team homeTeam, Team guestTeam,
			Date gameDate, Stadium stadium) {
		return createJourneyGame(homeTeam, guestTeam, gameDate, stadium, -1);
	}

	public Long createJourneyGame(Team homeTeam, Team guestTeam,
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
				return idGame;
			} else {
				logger.info("Game creation failed " + idGame);
				logger.info("Please check Entities(homeTeam, guestTeam and stadium) for non nullable parameters ...");
			}
		} else {
			logger.info("Parameters must not be null! Please check: "
					+ "Home team : " + homeTeam + " Guest team : " + guestTeam
					+ " Game Date : " + gameDate + " Stadium : " + stadium);
		}

		return null;
	}

	public Long createAStadium(String stadiumName, String address) {
		return createAStadium(stadiumName, address, StadiumType.UNKNOWN);
	}

	public Long createAStadium(String stadiumName, String address,
			StadiumType stadiumType) {

		if (stadiumName != null && !stadiumName.isEmpty() && address != null
				&& !address.isEmpty() && stadiumType != null) {
			Stadium stadium = new Stadium(stadiumName, address, stadiumType);
			Long idStadium = footDao.create(stadium);
			if (idStadium != null) {
				logger.info("Stadium created : " + idStadium);
				return idStadium;
			} else {
				logger.info("Stadium creation failed " + idStadium);
				logger.info("Please check Entity stadium for non nullable parameters ...");
			}
		} else {
			logger.info("Parameters must not be null or empty! Please check: "
					+ "Stadium name: " + stadiumName + ", Address: " + address
					+ ", Stadium track type " + stadiumType.name());
		}

		return null;
	}

	public Long createATeam(String teamName) {

		if (teamName != null && !teamName.isEmpty()) {
			Team team = new Team(teamName);
			Long idTeam = footDao.create(team);
			if (idTeam != null) {
				logger.info("Team created : " + idTeam);
				return idTeam;
			} else {
				logger.info("Team creation failed " + idTeam);
			}
		} else {
			logger.info("Team name must not be null or empty." + "Team name: "
					+ teamName);
		}
		return null;
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

	public void updateAStadium(Stadium stadium) {
		if (stadium != null) {
			if (stadium.getStadiumName() != null
					&& !stadium.getStadiumName().isEmpty()
					&& stadium.getAddress() != null
					&& !stadium.getAddress().isEmpty()) {
				try {
					footDao.update(stadium);
					logger.info("Stadium updated: " + stadium.getId());
				} catch (Exception ex) {
					logger.info("Stadium update failed: " + ex.getMessage());
				}

			} else {
				logger.info("Parameters must not be null or empty! Please check: "
						+ "Stadium name: "
						+ stadium.getStadiumName()
						+ ", Address: "
						+ stadium.getAddress()
						+ ", Stadium track type "
						+ stadium.getStadiumType().name());
			}
		} else {
			logger.info("Stadium must not be null.");
		}
	}

	public void updateATeam(Team team) {
		if (team != null) {
			if (team.getTeamName() != null && !team.getTeamName().isEmpty()) {
				try {
					footDao.update(team);
					logger.info("Team updated: " + team.getId());
				} catch (Exception ex) {
					logger.info("Team update failed: " + ex.getMessage());
				}

			} else {
				logger.info("Team name must not be null or empty."
						+ "Team name: " + team.getTeamName());
			}
		} else {
			logger.info("Team must not be null.");
		}
	}

	public boolean deleteAChampionship(Championship championship) {
		if (championship != null) {
			try {
				footDao.delete(championship);
				logger.info("Championship deleted: " + championship.getId());
				return true;
			} catch (Exception ex) {
				logger.info("Championship delete failed: " + ex.getMessage());
			}
		} else {
			logger.info("Championship must not be null.");
		}
		return false;
	}

	public boolean deleteAPlayer(Player player) {
		if (player != null) {
			try {
				footDao.delete(player);
				logger.info("Player deleted: " + player.getId());
				return true;
			} catch (Exception ex) {
				logger.info("Player delete failed: " + ex.getMessage());
			}
		} else {
			logger.info("Player must not be null.");
		}
		return false;
	}

	public boolean deleteAGame(Game game) {
		if (game != null) {
			try {
				footDao.delete(game);
				logger.info("Game deleted: " + game.getId());
				return true;
			} catch (Exception ex) {
				logger.info("Game delete failed: " + ex.getMessage());
			}
		} else {
			logger.info("Game must not be null.");
		}
		return false;
	}

	public boolean deleteAStadium(Stadium stadium) {
		if (stadium != null) {
			try {
				footDao.delete(stadium);
				logger.info("Stadium deleted: " + stadium.getId());
				return true;
			} catch (Exception ex) {
				logger.info("Stadium delete failed: " + ex.getMessage());
			}
		} else {
			logger.info("Stadium must not be null.");
		}
		return false;
	}

	public boolean deleteATeam(Team team) {
		if (team != null) {
			try {
				footDao.delete(team);
				logger.info("Team deleted: " + team.getId());
				return true;
			} catch (Exception ex) {
				logger.info("Team delete failed: " + ex.getMessage());
			}
		} else {
			logger.info("Team must not be null.");
		}
		return false;
	}

}
