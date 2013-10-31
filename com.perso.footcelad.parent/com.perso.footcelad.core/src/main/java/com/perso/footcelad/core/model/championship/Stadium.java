/**
 * 
 */
package com.perso.footcelad.core.model.championship;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.groups.Default;

import com.perso.footcelad.core.model.enums.StadiumType;

/**
 * @author Fabien Gautreault
 * 
 *         The stadium is the place for people to play
 * 
 */
@Entity
public class Stadium implements Serializable {

	/**
	 * Unique id
	 */
	private Long id;
	/**
	 * Name of the place
	 */
	private String stadiumName;
	/**
	 * Type of stadium track
	 */
	private StadiumType stadiumType;
	/**
	 * Address of the stadium
	 */
	private String address;

	/**
	 * Default constructor
	 */
	public Stadium() {
	}

	/**
	 * Minimum constructor for not nullable arguments Stadium type is enum so
	 * not null, but don't forget to update it
	 * 
	 * @param stadiumName
	 *            : The name of the stadium
	 * @param address
	 *            : The address of the stadium
	 */
	public Stadium(String stadiumName, String address) {
		this(stadiumName, address, StadiumType.UNKNOWN);
	}

	/**
	 * Preffered constructor
	 * 
	 * @param stadiumName
	 *            : The name of the stadium
	 * @param address
	 *            : The address of the stadium
	 * @param stadiumType
	 *            : The type of the stadium track
	 */
	public Stadium(String stadiumName, String address, StadiumType stadiumType) {
		setStadiumName(stadiumName);
		setaddress(address);
		setStadiumType(stadiumType);
	}

	// *********************************************** Getters and setters

	@Id
	@Column(name = "STADIUM_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "STADIUM_NAME", nullable = false)
	public String getStadiumName() {
		return stadiumName;
	}

	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}

	@Column(name = "STADIUM_TYPE", nullable = false)
	@Enumerated(EnumType.STRING)
	public StadiumType getStadiumType() {
		if (stadiumType == null)
			return StadiumType.UNKNOWN;
		return stadiumType;
	}

	public void setStadiumType(StadiumType stadiumType) {
		this.stadiumType = stadiumType;
	}

	@Column(name = "STADIUM_ADDRESS", nullable = false)
	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	// *********************************************** Hash code

	@Override
	public boolean equals(Object obj) {
		return stadiumName.equalsIgnoreCase(((Stadium) obj).getStadiumName());
	}

	@Override
	public int hashCode() {
		return stadiumName.hashCode();
	}

}
