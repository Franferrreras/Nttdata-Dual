package com.nttdata.sevilla.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nttdata_customer")
public class NttdataCustomer implements Serializable {

	/** SERIAL **/
	private static final long serialVersionUID = 1L;

	/** Identifier (PK) **/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerId;

	/** Customer name **/
	@Column(name = "name", nullable = false)
	private String name;

	/** Customer first name **/
	@Column(name = "first_name", nullable = false)
	private String firstName;

	/** Customer last name **/
	@Column(name = "last_name", nullable = true)
	private String lastName;

	/** Idefier document number **/
	@Column(name = "identity_doc_number", nullable = false, length = 9, unique = true)
	private String identityDocNumber;

	/** Audit | Updated day **/
	@Column(name = "audit_updated_user", nullable = false)
	private String updatedUser;

	/** Audit | Updated date **/
	@Column(name = "audit_updated_date", nullable = false)
	private Date updatedDate;

	/** Costructor **/
	public NttdataCustomer() {

	}

	/**
	 * 
	 * @return customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * 
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 
	 * @return identityDocNumber
	 */
	public String getIdentityDocNumber() {
		return identityDocNumber;
	}

	/**
	 * 
	 * @param identityDocNumber the identityDocNumber to set
	 */
	public void setIdentityDocNumber(String identityDocNumber) {
		this.identityDocNumber = identityDocNumber;
	}

	/**
	 * 
	 * @return updatedUser
	 */
	public String getUpdatedUser() {
		return updatedUser;
	}

	/**
	 * 
	 * @param updatedUser the updatedUser to set
	 */
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	/**
	 * 
	 * @return updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * 
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "NttdataCustomer [customerId=" + customerId + ", name=" + name + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", identityDocNumber=" + identityDocNumber + ", updatedUser=" + updatedUser
				+ ", updatedDate=" + updatedDate + "]";
	}

}
