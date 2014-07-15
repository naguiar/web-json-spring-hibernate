/**
 * 
 */
package com.naguiar.catalog.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.naguiar.catalog.model.Genre;
import com.naguiar.catalog.service.GenreService;

/**
 * @author naty
 *
 */
@RestController
@RequestMapping("/rest/genre")
public class GenreRestController {

	@Autowired
	private GenreService genreService;

	/**
	 * List Genres
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Genre> listGenres() {
		return this.genreService.list();
	}
	
	/**
	 * Save
	 * @param genre
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, headers = {"Content-type=application/json"})
	@ResponseBody
	public Genre saveGenre( @RequestBody Genre genre ) {
		return genreService.createOrUpdate(genre);
	}
}