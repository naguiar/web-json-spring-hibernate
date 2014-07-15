/**
 * 
 */
package com.naguiar.catalog.dao;

import java.util.List;

import com.naguiar.catalog.model.Genre;

/**
 * @author naty
 *
 */
public interface GenreDAO extends GenericDAO<Genre, Integer> {
	
	/**
	 * List Genres
	 * @return
	 */
	List<Genre> list();

}
