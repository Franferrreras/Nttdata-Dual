package com.nttdata.sevilla.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	/** SERIAL **/
	private static final long serialVersionUID = 1L;

}
