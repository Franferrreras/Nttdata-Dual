package com.nttdata.sevilla.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "contract")
public class Contract extends AbstractEntity implements Serializable {

	/** SERIAL **/
	private static final long serialVersionUID = 1L;


	/** Identificador (PK)**/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contract_id")
	private Integer contractID = null;

	/** Validation date **/
	@Column(name = "fecha_validacion")
	@Temporal(TemporalType.DATE)
	private Date fechaV;

	/** Expiration date **/
	@Column(name = "fecha_caducidad")
	@Temporal(TemporalType.DATE)
	private Date fechaC;

	/** Price **/
	@Column(name = "price")
	private double price;

	/** Customer **/
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	/** Constructor **/
	public Contract() {
		super();

	}

	/**
	 * 
	 * @return  contractID
	 */
	public Integer getContractID() {
		return contractID;
	}

	/**
	 * 
	 * @param contractID
	 * 				the contractID to set
	 */
	public void setContractID(Integer contractID) {
		this.contractID = contractID;
	}

	/**
	 * 
	 * @return fechaV
	 */
	public Date getFechaV() {
		return fechaV;
	}

	/**
	 * 
	 * @param fechaV
	 * 			the fechaV to set
	 */
	public void setFechaV(Date fechaV) {
		this.fechaV = fechaV;
	}

	/**
	 * 
	 * @return fechaC
	 */
	public Date getFechaC() {
		return fechaC;
	}

	/**
	 * 
	 * @param fechaC
	 * 			the fechaC to set
	 */
	public void setFechaC(Date fechaC) {
		this.fechaC = fechaC;
	}

	/**
	 * 
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * 
	 * @param price
	 * 			the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * 
	 * @return customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * 
	 * @param customer
	 * 			the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "\n" + "[contractID=" + contractID + ", fechaV=" + fechaV + ", fechaC=" + fechaC + ", price=" + price + "]"  + "\n";
	}

	

}
