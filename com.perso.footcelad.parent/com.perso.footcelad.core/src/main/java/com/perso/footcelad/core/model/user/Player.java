/**
 * 
 */
package com.perso.footcelad.core.model.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.perso.footcelad.core.model.enums.PlayerType;


/**
 * @author ktf01464
 * 
 */
@Entity
public class Player extends User {

	private Long id;
	private PlayerType playerType;
	private int nbGoal;
	private int nbPass;
	private int licenceNumber;
	private int nbWash;
	private List<Disponibility> disponibilities;
	private PlayerType preferredPositionA;
	private PlayerType preferredPositionB;

	public Player() {
	}

	@Id
	@Column(name="PLAYER_ID", nullable=false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="PLAYER_TYPE", nullable=false)
	@Enumerated(EnumType.STRING)
	public PlayerType getPlayerType() {
		return playerType;
	}

	public void setPlayerType(PlayerType playerType) {
		this.playerType = playerType;
	}

	@Column(name="NB_GOAL")
	public int getNbGoal() {
		return nbGoal;
	}

	public void setNbGoal(int nbGoal) {
		this.nbGoal = nbGoal;
	}

	@Column(name="NB_PASS")
	public int getNbPass() {
		return nbPass;
	}

	public void setNbPass(int nbPass) {
		this.nbPass = nbPass;
	}

	@Column(name="LICENCE_NUMBER")
	public int getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(int licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	@Column(name="NB_WASH")
	public int getNbWash() {
		return nbWash;
	}

	public void setNbWash(int nbWash) {
		this.nbWash = nbWash;
	}

	@OneToMany
	public List<Disponibility> getDisponibilities() {
		if (disponibilities == null) {
			disponibilities = new ArrayList<Disponibility>();
		}
		return disponibilities;
	}

	public void setDisponibilities(List<Disponibility> disponibilities) {
		this.disponibilities = disponibilities;
	}

	@Column(name="PREFERED_POS_A",nullable=false)
	@Enumerated(EnumType.STRING)
	public PlayerType getPreferredPositionA() {
		if (preferredPositionA == null) {
			preferredPositionA = PlayerType.NONE;
		}
		return preferredPositionA;
	}

	public void setPreferredPositionA(PlayerType preferredPositionA) {
		this.preferredPositionA = preferredPositionA;
	}

	@Column(name="PREFERED_POS_B",nullable=false)
	@Enumerated(EnumType.STRING)
	public PlayerType getPreferredPositionB() {
		if (preferredPositionB == null) {
			preferredPositionB = PlayerType.NONE;
		}
		return preferredPositionB;
	}

	public void setPreferredPositionB(PlayerType preferredPositionB) {
		this.preferredPositionB = preferredPositionB;
	}
}
