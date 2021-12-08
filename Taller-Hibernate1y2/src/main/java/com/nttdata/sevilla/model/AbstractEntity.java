package com.nttdata.sevilla.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	private String updatedUser;
//
//	private Date updatedDate;

//	@Column(name = "AUDIT_UPDATED_USER", nullable = false)
//	public String getUpdatedUser() {
//		return updatedUser;
//	}
//
//	/**
//	 * @param updatedUser the updatedUser to set
//	 */
//	public void setUpdatedUser(String updatedUser) {
//		this.updatedUser = updatedUser;
//	}
//
//	/**
//	 * @return the updatedDate
//	 */
//	@Column(name = "AUDIT_UPDATED_DATE", nullable = false)
//	public Date getUpdatedDate() {
//		return updatedDate;
//	}
//
//	/**
//	 * @param updatedDate the updatedDate to set
//	 */
//	public void setUpdatedDate(Date updatedDate) {
//		this.updatedDate = updatedDate;
//	}

}
