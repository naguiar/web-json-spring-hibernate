/**
 * 
 */
package com.naguiar.catalog.dao;

import java.util.List;

import com.naguiar.catalog.model.Label;

/**
 * @author naty
 *
 */
public interface LabelDAO extends GenericDAO<Label, Integer> {
	
	/**
	 * List Labels
	 * @return
	 */
	List<Label> list();

}
