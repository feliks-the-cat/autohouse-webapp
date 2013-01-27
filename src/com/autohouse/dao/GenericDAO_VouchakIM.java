package com.autohouse.dao;

import java.util.List;

public interface GenericDAO_VouchakIM <T> {
	void saveOrUpdate(T entity);
	void delete(Integer i);
	List<T> getList();
	T getById(Integer id);
	List<T> findByParam(String param, String value);
	List<T> getByObject(String name, Object obj);
}