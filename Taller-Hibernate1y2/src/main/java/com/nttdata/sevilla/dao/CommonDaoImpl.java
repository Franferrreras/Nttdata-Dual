package com.nttdata.sevilla.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.sevilla.model.AbstractEntity;

public abstract class CommonDaoImpl<T extends AbstractEntity> implements CommonDao<T> {

	private Class<T> entityClass;

	private Session session;

	@SuppressWarnings("unchecked")
	public CommonDaoImpl(Session session) {
		super();
		setEntityClass(
				(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(final T objecT) {
		// TODO Auto-generated method stub
		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		session.save(objecT);
		session.flush();

		session.getTransaction().commit();
	}

	@Override
	public void update(final T objecT) {

		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}

		session.update(objecT);
		
		session.getTransaction().commit();
	}

	@Override
	public void delete(final T objecT) {
		
		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
	
		session.delete(objecT);
		
		session.getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getList() {

		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}

		// Búsqueda de todos los registros.
		List<T> list = session.createQuery("FROM " + this.entityClass.getName()).list();

		return list;

	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}
