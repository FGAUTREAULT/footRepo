/**
 * 
 */
package com.perso.footcelad.core.model.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author ktf01464
 * 
 */
@Entity
@DiscriminatorValue("Manager")
public class Manager extends User {

	public Manager() {
	}
	
}
