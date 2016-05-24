package com.kknyrik.euro2016.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Katerina.Knyrik on 5/24/16.
 */
public class JpaDao<E, K extends Serializable> {

@PersistenceContext
protected EntityManager entityManager;
protected Class<? extends E> daoType;

public JpaDao() {
        daoType = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
        .getActualTypeArguments()[0];
        }

public void add(E entity) {
        entityManager.persist(entity);
        entityManager.flush();
        }


public E find(K key) {
        return (E) entityManager.find(daoType, key);
        }

public void update(E entity) {
        entityManager.merge(entity);
        }

public void remove(E entity) {
        entityManager.remove(entity);
        }

public List getAll(Class<E> entityClass) {
        Query query = entityManager.createQuery("from " + entityClass.getName());
        return query.getResultList();
        }
}
