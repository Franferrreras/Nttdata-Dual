package com.nttdata.sevilla.service;

import java.util.List;

import com.nttdata.sevilla.model.Customer;

public interface CustomerServiceI {

	public void insertNewCustomer(final Customer newCustomer);
	
	public void updateCustomer(final Customer updatedCustomer);
	
	public void deleteCustomer(final Customer deletedCustomer);
	
	public Customer getCustomerById(final int Id);
	
	public List<Customer> getAllCustomers();
	
	public List<Customer> getCustomerByNameBySurnames(final String name, final String firstName, final String lastName);
}
