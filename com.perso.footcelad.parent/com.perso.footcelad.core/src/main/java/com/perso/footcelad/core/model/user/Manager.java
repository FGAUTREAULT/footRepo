/**
 * 
 */
package com.perso.footcelad.core.model.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Fabien Gautreault
 * 
 *         TODO add manager side (Carreful : manager can be a player...)
 * 
 *         A manager is a user with following privileges:
 * 
 *         - Convoke player,
 *         
 *         - Manage score,
 *         
 *         - Manage money, stuff, licences, championship info,
 *         
 *         - Update player stats,
 * 
 */
@Entity
@DiscriminatorValue("Manager")
public class Manager extends User {

	/**
	 * Default constructor
	 */
	public Manager() {
	}

}
