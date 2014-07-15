/**
 * 
 */
package com.naguiar.catalog.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.naguiar.catalog.dao.GenreDAO;
import com.naguiar.catalog.model.Genre;

/**
 * @author naty
 *
 */
@Repository
public class GenreDAOImpl extends GenericDAOImpl<Genre, Integer> implements GenreDAO {

	/* (non-Javadoc)
	 * @see com.naguiar.catalog.dao.GenreDAO#list()
	 */
	@Override
	public List<Genre> list() {
		
		return this.entityManager().createQuery("SELECT g FROM Genre g").getResultList();
	}
}
