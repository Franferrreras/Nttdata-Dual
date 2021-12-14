package com.nttdata.sevilla.dao;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.sevilla.model.Customer;
import com.nttdata.sevilla.service.ContractServiceImpl;
import com.nttdata.sevilla.service.CustomerServiceI;
import com.nttdata.sevilla.service.CustomerServiceImpl;

public class Main2 {

	public static void main(String[] args) {

		final Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
//		Customer customer = new Customer();
//		customer.setDni("12345678L");
//		customer.setLastName("Hernandez");
//		customer.setName("Paul");
//		customer.setSecondLastName("Rodriguez");
		CustomerDaoImpl customerdao = new CustomerDaoImpl(session);

//		CustomerServiceImpl customerService = new CustomerServiceImpl(session);
//		
//		ContractServiceImpl contractService = new ContractServiceImpl(session);
//		System.out.println(contractService.getContractById(1));

		CustomerServiceImpl customerservice = new CustomerServiceImpl(session);

		List<Customer> customerList = customerservice.getAllCustomers();
		
		System.out.println(customerList);

		
		
		session.close();
		
//		final Session session2 = HibernateUtil.getSessionFactory().openSession();
//		session2.beginTransaction();
//		CustomerServiceImpl customerservice2 = new CustomerServiceImpl(session2);
//
//		customer.setName("Gonzalo");
//		customer.setLastName("Herrera");
//		
//		session2.update(customer);
//		
//		session2.getTransaction().commit();
//		session2.close();
//		
//		System.out.println(customer);

	}
}
