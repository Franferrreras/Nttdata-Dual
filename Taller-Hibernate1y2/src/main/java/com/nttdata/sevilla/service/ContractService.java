package com.nttdata.sevilla.service;

import java.util.List;

import com.nttdata.sevilla.model.Contract;

public interface ContractService {

	public void insertNewContract(final Contract newContract);
	public void updateContract(final Contract updatedContract);
	public void deleteContract(final Contract delteContract);
	public List<Contract> getlistContracts();
	public List<Contract> getContractsByCustomerId(final int customerId);
	public Contract getContractById(final int id);
}
