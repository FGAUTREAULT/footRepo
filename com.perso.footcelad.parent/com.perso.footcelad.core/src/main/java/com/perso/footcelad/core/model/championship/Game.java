/**
 * 
 */
package com.perso.footcelad.core.model.championship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.perso.footcelad.core.model.enums.GameType;
import com.perso.footcelad.core.model.user.Player;

/**
 * @author Fabien Gautreault
 * 
 *         A game is a meeting between two teams at a date and place
 */
@Entity
public class Game implements Serializable {

	/**
	 * Unique id
	 */
	private Long id;
	/**
	 * Home team
	 */
	private Team homeTeam;
	/**
	 * Guest team
	 */
	private Team guestTeam;
	/**
	 * Day and hour of the game
	 */
	private Date date;
	/**
	 * Type of the game
	 */
	private GameType gameType;
	/**
	 * Give the result score for each team, and the type of result for the home
	 * team
	 */
	private Score score;
	/**
	 * Number of the journey, not relevant for amical game
	 */
	private int journeyNumber;
	/**
	 * The place to play
	 */
	private Stadium stadium;
	/**
	 * The list of players participating As this implementation is done
	 * regarding CELAD team, this list represent the players of CELAD called in
	 * to play this game
	 */
	private List<Player> players;

	/**
	 * Default constructor
	 */
	public Game() {
	}

	/**
	 * Minimum constructor for not nullable arguments
	 * 
	 * @param homeTeam
	 *            : the team receiving
	 * @param guestTeam
	 *            : the guest team
	 * @param gameDate
	 *            : the day and hour of the game
	 * @param stadium
	 *            : the place to play
	 */
	public Game(Team homeTeam, Team guestTeam, Date gameDate, Stadium stadium) {
		setHomeTeam(homeTeam);
		setGuestTeam(guestTeam);
		setDate(gameDate);
		setStadium(stadium);
	}

	// *********************************************** Getters and setters

	@Id
	@Column(name = "GAME_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne
	@JoinColumn(name = "HOME_TEAM", nullable = false, referencedColumnName="TEAM_ID")
	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	@OneToOne
	@JoinColumn(name = "GUEST_TEAM", nullable = false, referencedColumnName="TEAM_ID")
	public Team getGuestTeam() {
		return guestTeam;
	}

	public void setGuestTeam(Team guestTeam) {
		this.guestTeam = guestTeam;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "GAME_DATE", nullable = false)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "GAME_TYPE")
	@Enumerated(EnumType.STRING)
	public GameType getGameType() {
		if (gameType == null)
			return GameType.JOURNEY;
		return gameType;
	}

	public void setGameType(GameType gameType) {
		this.gameType = gameType;
	}

//	@OneToOne
	public Score getScore() {
		if (score == null) {
			score = new Score();
		}
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	@Column(name = "JOURNEY_NB", unique = true)
	public int getJourneyNumber() {
		return journeyNumber;
	}

	public void setJourneyNumber(int journeyNumber) {
		this.journeyNumber = journeyNumber;
	}

	@OneToOne
	@JoinColumn(name = "STADIUM", nullable = false, referencedColumnName="STADIUM_ID")
	public Stadium getStadium() {
		return stadium;
	}

	public void setStadium(Stadium stadium) {
		this.stadium = stadium;
	}

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "game_player", joinColumns = @JoinColumn(name = "GAME_ID"), inverseJoinColumns = @JoinColumn(name = "USER_ID"))
	public List<Player> getPlayers() {
		if (players == null) {
			players = new ArrayList<Player>();
		}
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	// *********************************************** Hashcode

	/**
	 * Get the combination of journey, game type and team names
	 * 
	 * @return
	 */
	private String buildGameName() {
		String name;
		if (GameType.AMICAL.equals(gameType))
			name = gameType + ": " + homeTeam.getTeamName() + " VS "
					+ guestTeam.getTeamName();
		else
			name = gameType + " n°" + journeyNumber + ": "
					+ homeTeam.getTeamName() + " VS " + guestTeam.getTeamName();
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		return buildGameName().equals(((Game) obj).buildGameName());
	}

	@Override
	public int hashCode() {
		return buildGameName().hashCode();
	}
}
