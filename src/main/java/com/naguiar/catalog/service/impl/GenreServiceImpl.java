/**
 * 
 */
package com.naguiar.catalog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naguiar.catalog.dao.GenreDAO;
import com.naguiar.catalog.model.Genre;
import com.naguiar.catalog.service.GenreService;

/**
 * @author naty
 *
 */
@Service("genreService")
public class GenreServiceImpl implements GenreService {

	@Autowired
	private GenreDAO genreDAO;
	
	/* (non-Javadoc)
	 * @see com.naguiar.catalog.service.GenreService#createOrUpdate(com.naguiar.catalog.model.Genre)
	 */
	@Override
	public Genre createOrUpdate(Genre genre) {
		
		if (genre.getId() == null) {
			return genreDAO.create(genre);
		} else {
			return genreDAO.update(genre);
		}
	}

	/* (non-Javadoc)
	 * @see com.naguiar.catalog.service.GenreService#find(java.lang.Integer)
	 */
	@Override
	public Genre find(Integer id) {
		
		return genreDAO.find(id);
	}

	/* (non-Javadoc)
	 * @see com.naguiar.catalog.service.GenreService#list()
	 */
	@Override
	public List<Genre> list() {
		
		return genreDAO.list();
	}
}
