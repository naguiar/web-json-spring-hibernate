/**
 * 
 */
package com.naguiar.catalog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author naty
 *
 */
@Controller
public class AdminController {

	/**
	 * Home page
	 * @return
	 */
	@RequestMapping("/homepage")
	public String homePage() {
		return "home/home";
	}
	
	/**
	 * List Labels
	 * @return
	 */
	@RequestMapping("/listLabel")
	public String listLabel() {
		return "label/label";
	}
	
	/**
	 * List Genres
	 * @return
	 */
	@RequestMapping("/listGenre")
	public String listGenre() {
		return "genre/genre";
	}
	
	/**
	 * List Artists
	 * @return
	 */
	@RequestMapping("/listArtist")
	public String listArtist() {
		return "artist/artist";
	}
	
	/**
	 * List Titles
	 * @return
	 */
	@RequestMapping("/listTitle")
	public String listTitle() {
		return "title/title";
	}
}
