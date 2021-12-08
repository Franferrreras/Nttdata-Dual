package com.nttdata.sevilla.controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
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
		
		ArrayList<Customer> customerList = (ArrayList<Customer>) customerService.getAllCustomers();
		
		session.close();
		request.setAttribute("customers", customerList);
		
		request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
		
	}

}
