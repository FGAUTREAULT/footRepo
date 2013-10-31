package com.perso.footcelad.core.model.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.perso.footcelad.core.model.championship.Match;
import com.perso.footcelad.core.model.enums.DisponibilityType;

/**
 * 
 * @author Fabien Gautreault
 * 
 *         Disponibility have to be set by a player for each game for the
 *         manager to be able to build a team
 * 
 */
@Entity
public class Disponibility implements Serializable {

	/**
	 * Unique id
	 */
	private Long id;
	/**
	 * The game, date and place to play
	 */
	private Match match;
	/**
	 * If the player can make it or not
	 */
	private DisponibilityType disponibility;
	/**
	 * To precise player decision
	 */
	private String commentaire;

	/**
	 * Default constructor
	 */
	public Disponibility() {
	}
	
	// *********************************************** Getters and setters
	
	@Id
	@Column(name = "DISPONIBILITY_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne
	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	@Column(name = "DIPONIBILITY_TYPE", nullable = false)
	@Enumerated(EnumType.STRING)
	public DisponibilityType getDisponibility() {
		if (disponibility == null)
			return DisponibilityType.NONE;
		return disponibility;
	}

	public void setDisponibility(DisponibilityType disponibility) {
		this.disponibility = disponibility;
	}

	@Column(name = "COMMENTAIRE")
	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	// *********************************************** Hash code

	@Override
	public boolean equals(Object obj) {
		return id.equals(((Disponibility) obj).getId());
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

}
