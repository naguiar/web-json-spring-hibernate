/**
 * 
 */
package com.naguiar.catalog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naguiar.catalog.dao.TitleDAO;
import com.naguiar.catalog.model.Title;
import com.naguiar.catalog.service.TitleService;

/**
 * @author naty
 *
 */
@Service("titleService")
public class TitleServiceImpl implements TitleService {
	
	@Autowired
	private TitleDAO titleDAO;
	
	/* (non-Javadoc)
	 * @see com.naguiar.catalog.service.TitleService#createOrUpdate(com.naguiar.catalog.model.Title)
	 */
	@Override
	public Title createOrUpdate(Title title) {
		if (title.getId() == null) {
			return titleDAO.create(title);
		} else {
			return titleDAO.update(title);
		}
	}

	/* (non-Javadoc)
	 * @see com.naguiar.catalog.service.TitleService#find(java.lang.Integer)
	 */
	@Override
	public Title find(Integer id) {
		
		return titleDAO.find(id);
	}

	/* (non-Javadoc)
	 * @see com.naguiar.catalog.service.TitleService#list()
	 */
	@Override
	public List<Title> list() {
		
		return titleDAO.list();
	}
}
