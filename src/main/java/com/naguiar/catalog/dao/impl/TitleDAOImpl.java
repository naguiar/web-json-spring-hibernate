/**
 * 
 */
package com.naguiar.catalog.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.naguiar.catalog.dao.TitleDAO;
import com.naguiar.catalog.model.Title;

/**
 * @author naty
 *
 */
@Repository
public class TitleDAOImpl extends GenericDAOImpl<Title, Integer> implements TitleDAO {

	/* (non-Javadoc)
	 * @see com.naguiar.catalog.dao.TitleDAO#list()
	 */
	@Override
	public List<Title> list() {
		
		return this.entityManager().createQuery("SELECT t FROM Title t").getResultList();
	}
}
