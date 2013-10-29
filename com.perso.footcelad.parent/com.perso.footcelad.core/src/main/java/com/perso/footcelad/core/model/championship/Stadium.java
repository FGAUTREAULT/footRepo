/**
 * 
 */
package com.perso.footcelad.core.model.championship;

import java.io.Serializable;

import com.perso.footcelad.core.model.enums.StadiumType;

/**
 * @author ktf01464
 * 
 */
public class Stadium implements Serializable {

	private Long id;
	private String stadiumName;
	private StadiumType stadiumType;
	private String adress;

	public Stadium() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStadiumName() {
		return stadiumName;
	}

	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}

	public StadiumType getStadiumType() {
		if(stadiumType == null) return StadiumType.UNKNOWN;
		return stadiumType;
	}

	public void setStadiumType(StadiumType stadiumType) {
		this.stadiumType = stadiumType;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Override
	public boolean equals(Object obj) {
		return stadiumName.equalsIgnoreCase(((Stadium) obj).getStadiumName());
	}

	@Override
	public int hashCode() {
		return stadiumName.hashCode();
	}

}
