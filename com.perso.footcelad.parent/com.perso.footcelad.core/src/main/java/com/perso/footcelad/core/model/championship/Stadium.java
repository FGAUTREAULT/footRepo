/**
 * 
 */
package com.perso.footcelad.core.model.championship;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.perso.footcelad.core.model.enums.StadiumType;

/**
 * @author ktf01464
 * 
 */
@Entity
public class Stadium implements Serializable {

	private Long id;
	private String stadiumName;
	private StadiumType stadiumType;
	private String address;

	public Stadium() {
	}

	@Id
	@Column(name="STADIUM_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="STADIUM_NAME", nullable=false)
	public String getStadiumName() {
		return stadiumName;
	}

	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}

	@Column(name="STADIUM_TYPE",nullable=false)
	@Enumerated(EnumType.STRING)
	public StadiumType getStadiumType() {
		if(stadiumType == null) return StadiumType.UNKNOWN;
		return stadiumType;
	}

	public void setStadiumType(StadiumType stadiumType) {
		this.stadiumType = stadiumType;
	}

	@Column(name="STADIUM_ADDRESS", nullable=false)
	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
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
