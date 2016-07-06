package com.kknyrik.euro2016.dao;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Transactional
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
        entityManager.remove(entityManager.merge(entity));
    }

    public List getAll(Class<E> entityClass) {
        Query query = entityManager.createQuery("from " + entityClass.getName());
        return query.getResultList();
    }
}
