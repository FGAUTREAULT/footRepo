/**
 * 
 */
package com.perso.footcelad.core.model.championship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ktf01464
 * 
 */
public class Championship implements Serializable {

	private Long id;
	private List<Team> teams;
	private List<Match> matchs;
	private List<Stadium> stadiums;
	private String championshipName;

	public Championship() {
	}

	public List<Match> getMatchs() {
		if (matchs == null) {
			matchs = new ArrayList<Match>();
		}
		return matchs;
	}

	public void setMatchs(List<Match> matchs) {
		this.matchs = matchs;
	}

	public List<Team> getTeams() {
		if (teams == null) {
			teams = new ArrayList<Team>();
		}
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public List<Stadium> getStadiums() {
		if (stadiums == null) {
			stadiums = new ArrayList<Stadium>();
		}
		return stadiums;
	}

	public void setStadiums(List<Stadium> stadiums) {
		this.stadiums = stadiums;
	}

	public String getChampionshipName() {
		return championshipName;
	}

	public void setChampionshipName(String championshipName) {
		this.championshipName = championshipName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object arg0) {
		return this.id.equals(((Championship) arg0).getId());
	}

	@Override
	public int hashCode() {
		return this.championshipName.hashCode();
	}

}
