/**
 * 
 */
package com.perso.footcelad.core.model.championship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.perso.footcelad.core.model.user.Manager;
import com.perso.footcelad.core.model.user.Player;

/**
 * @author ktf01464
 * 
 */
@Entity
public class Team implements Serializable {

	private Long id;
	private String teamName;
	private List<Player> players;
	private Manager manager;

	public Team() {
	}

	@Id
	@Column(name="TEAM_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="TEAM_NAME", nullable=false)
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

	@Override
	public boolean equals(Object obj) {
		return teamName.equalsIgnoreCase(((Team) obj).getTeamName());
	}

	@Override
	public int hashCode() {
		return teamName.hashCode();
	}

}
