/**
 * 
 */
package com.naguiar.catalog.dao;

import com.naguiar.catalog.model.User;

/**
 * @author naty
 * 
 */
public interface UserDAO {
	
	/**
	 * Login
	 * @param user
	 * @return
	 */
	User login(User user);

}
