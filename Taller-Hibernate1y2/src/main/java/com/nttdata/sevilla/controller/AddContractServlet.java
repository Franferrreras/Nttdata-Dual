package com.nttdata.sevilla.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
 * Servlet implementation class AddContractServlet
 */
@WebServlet("/AddContractServlet")
public class AddContractServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContractServlet() {
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
		
		int customerid = Integer.parseInt(request.getParameter("cid"));
		
		Customer customer = customerservice.getCustomerById(customerid);
		
		request.setAttribute("customername", customer.getName());
		
		request.getRequestDispatcher("WEB-INF/view/addcontract.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		CustomerServiceImpl customerservice = new CustomerServiceImpl(session);
		
		ContractServiceImpl contractservice = new ContractServiceImpl(session);
		
		int customerid = Integer.parseInt(request.getParameter("cid"));
		
		Customer customer = customerservice.getCustomerById(customerid);
		
		Contract contract = new Contract();
		
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		contract.setCustomer(customer);
		try {
			contract.setFechaV(formato.parse(request.getParameter("fechainit")) );
			contract.setFechaC(formato.parse(request.getParameter("fechafin")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		contract.setPrice(Integer.parseInt(request.getParameter("price")));
		
		
		contractservice.insertNewContract(contract);
		
		response.sendRedirect(request.getContextPath()+"/Contract?cid="+customerid);
	}

}
