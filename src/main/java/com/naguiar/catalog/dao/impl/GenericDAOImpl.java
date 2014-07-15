/**
 * 
 */
package com.naguiar.catalog.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import com.naguiar.catalog.dao.GenericDAO;

public abstract class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private EntityManagerFactory entityManagerFactory;

	private Class<T> type;

	/**
	 * Constructor
	 */
	public GenericDAOImpl() {
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * EntityManagerFactory
	 * @param emf
	 */
	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.entityManagerFactory = emf;
	}

	/* (non-Javadoc)
	 * @see com.naguiar.catalog.dao.GenericDAO#entityManager()
	 */
	@Override
	public EntityManager entityManager() {
		return this.entityManagerFactory.createEntityManager();
	}

	/* (non-Javadoc)
	 * @see com.naguiar.catalog.dao.GenericDAO#create(java.lang.Object)
	 */
	@Override
	public T create(T t) {
		EntityManager em = entityManager();
		EntityTransaction transaction = null;
		try {
		    transaction = em.getTransaction();
		    transaction.begin();

		    em.persist(t);
		    transaction.commit();
		    
		    return t;
		}
		catch (RuntimeException e) {
		    if ( transaction != null && transaction.isActive() ) transaction.rollback();
		    throw e;
		}
		finally {
		    em.close();
		}
	}

	/* (non-Javadoc)
	 * @see com.naguiar.catalog.dao.GenericDAO#delete(java.lang.Object)
	 */
	@Override
	public void delete(ID id) {

		EntityManager em = entityManager();
		em.remove(em.getReference(type, id));
	}

	/* (non-Javadoc)
	 * @see com.naguiar.catalog.dao.GenericDAO#find(java.lang.Object)
	 */
	@Override
	public T find(ID id) {
		EntityManager em = entityManager();
		try {
			return (T) this.entityManager().find(type, id);
		} finally {
			em.close();
		}
	}

	/* (non-Javadoc)
	 * @see com.naguiar.catalog.dao.GenericDAO#update(java.lang.Object)
	 */
	@Override
	public T update(T t) {
		EntityManager em = entityManager();
		EntityTransaction transaction = null;
		try {
		    transaction = em.getTransaction();
		    transaction.begin();

		    em.merge(t);
		    transaction.commit();
		    
		    return t;
		}
		catch (RuntimeException e) {
		    if ( transaction != null && transaction.isActive() ) transaction.rollback();
		    throw e;
		}
		finally {
		    em.close();
		}
	}
}