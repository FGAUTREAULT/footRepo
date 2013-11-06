package com.perso.footcelad.core.model.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.swing.ImageIcon;

/**
 * 
 * @author Fabien Gautreault
 * 
 *         The main character, contains profile information
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "userType", discriminatorType = DiscriminatorType.STRING)
public class User implements Serializable {

	/**
	 * Unique id
	 */
	private Long id;
	/**
	 * The family name of the user
	 */
	private String userFamilyName;
	/**
	 * The first name of the user
	 */
	private String userFirstName;
	/**
	 * The avatar of the player
	 */
	private ImageIcon avatar;
	/**
	 * The telephone of the player
	 */
	private String tel;
	/**
	 * The mail of the player, useful to contact or at least to send
	 * convocations
	 */
	private String mail;

	/**
	 * Default constructor
	 */
	public User() {
	}

	/**
	 * Minimum constructor for not nullable arguments
	 * @param familyName 	: the family name of the user
	 * @param firstName		: the first name of the user
	 * @param mail			: the mail of the user
	 */
	public User(String familyName, String firstName, String mail) {
		setUserFamilyName(familyName);
		setUserFirstName(firstName);
		setMail(mail);
	}

	// *********************************************** Getters and setters

	@Id
	@Column(name = "USER_ID", unique = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get the complete name, combination of first name and family name
	 */
	private String buildUserName() {
		return getUserFirstName() + " " + getUserFamilyName();
	}

	/**
	 * Set the first name and the family name
	 * 
	 * @param firstName
	 * @param familyName
	 */
	public void buidUserName(String firstName, String familyName) {
		this.userFirstName = firstName;
		this.userFamilyName = familyName;
	}

	@Column(name = "FAMILY_NAME", nullable = false)
	public String getUserFamilyName() {
		return userFamilyName;
	}

	public void setUserFamilyName(String userFamilyName) {
		this.userFamilyName = userFamilyName;
	}

	@Column(name = "FIRST_NAME", nullable = false)
	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public ImageIcon getAvatar() {
		return avatar;
	}

	public void setAvatar(ImageIcon avatar) {
		this.avatar = avatar;
	}

	@Column(name = "TEL")
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "MAIL", nullable = false)
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	// *********************************************** Hash code

	@Override
	public boolean equals(Object obj) {
		return buildUserName().equalsIgnoreCase(((User) obj).buildUserName());
	}

	@Override
	public int hashCode() {
		return buildUserName().hashCode();
	}

}
