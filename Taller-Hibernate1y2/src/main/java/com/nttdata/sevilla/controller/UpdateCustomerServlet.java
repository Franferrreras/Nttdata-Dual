package com.nttdata.sevilla.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.nttdata.sevilla.dao.HibernateUtil;
import com.nttdata.sevilla.model.Customer;
import com.nttdata.sevilla.service.CustomerServiceImpl;

/**
 * Servlet implementation class UpdateCustomerServlet
 */
@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		CustomerServiceImpl customerservice = new CustomerServiceImpl(session);
		 
		int id = Integer.parseInt(request.getParameter("customerid"));
		
		Customer customer = customerservice.getCustomerById(id);
		
		request.setAttribute("cstomer", customer);
		
		request.getRequestDispatcher("WEB-INF/view/upsatecustomer.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		CustomerServiceImpl customerservice = new CustomerServiceImpl(session);
		 
		int id = Integer.parseInt(request.getParameter("customerid"));
		
		Customer customer = customerservice.getCustomerById(id);
		
		session.close();
		
		
		final Session session2 = HibernateUtil.getSessionFactory().openSession();
		session2.beginTransaction();
		
		CustomerServiceImpl customerservice2 = new CustomerServiceImpl(session2);
		
		customer.setName(request.getParameter("name"));
		customer.setDni(request.getParameter("dni"));
		customer.setLastName(request.getParameter("first_name"));
		customer.setSecondLastName(request.getParameter("last_name"));
		 
		customerservice2.updateCustomer(customer);
		
		session2.close();
		
		request.setAttribute("updated", "Customer updated");
		
		doGet(request, response);
	}

}
