/**
 * 
 */
package com.naguiar.catalog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naguiar.catalog.dao.ArtistDAO;
import com.naguiar.catalog.model.Artist;
import com.naguiar.catalog.service.ArtistService;

/**
 * @author naty
 *
 */
@Service("artistService")
public class ArtistServiceImpl implements ArtistService {
	
	@Autowired
	private ArtistDAO artistDAO;
	
	/* (non-Javadoc)
	 * @see com.naguiar.catalog.service.ArtistService#createOrUpdate(com.naguiar.catalog.model.Artist)
	 */
	@Override
	public Artist createOrUpdate(Artist artist) {
		if (artist.getId() == null) {
			return artistDAO.create(artist);
		} else {
			return artistDAO.update(artist);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.naguiar.catalog.service.ArtistService#find(java.lang.Integer)
	 */
	@Override
	public Artist find(Integer id) {

		return artistDAO.find(id);
	}

	/* (non-Javadoc)
	 * @see com.naguiar.catalog.service.ArtistService#list()
	 */
	@Override
	public List<Artist> list() {
		
		return artistDAO.list();
	}
}
