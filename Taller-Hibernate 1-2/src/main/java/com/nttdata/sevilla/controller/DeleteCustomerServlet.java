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
 * Servlet implementation class DeleteCustomerServlet
 */
@WebServlet("/DeleteCustomerServlet")
public class DeleteCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		CustomerServiceImpl customerService = new CustomerServiceImpl(session);
		
		int id = Integer.parseInt(request.getParameter("customerid"));
		Customer customer = customerService.getCustomerById(id);
		
		session.close();
		
		
		final Session session2 = HibernateUtil.getSessionFactory().openSession();
		session2.beginTransaction();
		
		CustomerServiceImpl customerService2 = new CustomerServiceImpl(session2);
		
		session2.delete(customer);
		
		session2.getTransaction().commit();
		
		session2.close();
		
		
		response.sendRedirect(request.getContextPath()+"/Main");
	}

}
