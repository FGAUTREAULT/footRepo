package com.perso.footcelad.core.model.championship;

import java.io.Serializable;

import com.perso.footcelad.core.model.enums.ResultType;

/**
 *
 * @author Fabien Gautreault
 *
 *         The score give the amount of goal for each team and the type of
 *         result for the home team
 *
 *         TODO mapping
 */
@SuppressWarnings("serial")
public class Score implements Serializable {

	/**
	 * Unique id
	 */
	private Long id;
	/**
	 * Type of result for the home team
	 */
	private ResultType result;
	/**
	 * Number of goals of home team
	 */
	private int scoreHomeTeam;
	/**
	 * Number of goals of guest team
	 */
	private int scoreGuestTeam;

	/**
	 * Default constructor
	 */
	public Score() {
	}

	// *********************************************** Getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ResultType getResult() {
		if (result == null)
			return ResultType.NONE;
		return result;
	}

	public void setResult(ResultType result) {
		this.result = result;
	}

	public int getScoreHomeTeam() {
		return scoreHomeTeam;
	}

	public void setScoreHomeTeam(int scoreHomeTeam) {
		this.scoreHomeTeam = scoreHomeTeam;
	}

	public int getScoreGuestTeam() {
		return scoreGuestTeam;
	}

	public void setScoreGuestTeam(int scoreGuestTeam) {
		this.scoreGuestTeam = scoreGuestTeam;
	}

	public String getScoreText() {
		return scoreHomeTeam + " - " + scoreGuestTeam;
	}

}
