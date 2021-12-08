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
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet("/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/view/addcustomer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		CustomerServiceImpl customerservice = new CustomerServiceImpl(session);
		Customer customer = new Customer();
		String name = request.getParameter("name");
		String firstn = request.getParameter("first_name");
		String lastn = request.getParameter("last_name");
		String dni = request.getParameter("dni");
		
		customer.setName(name);
		customer.setLastName(firstn);
		customer.setSecondLastName(lastn);
		customer.setDni(dni);
		
		customerservice.insertNewCustomer(customer);
		
		response.sendRedirect(request.getContextPath()+"/Main");
	}

}
