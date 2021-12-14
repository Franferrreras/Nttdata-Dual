package com.nttdata.sevilla.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.sevilla.model.Contract;

public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI{

	private Session session;
	
	public ContractDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public List<Contract> getlistContractByCustomerId(final int Id) {
		
		//Comprobacion de nulalidad
		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		
		List<Contract> list = session.createQuery("FROM Contract WHERE customer_id = " + Id).list();
		
		return list;
	}

	@Override
	public Contract getContractById(int Id) {
		
		//Comprobacion de nulalidad
		if (!session.getTransaction().isActive()) {
			session.beginTransaction();
		}
		
		Contract contract = session.get(Contract.class, Id);
		
		return contract;
	}

}
