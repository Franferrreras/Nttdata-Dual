package com.nttdata.sevilla.dao;

import java.util.ArrayList;
import java.util.List;

import com.nttdata.sevilla.model.Contract;

public interface ContractDaoI extends CommonDao<Contract>{

	public List<Contract> getlistContractByCustomerId(final int Id);
	
	public Contract getContractById(final int Id);
	
}
