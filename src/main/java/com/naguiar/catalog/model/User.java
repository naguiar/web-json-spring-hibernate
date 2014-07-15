/**
 * 
 */
package com.naguiar.catalog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author naty
 *
 */
@Table(name="user")
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable=false)
	private String username;
	
	@Column(nullable=false)
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
