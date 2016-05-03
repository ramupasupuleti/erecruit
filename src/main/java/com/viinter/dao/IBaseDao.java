package com.viinter.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;

public interface IBaseDao <T extends Object> {
	void create(T t);

	T get(Serializable id);

	T load(Serializable id);

	List<T> getAll();

	void update(T t);

	void delete(T t);

	void deleteById(Serializable id);

	void deleteAll();

	long count();

	boolean exists(Serializable id);

	void saveOrUpdate(T entityClass);
	
	Criteria getCriteria();
}
