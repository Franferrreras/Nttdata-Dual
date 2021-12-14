package com.nttdata.sevilla.service;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.sevilla.dao.CustomerDaoI;
import com.nttdata.sevilla.dao.CustomerDaoImpl;
import com.nttdata.sevilla.model.Customer;

public class CustomerServiceImpl implements CustomerServiceI {

	private CustomerDaoI customerDao;

	
	public CustomerServiceImpl(final Session session) {
		this.customerDao = new CustomerDaoImpl(session);
		
	}

	@Override
	public void insertNewCustomer(Customer newCustomer) {

		// Verificacion de nulidad y existencia
		if (newCustomer != null && newCustomer.getCustomerID() == null) {

			customerDao.insert(newCustomer);
			
			System.out.println("New Customer added");
		}
	}

	@Override
	public void updateCustomer(Customer updatedCustomer) {

		// Verificacion de nulidad y existencia
		if (updatedCustomer != null && updatedCustomer.getCustomerID() == null) {

			customerDao.update(updatedCustomer);
		}
	}

	@Override
	public void deleteCustomer(Customer deletedCustomer) {

		// Verificacion de nulidad y existencia
		if (deletedCustomer != null && deletedCustomer.getCustomerID() == null) {

			customerDao.delete(deletedCustomer);
			
			System.out.println("Customer deleted");
		}

	}

	@Override
	public List<Customer> getAllCustomers() {
		
		List<Customer> listCustmer = customerDao.getList();
		
		return listCustmer;

	}

	@Override
	public Customer getCustomerById(int Id) {
		// TODO Auto-generated method stub
		Customer customer = customerDao.getCustomerById(Id);
		
		return customer;
	}

	@Override
	public List<Customer> getCustomerByNameBySurnames(String name, String firstName, String lastName) {
		// TODO Auto-generated method stub
		
		List<Customer> customerList = (List<Customer>) customerDao.searchCustomerByNameBySurnames(name, firstName, lastName);
		
		return customerList;
	}

	
	
	

}
