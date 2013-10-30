package com.perso.footcelad.core.model.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.perso.footcelad.core.model.championship.Match;
import com.perso.footcelad.core.model.enums.DisponibilityType;

/**
 * 
 * @author ktf01464
 * 
 */
@Entity
public class Disponibility implements Serializable {

	private Long id;
	private Match match;
	private DisponibilityType disponibility;
	private String commentaire;

	public Disponibility() {
	}

	@Id
	@Column(name="DISPONIBILITY_ID")
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

	@Column(name="DIPONIBILITY_TYPE",nullable=false)
	@Enumerated(EnumType.STRING)
	public DisponibilityType getDisponibility() {
		if(disponibility == null) return DisponibilityType.NONE;
		return disponibility;
	}

	public void setDisponibility(DisponibilityType disponibility) {
		this.disponibility = disponibility;
	}

	@Column(name="COMMENTAIRE")
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
