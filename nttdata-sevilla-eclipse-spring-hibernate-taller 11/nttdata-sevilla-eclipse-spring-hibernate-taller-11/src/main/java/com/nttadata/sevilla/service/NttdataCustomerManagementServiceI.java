package com.nttadata.sevilla.service;

import java.util.List;

import com.nttdata.sevilla.model.NttdataCustomer;

/**
 * Formación - Hibernate - Spring - Taller 1
 * 
 * Interface customer service
 * 
 * @author fran
 *
 */
public interface NttdataCustomerManagementServiceI {

	public void insertNewCustomer(final NttdataCustomer newCustomer);

	public void updateCustomer(final NttdataCustomer updatedCustomer);

	public void delteCustomer(final NttdataCustomer deletedCustomer);

	public NttdataCustomer searchById(final Long customerId);

	public List<NttdataCustomer> searchByFullName(final String name, final String firstName, final String lastName);

	public List<NttdataCustomer> getAllCustomers();
}
