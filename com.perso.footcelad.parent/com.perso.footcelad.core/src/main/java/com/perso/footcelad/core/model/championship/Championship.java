/**
 * 
 */
package com.perso.footcelad.core.model.championship;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * @author Fabien Gautreault
 * 
 *         The championship is a group of games regarding a list a teams playing
 *         together We are not in the way to reproduce the complete championship
 *         FSGT support give all these informations
 */
@Entity
public class Championship implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -20406947726161183L;

	/**
	 * Unique id
	 */
	private Long id;
	/**
	 * List of teams in the championship
	 */
	private Set<Team> teams;
	/**
	 * List of games in the championship
	 */
	private Set<Game> games;
	/**
	 * List of stadiums availables for this championship
	 */
	private Set<Stadium> stadiums;
	/**
	 * Name of the championship
	 */
	private String championshipName;

	/**
	 * Default constructor
	 */
	public Championship() {
	}

	/**
	 * Minimum constructor for not nullable arguments
	 * 
	 * @param name
	 *            : name of the chamionship
	 */
	public Championship(String name) {
		setChampionshipName(name);
	}

	// *********************************************** Getters and setters

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "championship_game", joinColumns = @JoinColumn(name = "CHAMPIONSHIP_ID"), inverseJoinColumns = @JoinColumn(name = "GAME_ID"))
	public Set<Game> getGames() {
		if (games == null) {
			games = new HashSet<Game>();
		}
		return games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "championship_team", joinColumns = @JoinColumn(name = "CHAMPIONSHIP_ID"), inverseJoinColumns = @JoinColumn(name = "TEAM_ID"))
	public Set<Team> getTeams() {
		if (teams == null) {
			teams = new HashSet<Team>();
		}
		return teams;
	}

	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "championship_stadium", joinColumns = @JoinColumn(name = "CHAMPIONSHIP_ID"), inverseJoinColumns = @JoinColumn(name = "STADIUM_ID"))
	public Set<Stadium> getStadiums() {
		if (stadiums == null) {
			stadiums = new HashSet<Stadium>();
		}
		return stadiums;
	}

	public void setStadiums(Set<Stadium> stadiums) {
		this.stadiums = stadiums;
	}

	@Column(name = "CHAMPIONSHIP_NAME", nullable = false)
	public String getChampionshipName() {
		return championshipName;
	}

	public void setChampionshipName(String championshipName) {
		this.championshipName = championshipName;
	}

	@Id
	@Column(name = "CHAMPIONSHIP_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// ****************************************************** Hashcode

	@Override
	public boolean equals(Object arg0) {
		return this.id.equals(((Championship) arg0).getId());
	}

	@Override
	public int hashCode() {
		return this.championshipName.hashCode();
	}

}
