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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.perso.footcelad.core.model.enums.MatchType;
import com.perso.footcelad.core.model.user.Player;

/**
 * @author Fabien Gautreault
 * 
 *         A match is a meeting between two teams at a date and place
 */
@Entity
public class Match implements Serializable {

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
	 * Day and hour of the match
	 */
	private Date date;
	/**
	 * Type of the match
	 */
	private MatchType matchType;
	/**
	 * Give the result score for each team, and the type of result for the home
	 * team
	 */
	private Score score;
	/**
	 * Number of the journey, not relevant for amical match
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
	public Match() {
	}

	/**
	 * Minimum constructor for not nullable arguments
	 * 
	 * @param homeTeam
	 *            : the team receiving
	 * @param guestTeam
	 *            : the guest team
	 * @param matchDate
	 *            : the day and hour of the game
	 * @param stadium
	 *            : the place to play
	 */
	public Match(Team homeTeam, Team guestTeam, Date matchDate, Stadium stadium) {
		setHomeTeam(homeTeam);
		setGuestTeam(guestTeam);
		setDate(matchDate);
		setStadium(stadium);
	}

	// *********************************************** Getters and setters

	@Id
	@Column(name = "MATCH_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne
//	@Column(name = "HOME_TEAM", nullable = false)
	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	@OneToOne
//	@Column(name = "GUEST_TEAM", nullable = false)
	public Team getGuestTeam() {
		return guestTeam;
	}

	public void setGuestTeam(Team guestTeam) {
		this.guestTeam = guestTeam;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MATCH_DATE", nullable = false)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "MATCH_TYPE")
	@Enumerated(EnumType.STRING)
	public MatchType getMatchType() {
		if (matchType == null)
			return MatchType.JOURNEY;
		return matchType;
	}

	public void setMatchType(MatchType matchType) {
		this.matchType = matchType;
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
//	@Column(name = "STADIUM", nullable = false)
	public Stadium getStadium() {
		return stadium;
	}

	public void setStadium(Stadium stadium) {
		this.stadium = stadium;
	}

	@OneToMany
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
	 * Get the combination of journey, match type and team names
	 * 
	 * @return
	 */
	private String buildMatchName() {
		String name;
		if (MatchType.AMICAL.equals(matchType))
			name = matchType + ": " + homeTeam.getTeamName() + " VS "
					+ guestTeam.getTeamName();
		else
			name = matchType + " n°" + journeyNumber + ": "
					+ homeTeam.getTeamName() + " VS " + guestTeam.getTeamName();
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		return buildMatchName().equals(((Match) obj).buildMatchName());
	}

	@Override
	public int hashCode() {
		return buildMatchName().hashCode();
	}

}
