/**
 *
 */
package com.naguiar.catalog.dao;

import javax.persistence.EntityManager;


/**
 * @author naty
 * 
 */
public interface GenericDAO<T, ID> {

	/**
	 * EntityManager
	 * @return
	 */
	EntityManager entityManager();

	/**
	 * Generic create
	 * @param t
	 * @return
	 */
	T create(T t);

	/**
	 * Generic delete
	 * @param id
	 */
	void delete(ID id);

	/**
	 * Generic find
	 * @param id
	 * @return
	 */
	T find(ID id);

	/**
	 * Generic update
	 * @param t
	 * @return
	 */
	T update(T t);
}