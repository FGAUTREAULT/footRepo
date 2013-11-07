package com.perso.footcelad.core.model.enums;

/**
 * 
 * @author Fabien Gautreault
 * 
 */
public enum PlayerType {
	
	/**
	 * Player type haven't been set
	 */
	NONE, 
	
	/**
	 * Player attack and score
	 */
	ATTACK, 
	
	/**
	 * Player support attack and defense
	 */
	MIDDLE, 
	
	/**
	 * Player defend and support gate keeper
	 */
	DEFENSE, 
	
	/**
	 * Player defend the gate
	 */
	GATEKEEPER
}
