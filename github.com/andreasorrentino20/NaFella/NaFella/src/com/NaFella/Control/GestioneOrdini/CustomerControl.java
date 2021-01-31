package com.NaFella.Control.GestioneOrdini;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.NaFella.Model.Bean.Customer;
import com.NaFella.Model.DAO.CustomerDAO;
import com.NaFella.Model.Bean.md5;

/**
 * Servlet implementation class CustomerControl
 */
public class CustomerControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// ProductModelDS usa il DataSource
	// ProductModelDM usa il DriverManager	
	
	static CustomerDAO model;
	
	static {
		model = new CustomerDAO();
	}
	
	
	public CustomerControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		
		try {
			if (action != null) {
				if (action.equalsIgnoreCase("delete")) {
					
					int id = Integer.parseInt(request.getParameter("id"));
					request.removeAttribute("customer");
					request.setAttribute("customer", model.doDelete(id));
				}
			}
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}

		String sort = request.getParameter("sort");

		try {
			request.removeAttribute("customers");
			request.setAttribute("customers", model.doRetrieveAll(sort));
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JspManager/Jsp/customers_registered.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}