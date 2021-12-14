package com.nttdata.sevilla.dao;

import java.util.List;

import com.nttdata.sevilla.model.Customer;

public interface CustomerDaoI extends CommonDao<Customer> {

	public Customer getCustomerById(final int Id);
	
	public List<Customer> searchCustomerByNameBySurnames(final String name, final String firstName, final String lastName);
}

