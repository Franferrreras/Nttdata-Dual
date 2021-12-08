package com.nttadata.sevilla.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.nttdata.sevilla.dao.NttdataCustomerDaoI;
import com.nttdata.sevilla.model.NttdataCustomer;

/**
 * Formación - Hibernate - Spring - Taller 1
 * 
 * Service customer implementation
 * 
 * @author fran
 *
 */
@Service
public class NttdataCustomerManegementServiceImpl implements NttdataCustomerManagementServiceI {

	@Autowired
	private NttdataCustomerDaoI customerDao;

	@Override
	@Transactional
	public void insertNewCustomer(NttdataCustomer newCustomer) {

		// Verification nulilty and existence
		if (newCustomer != null && newCustomer.getCustomerId() != null) {

			// Insert customer
			customerDao.insert(newCustomer);
		}

	}

	@Override
	@Transactional
	public void updateCustomer(NttdataCustomer updatedCustomer) {

		// Verification nulilty and existence
		if (updatedCustomer != null && updatedCustomer.getCustomerId() != null) {

			// Update customer
			customerDao.update(updatedCustomer);
		}
	}

	@Override
	@Transactional
	public void delteCustomer(NttdataCustomer deletedCustomer) {

		// Verification nulilty and existence
		if (deletedCustomer != null && deletedCustomer.getCustomerId() != null) {

			// Delete customer
			customerDao.deleted(deletedCustomer);

		}
	}

	@Override
	@Transactional
	public NttdataCustomer searchById(Long customerId) {

		// Customer
		NttdataCustomer customer = null;

		// Verification nulity
		if (customerId != null) {

			// Get customer
			customer = customerDao.searchById(customerId);
		}

		return customer;
	}

	@Override
	@Transactional
	public List<NttdataCustomer> searchByFullName(String name, String firstName, String lastName) {

		List<NttdataCustomer> customerList = null;
		if (StringUtils.hasText(name) && StringUtils.hasText(firstName) && StringUtils.hasText(lastName)) {

			customerList = customerDao.searchByCustomerFullname(name, firstName, lastName);

		}
		return customerList;
	}

	@Override
	@Transactional
	public List<NttdataCustomer> getAllCustomers() {

		// Get customers
		List<NttdataCustomer> customerList = customerDao.getAllCustomer();

		return customerList;
	}

}
