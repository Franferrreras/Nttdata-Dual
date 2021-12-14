package com.nttdata.sevilla.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.mariadb.jdbc.internal.com.send.SendChangeDbPacket;

import com.nttdata.sevilla.dao.HibernateUtil;
import com.nttdata.sevilla.model.Contract;
import com.nttdata.sevilla.service.ContractServiceImpl;

/**
 * Servlet implementation class DeleteContractServlet
 */
@WebServlet("/DeleteContractServlet")
public class DeleteContractServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteContractServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		ContractServiceImpl contractservice = new ContractServiceImpl(session);
		int contractId = Integer.parseInt(request.getParameter("contraid"));
		
		Contract contract = contractservice.getContractById(contractId);
		
		int idCustomer = contract.getCustomer().getCustomerID();
		session.close();
		
		final Session session2 = HibernateUtil.getSessionFactory().openSession();
		session2.beginTransaction();
		
		session2.delete(contract);
		session2.getTransaction().commit();
		
		session2.close();

		response.sendRedirect(request.getContextPath()+"/Contract?cid="+idCustomer);
	}

}
