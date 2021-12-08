package com.nttdata.sevilla.service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.sevilla.dao.ContractDaoI;
import com.nttdata.sevilla.dao.ContractDaoImpl;
import com.nttdata.sevilla.model.Contract;

public class ContractServiceImpl implements ContractService {

	private ContractDaoI contractDao;

	public ContractServiceImpl(final Session session) {

		this.contractDao = new ContractDaoImpl(session);
	}

	@Override
	public void insertNewContract(Contract newContract) {

		// Verificacion de nulidad y existencia
		if (newContract != null && newContract.getContractID() == null) {

			contractDao.insert(newContract);
		}

	}

	@Override
	public void updateContract(Contract updatedContract) {

		// Verificacion de nulidad y existencia
		if (updatedContract != null && updatedContract.getContractID() == null) {

			contractDao.update(updatedContract);
		}

	}

	@Override
	public void deleteContract(Contract delteContract) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Contract> getlistContracts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contract> getContractsByCustomerId(int customerId) {
		
		List<Contract> contractList = contractDao.getlistContractByCustomerId(customerId);
		return contractList;
	}

	@Override
	public Contract getContractById(int id) {
		
		Contract contract = contractDao.getContractById(id);

		return contract;
	}

}
