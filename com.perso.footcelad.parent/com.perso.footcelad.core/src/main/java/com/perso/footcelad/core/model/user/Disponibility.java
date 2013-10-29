package com.perso.footcelad.core.model.user;

import java.io.Serializable;

import com.perso.footcelad.core.model.championship.Match;
import com.perso.footcelad.core.model.enums.DisponibilityType;

/**
 * 
 * @author ktf01464
 * 
 */
public class Disponibility implements Serializable {

	private Long id;
	private Match match;
	private DisponibilityType disponibility;
	private String commentaire;

	public Disponibility() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public DisponibilityType getDisponibility() {
		if(disponibility == null) return DisponibilityType.NONE;
		return disponibility;
	}

	public void setDisponibility(DisponibilityType disponibility) {
		this.disponibility = disponibility;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	@Override
	public boolean equals(Object obj) {
		return id.equals(((Disponibility) obj).getId());
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

}
