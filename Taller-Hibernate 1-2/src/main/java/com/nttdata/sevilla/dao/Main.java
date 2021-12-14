package com.nttdata.sevilla.dao;


import java.util.Date;

import org.hibernate.Session;

import com.nttdata.sevilla.model.Contract;
import com.nttdata.sevilla.model.Customer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			
			Customer customer = new Customer();
			Contract contrato = new Contract();
			
			session.getTransaction().begin();
			
//			customer.setCustomerID(1);
//			customer.setName("Fran");
//			customer.setLastName("Ferreras");
//			customer.setSecondLastName("Farinas");
//			customer.setDni("21153854H");
//			customer.setListContract(contrato);
//			
			contrato.setContractID(1);
			contrato.setCustomer(customer);
			contrato.setFechaV(new Date());
			contrato.setFechaC(new Date());
			contrato.setPrice(20.00);
			
			
//			session.save(customer);
			session.save(contrato);
			session.getTransaction().commit();
						
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
//		commondao.insert(commondao);
//		commondao.insert(customer);
		
		
	}

}
