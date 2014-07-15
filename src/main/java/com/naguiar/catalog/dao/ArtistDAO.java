/**
 * 
 */
package com.naguiar.catalog.dao;

import java.util.List;

import com.naguiar.catalog.model.Artist;

/**
 * @author naty
 *
 */
public interface ArtistDAO extends GenericDAO<Artist, Integer> {

	/**
	 * List Artists
	 * @return
	 */
	List<Artist> list();

}
