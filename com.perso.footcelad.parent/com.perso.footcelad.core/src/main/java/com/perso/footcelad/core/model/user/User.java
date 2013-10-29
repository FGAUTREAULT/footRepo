package com.perso.footcelad.core.model.user;

import java.io.Serializable;

import javax.swing.ImageIcon;

/**
 * 
 * @author ktf01464
 * 
 */
public class User implements Serializable {

	private Long id;
	private String userFamilyName;
	private String userFirstName;
	private ImageIcon avatar;
	private String tel;
	private String mail;

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get the complete name, combination of first name and family name
	 */
	public String getUserName() {
		return getUserFirstName() + " " + getUserFamilyName();
	}

	/**
	 * Set the first name and the family name
	 * 
	 * @param firstName
	 * @param familyName
	 */
	public void setUserName(String firstName, String familyName) {
		this.userFirstName = firstName;
		this.userFamilyName = familyName;
	}

	public String getUserFamilyName() {
		return userFamilyName;
	}

	public void setUserFamilyName(String userFamilyName) {
		this.userFamilyName = userFamilyName;
	}

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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public boolean equals(Object obj) {
		return getUserName().equalsIgnoreCase(((User) obj).getUserName());
	}

	@Override
	public int hashCode() {
		return getUserName().hashCode();
	}

}
