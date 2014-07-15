/**
 * 
 */
package com.naguiar.catalog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naguiar.catalog.dao.UserDAO;
import com.naguiar.catalog.dao.impl.UserDAOImpl;
import com.naguiar.catalog.model.User;
import com.naguiar.catalog.service.LoginService;

/**
 * @author naty
 * 
 */
@Service("userService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserDAO userDAO = new UserDAOImpl();
	
	/*
	 * (non-Javadoc)
	 * @see com.naguiar.catalog.service.LoginService#login(com.naguiar.catalog.model.User)
	 */
	@Override
	public User login(User user) {
		
		return userDAO.login(user);
	}
}
