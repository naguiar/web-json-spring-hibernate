/**
 * 
 */
package com.naguiar.catalog.service;

import java.util.List;

import com.naguiar.catalog.model.Genre;

/**
 * @author naty
 *
 */
public interface GenreService {
	
	/**
	 * Create or update
	 * @param genre
	 * @return
	 */
	Genre createOrUpdate(Genre genre);

	/**
	 * Find
	 * @param id
	 * @return
	 */
	Genre find(Integer id);

	/**
	 * List
	 * @return
	 */
	List<Genre> list();

}
