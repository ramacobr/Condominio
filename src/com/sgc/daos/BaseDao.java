package com.sgc.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.sgc.models.IEntity;

@Stateless
public abstract class BaseDao<T extends IEntity>  {

	@PersistenceContext
	protected EntityManager em;
	
	private Class<T> entityClass;
	
	public BaseDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public T findById(Long id) {
		return em.find(entityClass, id);
	}
	
	public T save(T obj) {
		try {
			/*
			 * Quando utilizando o JTA não é possível controlar a transação
			 */
			//em.getTransaction().begin();
			if(obj.getId() > 0) {
				Object objFounded = em.find(obj.getClass(), obj.getId());
				if (objFounded != null) {
					em.merge(obj);
				}
			} else {
				em.persist(obj);
			}
			//em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}		
		return obj;
	}

	public void remove(T obj) {

		try {
			em.getTransaction().begin();
			em.merge(obj);
			em.remove(obj);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		}		
	}
	
	public int Count() {
		CriteriaQuery<Object> criteria = em.getCriteriaBuilder().createQuery();
		Root<T> rt = criteria.from(entityClass);
		criteria.select(em.getCriteriaBuilder().count(rt));
		Query query = em.createQuery(criteria);
		return ((Long)query.getSingleResult()).intValue();
	}

	@SuppressWarnings("unchecked")
	public List<T> ListAll() {
		CriteriaQuery<Object> criteria = em.getCriteriaBuilder().createQuery();
		criteria.select(criteria.from(entityClass));
		return (List<T>) em.createQuery(criteria).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findRange(int[] range) {
		CriteriaQuery<Object> cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		Query q = em.createQuery(cq);
		q.setMaxResults(range[1] - range[0]);
		q.setFirstResult(range[0]);
		return (List<T>)q.getResultList();
	}
}
