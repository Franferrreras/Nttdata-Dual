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
import com.nttdata.sevilla.model.Contract;
import com.nttdata.sevilla.model.Customer;
import com.nttdata.sevilla.service.ContractServiceImpl;
import com.nttdata.sevilla.service.CustomerServiceImpl;

/**
 * Servlet implementation class ContractServlet
 */
@WebServlet("/ContractServlet")
public class ContractServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContractServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		int customerId = Integer.parseInt(request.getParameter("cid"));
		
		CustomerServiceImpl customerService = new CustomerServiceImpl(session);
		ContractServiceImpl contractService = new ContractServiceImpl(session);
		
		Customer customer = customerService.getCustomerById(customerId);
		ArrayList<Contract> contractsList = (ArrayList<Contract>) contractService.getContractsByCustomerId(customerId);
		
		request.setAttribute("customer", customer);
		request.setAttribute("contratos", contractsList);
		
		request.getRequestDispatcher("WEB-INF/view/contract.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		ContractServiceImpl contractService = new  ContractServiceImpl(session);
		int contratcId = Integer.parseInt(request.getParameter("cntratos"));
		
		Contract contrato = contractService.getContractById(contratcId);
		request.setAttribute("contrato", contrato);
		
		doGet(request, response);
	}

}
