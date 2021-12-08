package com.nttdata.sevilla.nttdatasevillaeclipsespringhibernatetaller1;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttadata.sevilla.service.NttdataCustomerManagementServiceI;
import com.nttdata.sevilla.model.NttdataCustomer;

@SpringBootApplication
public class NttdataSevillaEclipseSpringHibernateTaller11Application implements CommandLineRunner {

	@Autowired
	private NttdataCustomerManagementServiceI customerService;
	
	public static void main(String[] args) {
		SpringApplication.run(NttdataSevillaEclipseSpringHibernateTaller11Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		NttdataCustomer customer = new NttdataCustomer();
		customer.setName("Fran");
		customer.setFirstName("Ferreras");
		customer.setLastName("Farinas");
		customer.setUpdatedUser("SYS Everis");
		customer.setUpdatedDate(new Date());
		
		customerService.insertNewCustomer(customer);
		
	}
	
}
