package com.NaFella.Control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.NaFella.Model.Bean.Address;
import com.NaFella.Model.DAO.AddressDAO;
import com.NaFella.Model.Bean.Customer;
import com.NaFella.Model.DAO.CustomerDAO;
import com.NaFella.Model.Bean.md5;

/**
 * Servlet implementation class AddressControl
 */
public class AddressControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// ProductModelDS usa il DataSource
	// ProductModelDM usa il DriverManager	
	
	static AddressDAO model;
	
	static {
		model = new AddressDAO();
	}
	
	
	public AddressControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		Customer customer = (Customer)request.getSession().getAttribute("customer");
		int idCustomer = 0;
		try {
			
			if(customer == null) {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Jsp/Login.jsp");
				dispatcher.forward(request, response);
			} else {
					idCustomer = customer.getId();
					if (action != null) {
						if (action.equalsIgnoreCase("read")) {
							int id = Integer.parseInt(request.getParameter("id"));
							request.removeAttribute("address");
							request.setAttribute("address", model.doRetrieveByKey(id));
						}else if (action.equalsIgnoreCase("insert_address")) {
							
							String street = request.getParameter("street");
							String city = request.getParameter("city");
							String postalCode = request.getParameter("postalCode");
							String province = request.getParameter("province");
							String country = request.getParameter("country");
											
							Address bean = new Address();
							bean.setStreet(street);
							bean.setCity(city);
							bean.setPostalCode(postalCode);
							bean.setProvince(province);
							bean.setCountry(country);
							bean.setIdCustomer(idCustomer);
							model.doSave(bean);
						}
							else if (action.equalsIgnoreCase("modify")) {
							
								String street = request.getParameter("street");
								String city = request.getParameter("city");
								String postalCode = request.getParameter("postalCode");
								String province = request.getParameter("province");
								String country = request.getParameter("country");
								
								int id = Integer.parseInt(request.getParameter("id"));
								
								Address bean = new Address();
								bean.setStreet(street);
								bean.setCity(city);
								bean.setPostalCode(postalCode);
								bean.setProvince(province);
								bean.setCountry(country);
								bean.setId(id);
								model.doModify(bean);
							}
								else if (action.equalsIgnoreCase("delete")) {
									
									int id = Integer.parseInt(request.getParameter("id"));
									model.doDelete(id);	
								}
					}
			}
		} catch (SQLException e) {
			System.out.println("Error 1:" + e.getMessage());
		}

		String sort = request.getParameter("sort");
		
		try {
			request.removeAttribute("addresses");
			request.setAttribute("addresses", model.doRetrieveAll(sort,idCustomer, 1));
		} catch (SQLException e) {
			System.out.println("Error 2:" + e.getMessage());
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Jsp/PersonalArea.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}