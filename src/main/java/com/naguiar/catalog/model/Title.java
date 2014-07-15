/**
 * 
 */
package com.naguiar.catalog.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.naguiar.catalog.enums.Recording;

/**
 * @author naty
 *
 */
@Table(name="title")
@Entity
public class Title {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	@DateTimeFormat(pattern="yyyy")
	private Calendar year;
	
	@ManyToOne
	private Label label;
	
	@ManyToOne
	private Artist artist;
		
	@Enumerated(EnumType.STRING)
	private Recording recording;
	
	private String imageName;

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

	public Calendar getYear() {
		return year;
	}

	public void setYear(Calendar year) {
		this.year = year;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Recording getRecording() {
		return recording;
	}

	public void setRecording(Recording recording) {
		this.recording = recording;
	}

	public String getImageName() {
		return imageName;
	}
	
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
}
