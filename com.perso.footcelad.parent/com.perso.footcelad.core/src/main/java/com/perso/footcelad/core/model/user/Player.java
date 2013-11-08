/**
 *
 */
package com.perso.footcelad.core.model.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import com.perso.footcelad.core.model.enums.PlayerType;

/**
 * @author Fabien Gautreault
 *
 *         A player is a user with following privileges:
 *
 *         - Access to his profile,
 *
 *         - Write disponibility,
 *
 *         - No access to manager part.
 *
 */
/**
 * @author KT006837
 *
 */
@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("Player")
public class Player extends User {

	/**
	 * The type of player, either attack, defense, etc. (can be calculated or
	 * updated by the manager)
	 */
	private PlayerType playerType;
	/**
	 * Number of goal during championship, updated by manager
	 */
	private int nbGoal;
	/**
	 * Number of pass during championship, updated by manager
	 */
	private int nbPass;
	/**
	 * Licence number, updated by manager
	 */
	private int licenceNumber;
	/**
	 * Number of wash during championship, updated by manager
	 */
	private int nbWash;

	// ******* Profile part
	/**
	 * Disponibilities for the games
	 */
	private Set<Disponibility> disponibilities;
	/**
	 * The type of player the participant want to be
	 */
	private PlayerType preferredPositionA;
	/**
	 * The type of player the participant want to be
	 */
	private PlayerType preferredPositionB;

	/**
	 * Default constructor
	 *
	 * All parameter can be null, easier to manage the begining of the
	 * championship Part of the information are profile one, or will be updated
	 * by the manager after each game
	 */
	public Player() {
	}

	/**
	 * Minimum constructor for not nullable arguments
	 *
	 * @param familyName
	 *            : the family name of the user
	 * @param firstName
	 *            : the first name of the user
	 * @param mail
	 *            : the mail of the user
	 */
	public Player(String familyName, String firstName, String mail) {
		setUserFamilyName(familyName);
		setUserFirstName(firstName);
		setMail(mail);
	}

	// *********************************************** Getters and setters

	@Column(name = "PLAYER_TYPE", nullable = false)
	@Enumerated(EnumType.STRING)
	public PlayerType getPlayerType() {
		if (playerType == null) {
			playerType = PlayerType.NONE;
		}
		return playerType;
	}

	public void setPlayerType(PlayerType playerType) {
		this.playerType = playerType;
	}

	@Column(name = "NB_GOAL")
	public int getNbGoal() {
		return nbGoal;
	}

	public void setNbGoal(int nbGoal) {
		this.nbGoal = nbGoal;
	}

	@Column(name = "NB_PASS")
	public int getNbPass() {
		return nbPass;
	}

	public void setNbPass(int nbPass) {
		this.nbPass = nbPass;
	}

	@Column(name = "LICENCE_NUMBER")
	public int getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(int licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	@Column(name = "NB_WASH")
	public int getNbWash() {
		return nbWash;
	}

	public void setNbWash(int nbWash) {
		this.nbWash = nbWash;
	}

	@OneToMany
	public Set<Disponibility> getDisponibilities() {
		if (disponibilities == null) {
			disponibilities = new HashSet<Disponibility>();
		}
		return disponibilities;
	}

	public void setDisponibilities(Set<Disponibility> disponibilities) {
		this.disponibilities = disponibilities;
	}

	@Column(name = "PREFERED_POS_A", nullable = false)
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

	@Column(name = "PREFERED_POS_B", nullable = false)
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
