/**
 * 
 */
package com.naguiar.catalog.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.naguiar.catalog.dao.LabelDAO;
import com.naguiar.catalog.model.Label;

/**
 * @author naty
 *
 */
@Repository
public class LabelDAOImpl extends GenericDAOImpl<Label, Integer> implements LabelDAO {
	
	/* (non-Javadoc)
	 * @see com.naguiar.catalog.dao.LabelDAO#list()
	 */
	@Override
	public List<Label> list() {
		
		return this.entityManager().createQuery("SELECT l FROM Label l").getResultList();
	}
	
}
