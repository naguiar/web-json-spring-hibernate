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
@Table(name="label")
@Entity
public class Label {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable=false)
	private String name;

	private String website;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}	
}
