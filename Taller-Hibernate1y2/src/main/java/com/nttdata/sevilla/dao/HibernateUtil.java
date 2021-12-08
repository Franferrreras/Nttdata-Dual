package com.nttdata.sevilla.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory SESSION_FACTORY;
	
	
	static {
		try {
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
		} catch (final Throwable e) {
			System.out.println("error, Configuracion de Hibernate - " + e);
			throw new ExceptionInInitializerError();
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
}
