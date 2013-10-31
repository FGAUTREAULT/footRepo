/**
 * 
 */
package com.perso.footcelad.core.model.championship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.perso.footcelad.core.model.user.Manager;
import com.perso.footcelad.core.model.user.Player;

/**
 * @author Fabien Gautreault
 * 
 *         A team is a group of players plus a manager
 * 
 */
@Entity
public class Team implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Unique id
	 */
	private Long id;
	/**
	 * The name of the team
	 */
	private String teamName;
	/**
	 * List of all players in the team
	 */
	private List<Player> players;
	/**
	 * The manager of the team
	 */
	private Manager manager;

	/**
	 * Default constructor
	 */
	public Team() {
	}

	/**
	 * Minimum constructor for not nullable arguments The name of the team is
	 * the only required parameter, we are not in the way to keep recorded all
	 * players and manager name for all team, FSGT support give all these
	 * information and keep it updated
	 * 
	 * CELAD team will need all the information, best practice would be to keep
	 * updated at least the manager of each team, to send FDM, contact for
	 * anything
	 * 
	 * @param name : the name of the team
	 */
	public Team(String name) {
		setTeamName(name);
	}

	// *********************************************** Getters and setters

	@Id
	@Column(name = "TEAM_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "TEAM_NAME", nullable = false)
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
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

	@OneToOne
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	// *********************************************** Hash code

	@Override
	public boolean equals(Object obj) {
		return teamName.equalsIgnoreCase(((Team) obj).getTeamName());
	}

	@Override
	public int hashCode() {
		return teamName.hashCode();
	}

}
