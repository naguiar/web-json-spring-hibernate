/**
 * 
 */
package com.naguiar.catalog.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.naguiar.catalog.dao.ArtistDAO;
import com.naguiar.catalog.model.Artist;

/**
 * @author naty
 *
 */
@Repository
public class ArtistDAOImpl extends GenericDAOImpl<Artist, Integer> implements ArtistDAO {

	/* (non-Javadoc)
	 * @see com.naguiar.catalog.dao.ArtistDAO#list()
	 */
	@Override
	public List<Artist> list() {
		
		return this.entityManager().createQuery("SELECT a FROM Artist a").getResultList();
	}
}
