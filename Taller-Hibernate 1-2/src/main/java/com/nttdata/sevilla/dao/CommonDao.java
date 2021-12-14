package com.nttdata.sevilla.dao;

import java.util.List;

import org.hibernate.Session;

public interface CommonDao<T> {

	public void insert(final T objecT);
	
	public void update(final T objecT);
	
	public void delete(final T objecT);
	
	public List<T> getList();
	
}
