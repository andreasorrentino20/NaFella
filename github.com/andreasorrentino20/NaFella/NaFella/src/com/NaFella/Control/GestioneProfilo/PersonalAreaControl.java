package com.NaFella.Control.GestioneProfilo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.NaFella.Model.Bean.Address;
import com.NaFella.Model.DAO.AddressDAO;
import com.NaFella.Model.Bean.Customer;
import com.NaFella.Model.DAO.CustomerDAO;
import com.NaFella.Model.Bean.Order;
import com.NaFella.Model.DAO.OrderDAO;
import com.NaFella.Model.DAO.ProductDAO;
import com.NaFella.Model.Bean.md5;

/**
 * Servlet implementation class AddressControl
 */
public class PersonalAreaControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// ProductModelDS usa il DataSource
	// ProductModelDM usa il DriverManager	
	
	static AddressDAO model_Address;
	
	static {
		model_Address = new AddressDAO();
	}
	
	static OrderDAO model_Order;
	
	static {
		model_Order = new OrderDAO();
	}
	
	static ProductDAO model_Product;
	
	static {
		model_Product = new ProductDAO();
	}
	
	public PersonalAreaControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		Customer customer = (Customer)request.getSession().getAttribute("customer");
		int idCustomer = 0;
		try {
			
			if(customer != null) 
			{
					idCustomer = customer.getId();
					if (action != null) {
						if (action.equalsIgnoreCase("edit")) {
							if(request.getParameter("id")!=null)
							{
								int id = Integer.parseInt(request.getParameter("id"));
								request.removeAttribute("address");
								request.setAttribute("address", model_Address.doRetrieveByKey(id));
							}
						}else if (action.equalsIgnoreCase("insert_address")) {
							
							String street = request.getParameter("street");
							String city = request.getParameter("city");
							String postalCode = request.getParameter("postalCode");
							String province = request.getParameter("province");
							String country = request.getParameter("country");
											
							Address bean = new Address(0,null,null,null,null,null,0);
							bean.setStreet(street);
							bean.setCity(city);
							bean.setPostalCode(postalCode);
							bean.setProvince(province);
							bean.setCountry(country);
							bean.setIdCustomer(idCustomer);
							model_Address.doSave(bean);
						}
							else if (action.equalsIgnoreCase("modify")) {
							
								String street = request.getParameter("street");
								String city = request.getParameter("city");
								String postalCode = request.getParameter("postalCode");
								String province = request.getParameter("province");
								String country = request.getParameter("country");
								
								int id = Integer.parseInt(request.getParameter("id"));
								
								Address bean = new Address(0,null,null,null,null,null,0);
								bean.setStreet(street);
								bean.setCity(city);
								bean.setPostalCode(postalCode);
								bean.setProvince(province);
								bean.setCountry(country);
								bean.setId(id);
								model_Address.doModify(bean);
							}
								else if (action.equalsIgnoreCase("delete_address")) {
									if(request.getParameter("id")!=null)
									{
										int id = Integer.parseInt(request.getParameter("id"));
										model_Address.doDelete(id);	
									}
								}
								else if (action.equalsIgnoreCase("delete_order")) {
									
									if(request.getParameter("id")!=null)
									{	
										int id = Integer.parseInt(request.getParameter("id"));
										
										
										request.setAttribute("orders", model_Order.doRetrieveAll("purchase_date",idCustomer,0));
										
										Collection<?> orders = (Collection<?>) request.getAttribute("orders");
										
										if (orders != null && orders.size() != 0) {
											
											Iterator<?> it_ord = orders.iterator();
											while (it_ord.hasNext()) {
												Order ord = (Order) it_ord.next();
												if(ord.getId()==id)
												{  if(ord.getTracking()==null)
													{	
														model_Order.doDelete(id);
														break;
													}
													else
													{	
														HttpSession session = request.getSession();
														session.setAttribute("ErrorDelete", "You can not cancel an ACCEPTED order."); 
														break;													
													}
												}
											}
										}
									}
								}
						}
			}
			else
			{
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Jsp/Login.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			System.out.println("Error 1:" + e.getMessage());
		}

		String sort_address = request.getParameter("sort_address");
		String sort_order = request.getParameter("sort_order");
		if(sort_order==null)
			sort_order = "purchase_date";
			

		try {
			request.removeAttribute("addresses");
			request.setAttribute("addresses", model_Address.doRetrieveAll(sort_address,idCustomer,0));
			request.removeAttribute("orders");
			request.setAttribute("orders", model_Order.doRetrieveAll(sort_order,idCustomer,0));
			request.removeAttribute("products");
			request.setAttribute("products", model_Product.doRetrieveAll_for_Order(sort_order,idCustomer,0));
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