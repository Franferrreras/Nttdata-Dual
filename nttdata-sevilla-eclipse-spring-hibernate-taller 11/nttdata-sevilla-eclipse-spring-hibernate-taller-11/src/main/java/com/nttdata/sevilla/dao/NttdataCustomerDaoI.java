package com.nttdata.sevilla.dao;

import java.util.List;

import com.nttdata.sevilla.model.NttdataCustomer;

public interface NttdataCustomerDaoI {

	/** METHODS SUSCEPTIBLE TO GENERIC DAO ***/
	/**
	 * Insert a customer in BBDD
	 * 
	 * @param newCustomer
	 */
	public void insert(NttdataCustomer newCustomer);

	/**
	 * Update a customer in BBDD
	 * 
	 * @param updatedCustomer
	 */
	public void update(NttdataCustomer updatedCustomer);

	/**
	 * Delete a customer in BBDD
	 * 
	 * @param deletedCustomer
	 */
	public void deleted(NttdataCustomer deletedCustomer);

	/**
	 * Locate a customer by Id
	 * 
	 * @param customerId
	 * @return NttdataCustomer
	 */
	public NttdataCustomer searchById(final Long customerId);

	/**
	 * Search for all customers
	 * 
	 * @return List<NttdataCustomer>
	 */
	public List<NttdataCustomer> getAllCustomer();

	/**
	 * Get a customer by full name
	 * 
	 * @param name
	 * @param firstName
	 * @param lastName
	 * @return List<NttdataCustomer>
	 */
	public List<NttdataCustomer> searchByCustomerFullname(final String name, final String firstName,
			final String lastName);
}
