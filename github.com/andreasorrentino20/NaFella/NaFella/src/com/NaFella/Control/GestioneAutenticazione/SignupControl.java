package com.NaFella.Control.GestioneAutenticazione;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.NaFella.Model.Bean.Customer;
import com.NaFella.Model.DAO.CustomerDAO;
import com.NaFella.Model.Bean.md5;

public class SignupControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static CustomerDAO model;
	
	static {
		
			model = new CustomerDAO();
		
	}
	String return_path = "/Signup.jsp";
	
	public SignupControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		try {
			if (action != null) 
			{
  			  if (action.equalsIgnoreCase("insert")) 
				{
					
					return_path = "/Signup.jsp";
					
					String email = request.getParameter("email");
					
					String first_name = request.getParameter("first_name");
					int n = first_name.length();
					first_name = UPPER(first_name,n);
					
					String last_name = request.getParameter("last_name");
					n = last_name.length();
					last_name = UPPER(last_name,n);
					
					String birth_date = request.getParameter("birth_date");
					String phone_number = request.getParameter("phone_number");
					
					String psw = request.getParameter("psw");
					psw = md5.hashCode(psw, "MD5"); 	
				    
					HttpSession session = request.getSession();
				    				      
				    session.setAttribute("register_completed", email);				    
				    
					Customer bean = new Customer(0,null,null,null,null,null,null);
					bean.setEmail(email);
					bean.setFirstName(first_name);
					bean.setLastName(last_name);
					bean.setBirthdate(birth_date);
					bean.setPhoneNumber(phone_number);
					bean.setPsw(psw);
					model.doSave(bean);										
				    
				}
			}
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
			
			String email = request.getParameter("email");
			HttpSession session = request.getSession();
		    				      
		    session.setAttribute("register_fault", email);		      
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(return_path);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public String UPPER(String first_name,int n)
	{
		int UPPER_first_letter = 1;
		String upper = null;
		for(int i=0;i<n;i++)
		{						
			String comparison = first_name.substring(i, i+1);
			
			if((comparison.replace(" ", "").length())==0)
			{	
				if(upper!=null) 
					upper = upper + " ";
				
				UPPER_first_letter = 1;
			}
			else
			{
				if(UPPER_first_letter==1)
					if(upper==null) 
					     upper = first_name.substring(i, i+1).toUpperCase();
					else
						 upper = upper + first_name.substring(i, i+1).toUpperCase();
				else 
					upper = upper + first_name.substring(i, i+1);
				
				UPPER_first_letter = 0;
			}
		}
		
	 return upper;
	}
}