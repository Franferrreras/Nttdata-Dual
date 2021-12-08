package com.nttdata.sevilla.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nttdata.sevilla.model.NttdataCustomer;


/**
 * Formación - Hibernate - Spring - Taller 1
 * 
 * DAO table nttdata_customer
 * 
 * @author fran
 *
 */
@Repository
public class NttdataCustomerDaoImpl implements NttdataCustomerDaoI {

	/** Entity manager **/
	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public void insert(NttdataCustomer newCustomer) {

		// Get session
		Session session = entityManager.unwrap(Session.class);

		// Insertion
		session.save(newCustomer);

		// Close session
		session.close();

	}

	@Override
	@Transactional
	public void update(NttdataCustomer updatedCustomer) {

		// Get session
		Session session = entityManager.unwrap(Session.class);

		// Update customer
		session.update(updatedCustomer);

		// Close session
		session.close();

	}

	@Override
	@Transactional
	public void deleted(NttdataCustomer deletedCustomer) {

		// Get session
		Session session = entityManager.unwrap(Session.class);

		// Mergeo of states
		deletedCustomer = entityManager.merge(deletedCustomer);

		// Delete customer
		session.delete(deletedCustomer);

		// Close session
		session.close();

	}

	@Override
	@Transactional
	public NttdataCustomer searchById(Long customerId) {

		// Get session
		Session session = entityManager.unwrap(Session.class);

		// Get customer by Id
		NttdataCustomer customer = session.get(NttdataCustomer.class, customerId);

		// Close session
		session.close();

		return customer;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<NttdataCustomer> getAllCustomer() {

		// Get session
		Session session = entityManager.unwrap(Session.class);

		// Get all customer
		List<NttdataCustomer> customerList = session.createQuery("FROM NttdataCustomer").list();

		// Close session
		session.close();

		return customerList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NttdataCustomer> searchByCustomerFullname(String name, String firstName, String lastName) {

		// Get session
		Session session = entityManager.unwrap(Session.class);
		
		List<NttdataCustomer> customerList = session.createQuery("FROM NttdataCustomer WHERE name = '" + name + "' AND firstName = '" + firstName + "' AND lastName = '" + lastName + "'").list();
		
		// Close session
		session.close();
		
		return customerList;
	}

}
