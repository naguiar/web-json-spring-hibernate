/**
 * 
 */
package com.naguiar.catalog.service;

import java.util.List;

import com.naguiar.catalog.model.Label;

/**
 * @author naty
 *
 */
public interface LabelService {
	
	/**
	 * Create or update
	 * @param label
	 * @return
	 */
	Label createOrUpdate(Label label);

	/**
	 * Find
	 * @param id
	 * @return
	 */
	Label find(Integer id);

	/**
	 * List
	 * @return
	 */
	List<Label> list();

}
