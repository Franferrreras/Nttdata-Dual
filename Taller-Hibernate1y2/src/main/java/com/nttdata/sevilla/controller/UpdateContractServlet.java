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
import com.nttdata.sevilla.service.ContractServiceImpl;

/**
 * Servlet implementation class UpdateContractServlet
 */
@WebServlet("/UpdateContractServlet")
public class UpdateContractServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateContractServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		ContractServiceImpl contractservice = new ContractServiceImpl(session);
		int contractId = Integer.parseInt(request.getParameter("contrid"));

		Contract contrato = contractservice.getContractById(contractId);

		request.setAttribute("contrato", contrato);
		request.getRequestDispatcher("WEB-INF/view/updatecontract.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		ContractServiceImpl contractservice = new ContractServiceImpl(session);
		
		int contractId = Integer.parseInt(request.getParameter("contrid"));
		
		Contract contract = contractservice.getContractById(contractId);
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			contract.setFechaV( formato.parse(request.getParameter("fechainit")) );
			contract.setFechaC(formato.parse(request.getParameter("fechafin")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		contract.setPrice(Double.parseDouble(request.getParameter("price")));
		
		session.update(contract);
		
		session.getTransaction().commit();
		
		session.close();
		
//		final Session session2 = HibernateUtil.getSessionFactory().openSession();
//		session2.beginTransaction();
//		
//		ContractServiceImpl contractservice2 = new ContractServiceImpl(session2);
//		
//		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//		
//		try {
//			contract.setFechaV( formato.parse(request.getParameter("fechainit")) );
//			contract.setFechaV(formato.parse(request.getParameter("fechafin")));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		contract.setPrice(Double.parseDouble(request.getParameter("price")));
//		
//		contractservice2.updateContract(contract);
//		
//		session2.close();
		
		int idCustomer = contract.getCustomer().getCustomerID();
		
		response.sendRedirect(request.getContextPath()+"/Contract?cid="+idCustomer);	
		
	}

}
