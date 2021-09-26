package com.kruger.ec.service;

import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface GenericService<T, V> {

	T create(T obj);

	List<T> findAll();

	T findById(V id);

	T update(T obj) throws InvocationTargetException, IllegalAccessException;

	boolean delete(V id);
}
