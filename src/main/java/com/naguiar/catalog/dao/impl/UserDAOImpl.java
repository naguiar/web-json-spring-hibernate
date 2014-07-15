/**
 * 
 */
package com.naguiar.catalog.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.naguiar.catalog.dao.UserDAO;
import com.naguiar.catalog.model.User;

/**
 * @author naty
 * 
 */
@Repository
public class UserDAOImpl extends GenericDAOImpl<User, Integer> implements UserDAO {
	
	/* (non-Javadoc)
	 * @see com.naguiar.catalog.dao.UserDAO#login(com.naguiar.catalog.model.User)
	 */
	@Override
	public User login(User user) {
		
		Query query = entityManager().createQuery("FROM User u WHERE u.username = :pUsername AND u.password = :pPassword");
		query.setParameter("pUsername", user.getUsername());
		query.setParameter("pPassword", user.getPassword());
		
		if(!query.getResultList().isEmpty() && query.getResultList().size() == 1){
			return (User) query.getResultList().get(0);
		} else {
			return null;
		}
	}
}