package com.perso.footcelad.core.model.enums;

/**
 * 
 * @author Fabien Gautreault
 * 
 *         Disponibilty type is usefull for manager to build a team for the game
 * 
 */
public enum DisponibilityType {
	/**
	 * Disponibility haven't been set
	 */
	NONE,

	/**
	 * Player is ready to play
	 */
	DISPONIBLE,

	/**
	 * Player cannot make it
	 */
	ABSENT,

	/**
	 * Player is injured
	 */
	INJURED
}
