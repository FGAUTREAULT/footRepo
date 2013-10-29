/**
 * 
 */
package com.perso.footcelad.core.model.user;

import java.util.ArrayList;
import java.util.List;

import com.perso.footcelad.core.model.enums.PlayerType;


/**
 * @author ktf01464
 * 
 */
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PlayerType getPlayerType() {
		return playerType;
	}

	public void setPlayerType(PlayerType playerType) {
		this.playerType = playerType;
	}

	public int getNbGoal() {
		return nbGoal;
	}

	public void setNbGoal(int nbGoal) {
		this.nbGoal = nbGoal;
	}

	public int getNbPass() {
		return nbPass;
	}

	public void setNbPass(int nbPass) {
		this.nbPass = nbPass;
	}

	public int getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(int licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	public int getNbWash() {
		return nbWash;
	}

	public void setNbWash(int nbWash) {
		this.nbWash = nbWash;
	}

	public List<Disponibility> getDisponibilities() {
		if (disponibilities == null) {
			disponibilities = new ArrayList<Disponibility>();
		}
		return disponibilities;
	}

	public void setDisponibilities(List<Disponibility> disponibilities) {
		this.disponibilities = disponibilities;
	}

	public PlayerType getPreferredPositionA() {
		if (preferredPositionA == null) {
			preferredPositionA = PlayerType.NONE;
		}
		return preferredPositionA;
	}

	public void setPreferredPositionA(PlayerType preferredPositionA) {
		this.preferredPositionA = preferredPositionA;
	}

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
