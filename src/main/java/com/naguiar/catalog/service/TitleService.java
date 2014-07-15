/**
 * 
 */
package com.naguiar.catalog.service;

import java.util.List;

import com.naguiar.catalog.model.Title;

/**
 * @author naty
 *
 */
public interface TitleService {

	/**
	 * Create or update
	 * @param title
	 * @return
	 */
	Title createOrUpdate(Title title);
	
	/**
	 * Find
	 * @param id
	 * @return
	 */
	Title find(Integer id);

	/**
	 * List
	 * @return
	 */
	List<Title> list();
		
}
