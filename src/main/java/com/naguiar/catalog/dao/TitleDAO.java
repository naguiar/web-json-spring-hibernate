/**
 * 
 */
package com.naguiar.catalog.dao;

import java.util.List;

import com.naguiar.catalog.model.Title;

/**
 * @author naty
 *
 */
public interface TitleDAO extends GenericDAO<Title, Integer> {

	/**
	 * List Titles
	 * @return
	 */
	List<Title> list();
}
