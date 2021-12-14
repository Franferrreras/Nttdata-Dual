package com.nttdata.sevilla.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer extends AbstractEntity implements Serializable {

	/** SERIAL **/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Integer customerID;

	@Column(name = "name")
	private String name;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "second_last_name")
	private String secondLastName;

	@Column(name = "dni", unique = true, nullable = false)
	private String dni;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
	private List<Contract> listContract;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSecondLastName() {
		return secondLastName;
	}

	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public List<Contract> getListContract() {
		return listContract;
	}

	public void setListContract(Contract contract) {
		this.listContract.add(contract);
	}

	@Override
	public String toString() {
		return "\n" +
				"customerID=" + customerID + "\n" 
				+ ", name=" + name + "\n" 
				+ ", lastName=" + lastName + "\n" 
				+ ", secondLastName=" + secondLastName + "\n" 
				+ ", dni=" + dni + "\n" 
				+ ", listContract=" + listContract + "\n" + "________________";
	}

	


}
