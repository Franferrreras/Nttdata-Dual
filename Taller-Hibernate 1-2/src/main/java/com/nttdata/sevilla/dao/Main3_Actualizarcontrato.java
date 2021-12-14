package com.nttdata.sevilla.dao;


import java.util.Date;

import org.hibernate.Session;

import com.nttdata.sevilla.model.Contract;
import com.nttdata.sevilla.service.ContractServiceImpl;

public class Main3_Actualizarcontrato {

	public static void main(String[] args) {
		
		final Session session = HibernateUtil.getSessionFactory().openSession();

		
		session.beginTransaction();
		
		ContractServiceImpl contratoservice = new ContractServiceImpl(session);
	
		Contract contract = contratoservice.getContractById(1);
		
		contract.setPrice(223);
		
		session.update(contract);
		
		session.getTransaction().commit();
		session.close();
		
//		
//		final Session session2 = HibernateUtil.getSessionFactory().openSession();
//
//		session2.beginTransaction();
//		ContractServiceImpl contratoservice2 = new ContractServiceImpl(session2);
//		
//		System.out.println(contratoservice2.getContractById(1));
//		
//		session2.close();
	}
	
}
