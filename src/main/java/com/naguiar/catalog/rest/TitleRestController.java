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
import com.naguiar.catalog.model.Title;
import com.naguiar.catalog.model.Label;
import com.naguiar.catalog.service.ArtistService;
import com.naguiar.catalog.service.TitleService;
import com.naguiar.catalog.service.LabelService;

/**
 * @author naty
 *
 */
@RestController
public class TitleRestController {

	@Autowired
	private TitleService titleService;

	@Autowired
	private LabelService labelService;
	
	@Autowired
	private ArtistService artistService;
	
	/**
	 * List Titles
	 * @return
	 */
	@RequestMapping(value = "/rest/title", method = RequestMethod.GET)
	public List<Title> listTitles() {
		return this.titleService.list();
	}
	
	/**
	 * List Labels
	 * @return
	 */
	@RequestMapping(value = "/rest/title/labels", method = RequestMethod.GET)
	public List<Label> listLabels() {
		return this.labelService.list();
	}
	
	/**
	 * List Artists
	 * @return
	 */
	@RequestMapping(value = "/rest/title/artists", method = RequestMethod.GET)
	public List<Artist> listArtists() {
		return this.artistService.list();
	}

	/**
	 * Save
	 * @param title
	 * @return
	 */
	@RequestMapping(value = "/rest/title", method = RequestMethod.POST, headers = {"Content-type=application/json"})
	@ResponseBody
	public Title saveTitle( @RequestBody Title title ) {
		
		return titleService.createOrUpdate(title);
	}
}