/**
 * 
 */
package com.naguiar.catalog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naguiar.catalog.dao.LabelDAO;
import com.naguiar.catalog.model.Label;
import com.naguiar.catalog.service.LabelService;

/**
 * @author naty
 *
 */
@Service("labelService")
public class LabelServiceImpl implements LabelService {
	
	@Autowired
	private LabelDAO labelDAO;
	
	/* (non-Javadoc)
	 * @see com.naguiar.catalog.service.LabelService#createOrUpdate(com.naguiar.catalog.model.Label)
	 */
	@Override
	public Label createOrUpdate(Label label) {
		
		if (label.getId() == null) {
			return labelDAO.create(label);
		} else {
			return labelDAO.update(label);
		}
	}

	/* (non-Javadoc)
	 * @see com.naguiar.catalog.service.LabelService#find(java.lang.Integer)
	 */
	@Override
	public Label find(Integer id) {
		
		return labelDAO.find(id);
	}

	/* (non-Javadoc)
	 * @see com.naguiar.catalog.service.LabelService#list()
	 */
	@Override
	public List<Label> list() {
		
		return labelDAO.list();
	}
}
