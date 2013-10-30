package com.perso.footcelad.core.model.championship;

import java.io.Serializable;

import com.perso.footcelad.core.model.enums.ResultType;


/**
 * 
 * @author ktf01464
 *
 */
public class Score implements Serializable {

	private Long id;
	private ResultType result;
	private int scoreTeamA;
	private int scoreTeamB;
	
	public Score() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ResultType getResult() {
		if (result == null) {
			return ResultType.NONE;
		}
		return result;
	}

	public void setResult(ResultType result) {
		this.result = result;
	}

	public int getScoreTeamA() {
		return scoreTeamA;
	}

	public void setScoreTeamA(int scoreTeamA) {
		this.scoreTeamA = scoreTeamA;
	}

	public int getScoreTeamB() {
		return scoreTeamB;
	}

	public void setScoreTeamB(int scoreTeamB) {
		this.scoreTeamB = scoreTeamB;
	}
	
	public String getScoreText() {
		return scoreTeamA + " - " + scoreTeamB;
	}
	
}
