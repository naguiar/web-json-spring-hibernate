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

import com.naguiar.catalog.model.Artist;
import com.naguiar.catalog.model.Genre;
import com.naguiar.catalog.service.ArtistService;
import com.naguiar.catalog.service.GenreService;

/**
 * @author naty
 *
 */
@RestController
public class ArtistRestController {

	@Autowired
	private ArtistService artistService;

	@Autowired
	private GenreService genreService;
	
	/**
	 * List Artists
	 * @return
	 */
	@RequestMapping(value = "/rest/artist", method = RequestMethod.GET)
	public List<Artist> listArtists() {
		return this.artistService.list();
	}
	
	/**
	 * List Genres
	 * @return
	 */
	@RequestMapping(value = "/rest/artist/genre", method = RequestMethod.GET)
	public List<Genre> listGenres() {
		return this.genreService.list();
	}

	/**
	 * Save
	 * @param artist
	 * @return
	 */
	@RequestMapping(value = "/rest/artist", method = RequestMethod.POST, headers = {"Content-type=application/json"})
	@ResponseBody
	public Artist saveArtist( @RequestBody Artist artist ) {
		
		return artistService.createOrUpdate(artist);
	}
}