/**
 * 
 */
package com.naguiar.catalog.service;

import com.naguiar.catalog.model.User;

/**
 * @author naty
 *
 */
public interface LoginService {
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	User login(User user);

}
