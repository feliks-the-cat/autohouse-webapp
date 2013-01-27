package com.autohouse.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class GenericDAOImpl_VouchakIM<T> extends HibernateDaoSupport implements GenericDAO_VouchakIM<T>{
	private Class<T> type;
	
	public GenericDAOImpl_VouchakIM(Class<T> type) {
		this.type = type;
	}

	@Override
	public void saveOrUpdate(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
		getHibernateTemplate().flush();
	}

	@Override
	public void delete(Integer id) {
		T entity = getById(id);
		getHibernateTemplate().delete(entity);		
	}

	@Override
	public List<T> getList() {
		return  getHibernateTemplate().loadAll(type);
	}

	@Override
	public T getById(Integer id) {
		return getHibernateTemplate().get(type, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByParam(String param, String value) {
		String query = "from " + type.getName() + " c where c." + param + " = :temp";
		return getHibernateTemplate().findByNamedParam(
				query,
				"temp",
				value);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getByObject(String name, Object obj) {
		return getHibernateTemplate().findByCriteria(
				DetachedCriteria.forClass(type).add(
						Expression.eq(name, obj)));
	}
}