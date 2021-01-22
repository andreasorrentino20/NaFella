package com.NaFella.Control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.NaFella.Model.DAO.AdminDAO;
import com.NaFella.Model.Bean.Customer;
import com.NaFella.Model.DAO.CustomerDAO;
import com.NaFella.Model.Bean.md5;

public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	String return_path = "/index.jsp";
	
	public LoginControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		
		CustomerDAO model = null;
		AdminDAO modelAdmin = null;
	
		try {
			if (action != null) {
				if (action.equalsIgnoreCase("login_admin"))
				{
					return_path = "/JspManager/Jsp/login.jsp";
					modelAdmin = new AdminDAO();
				}
				else
				{
					return_path = "/Jsp/Login.jsp";
					model = new CustomerDAO();
				}
				if (action.equalsIgnoreCase("login")||action.equalsIgnoreCase("login_admin"))
					{
						String email = request.getParameter("email");
						String psw = request.getParameter("psw");
						
						
						psw = md5.hashCode(psw, "MD5"); 	
						
						request.removeAttribute("customer");
						
						
						if (action.equalsIgnoreCase("login_admin"))
						{
							request.getSession().setAttribute("admin", modelAdmin.loginAdmin(email,psw));
						}
						else
						{
							request.getSession().setAttribute("customer", model.loginCustomer(email,psw));
						}
						
						Customer session = (Customer) request.getSession().getAttribute("customer");			    
					}
			}
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());	      
		}	
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(return_path);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}