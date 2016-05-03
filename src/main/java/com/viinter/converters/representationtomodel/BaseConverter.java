package com.viinter.converters.representationtomodel;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;

public abstract class BaseConverter <S, T> implements Converter<S,T> {

	T factoryObject = null;

	public void setFactoryObject(T factoryObject) {
		this.factoryObject = factoryObject;
	}

	@Override
	public T convert(S source) {
		copyUtils(source, factoryObject);
		return factoryObject;
	}
	
	/**
	 * method to copy all properties
	 * @param source
	 * @param target
	 */

	public <V, U> void copyUtils(U source, V target) {
		BeanUtils.copyProperties(source, target);
	}
	
}

