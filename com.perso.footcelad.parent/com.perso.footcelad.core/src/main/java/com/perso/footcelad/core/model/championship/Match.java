/**
 * 
 */
package com.perso.footcelad.core.model.championship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.perso.footcelad.core.model.enums.MatchType;
import com.perso.footcelad.core.model.user.Player;


/**
 * @author ktf01464
 * 
 */
public class Match implements Serializable {

	private Long id;
	private Team teamA;
	private Team teamB;
	private Date date;
	private MatchType matchType;
	private Score score;
	private int journeyNumber;
	private Stadium stadium;
	private List<Player> players;

	public Match() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Team getTeamA() {
		return teamA;
	}

	public void setTeamA(Team teamA) {
		this.teamA = teamA;
	}

	public Team getTeamB() {
		return teamB;
	}

	public void setTeamB(Team teamB) {
		this.teamB = teamB;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public MatchType getMatchType() {
		if (matchType == null)
			return MatchType.JOURNEY;
		return matchType;
	}

	public void setMatchType(MatchType matchType) {
		this.matchType = matchType;
	}

	public Score getScore() {
		if (score == null) {
			score = new Score();
		}
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public int getJourneyNumber() {
		return journeyNumber;
	}

	public void setJourneyNumber(int journeyNumber) {
		this.journeyNumber = journeyNumber;
	}

	public Stadium getStadium() {
		return stadium;
	}

	public void setStadium(Stadium stadium) {
		this.stadium = stadium;
	}

	public List<Player> getPlayers() {
		if (players == null) {
			players = new ArrayList<Player>();
		}
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	/**
	 * Get the combination of journey, match type and team names
	 * 
	 * @return
	 */
	public String getMatchName() {
		String name;
		if (MatchType.AMICAL.equals(matchType))
			name = matchType + ": " + teamA.getTeamName() + " VS "
					+ teamB.getTeamName();
		else
			name = matchType + " n°" + journeyNumber +": " + teamA.getTeamName() + " VS "
					+ teamB.getTeamName();
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		return getMatchName().equals(((Match) obj).getMatchName());
	}

	@Override
	public int hashCode() {
		return getMatchName().hashCode();
	}

}
