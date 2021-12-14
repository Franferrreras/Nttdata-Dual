package com.nttdata.sevilla.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.sevilla.model.Customer;

public class CustomerDaoImpl extends CommonDaoImpl<Customer> implements CustomerDaoI {

	private Session session;

	public CustomerDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public Customer getCustomerById(int Id) {

		//Comprobacion de nulalidad
		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}

		Customer customer = null;
		try {

			customer = session.get(Customer.class, Id);

			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return customer;
	}

	@Override
	public List<Customer> searchCustomerByNameBySurnames(final String name, final String firstName, final String lastName) {
		
		//Comprobacion de nulalidad
		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		List<Customer> customer = null;
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			customer = session.createQuery("FROM Customer").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Customer c : customer) {
			if (c.getName().equals(name) && c.getLastName().equals(firstName) || c.getSecondLastName().equals(lastName)) {
				
				customerList.add(c);
			}
		}

		return customerList;
	}

}
