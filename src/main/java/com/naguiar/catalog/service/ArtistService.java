/**
 * 
 */
package com.naguiar.catalog.service;

import java.util.List;

import com.naguiar.catalog.model.Artist;

/**
 * @author naty
 *
 */
public interface ArtistService {
	
	/**
	 * Create or update
	 * @param artist
	 * @return
	 */
	Artist createOrUpdate(Artist artist);

	/**
	 * Find
	 * @param id
	 * @return
	 */
	Artist find(Integer id);

	
	/**
	 * List
	 * @return
	 */
	List<Artist> list();

}
