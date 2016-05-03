package com.viinter.dao;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;

public abstract class  AbstractDao<T extends Object> implements IBaseDao<T> {

	
	private Class<T> domainClass;
	
	EntityManager entityManager;
	
	@Autowired
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Session getSession(){
		return entityManager.unwrap(Session.class);
	}

	@SuppressWarnings("unchecked")
	private Class<T> getDomainClass() {
		if (domainClass == null) {
			ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
			this.domainClass = (Class<T>) thisType.getActualTypeArguments()[0];
		}
		return domainClass;
	}

	private String getDomainClassName() {
		return getDomainClass().getName();
	}

	public void create(T t) {

		Method createdOnMethod = ReflectionUtils.findMethod(getDomainClass(), "setCreatedOn", new Class[] { Date.class });
		if (createdOnMethod != null) {
			try {
				createdOnMethod.invoke(t, new Date());
			} catch (Exception e) {
			}
		}
		Method method = ReflectionUtils.findMethod(getDomainClass(), "setLastUpdateOn", new Class[] { Date.class });
		if (method != null) {
			try {
				method.invoke(t, new Date());
			} catch (Exception e) {
			}
		}


		getSession().save(t);
	}

	@SuppressWarnings("unchecked")
	public T get(Serializable id) {
		return (T) getSession().get(getDomainClass(), id);
	}

	@SuppressWarnings({ "unchecked" })
	public T load(Serializable id) {
		return (T) getSession().load(getDomainClass(), id);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return getSession().createQuery("from " + getDomainClassName()).list();
	}

	public void update(T t) {
		getSession().update(t);
	}

	public void delete(T t) {
		getSession().delete(t);
	}

	public void deleteById(Serializable id) {
		delete(load(id));
	}

	public void deleteAll() {
		getSession().createQuery("delete " + getDomainClassName()).executeUpdate();
	}

	public long count() {
		return (Long) getSession().createQuery("select count(*) from " + getDomainClassName()).uniqueResult();
	}

	public boolean exists(Serializable id) {
		return (get(id) != null);
	}
	
	@Override
	public void saveOrUpdate(T entityClass) {
		Method createdOnMethod = ReflectionUtils.findMethod(getDomainClass(), "setCreatedOn", new Class[] { Date.class });
		if (createdOnMethod != null) {
			try {
				createdOnMethod.invoke(entityClass, new Date());
			} catch (Exception e) {
			}
		}
		Method method = ReflectionUtils.findMethod(getDomainClass(), "setLastUpdateOn", new Class[] { Date.class });
		if (method != null) {
			try {
				method.invoke(entityClass, new Date());
			} catch (Exception e) {
			}
		}
		getSession().saveOrUpdate(entityClass);
	}
	
	@Override
	public Criteria getCriteria(){
		return getSession().createCriteria(getDomainClass());
	}

}
