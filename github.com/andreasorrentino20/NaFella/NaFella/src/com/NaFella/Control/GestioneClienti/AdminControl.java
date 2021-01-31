package com.NaFella.Control.GestioneClienti;

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
import com.NaFella.Model.Bean.Product;
import com.NaFella.Model.DAO.ProductDAO;
import com.NaFella.Model.Bean.md5;

/**
 * Servlet implementation class AddressControl
 */
public class AdminControl extends HttpServlet {
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
	
	public AdminControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		Customer admin = (Customer)request.getSession().getAttribute("admin");
		
		try {
			
			if(admin != null) 
			{
				if (action != null) {
					if (action.equalsIgnoreCase("edit")) {
						int id_order = 0;
						if(request.getParameter("id_order")!=null)
						{
						  id_order = Integer.parseInt(request.getParameter("id_order"));
						  request.removeAttribute("order");
						  request.setAttribute("order", model_Order.doRetrieveByKey(id_order));
						}
					}
					else if (action.equalsIgnoreCase("accept_purchase")) {
						
							String tracking_code = request.getParameter("tracking_code");
							
							int id_order = Integer.parseInt(request.getParameter("id_order"));
							Order bean = new Order(0,null,null,null,0,0,0);
							bean.setTracking(tracking_code);
							bean.setId(id_order);
							model_Order.doModify(bean);
							
							
							Collection<?> products = (Collection<?>) model_Product.doRetrieveAll(null, action, null,id_order);
							
							  
							  if(products != null && products.size() != 0)
							   {
								Iterator<?> it_prod = products.iterator();
								while (it_prod.hasNext()) {
									
									Product prd = (Product) it_prod.next();
										
									model_Product.doUpdateByKey(prd.getId(), "remove");	
									
								}
							   }
						}
						else if (action.equalsIgnoreCase("delete_order")) {
							
							int id = 0;
							if(request.getParameter("id_order")!=null)
							{							
								id = Integer.parseInt(request.getParameter("id_order"));
								model_Order.doDelete(id);		
							}
						} 
					}
			}
			else
			{
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JspManager/Jsp/login.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			System.out.println("Error 1:" + e.getMessage());
		}

		String sort_address = request.getParameter("sort_address");
		String sort_order = request.getParameter("sort_order");
		if(sort_order==null)
			sort_order = "purchase_date";
		
		action = request.getParameter("action");
		if(action!=null)
		{	if(action.equalsIgnoreCase("total_orders"))
			{
				try {
					request.removeAttribute("addresses_admin");
					request.setAttribute("addresses_admin", model_Address.doRetrieveAll(sort_address,0,0));
					request.removeAttribute("orders_admin");
					request.setAttribute("orders_admin", model_Order.doRetrieveAll(sort_order,0,0));
					request.removeAttribute("products_admin");
					request.setAttribute("products_admin", model_Product.doRetrieveAll_for_Order(sort_order,0,0));
				} catch (SQLException e) {
					System.out.println("Error 2:" + e.getMessage());
				}
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JspManager/Jsp/total_orders.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				try {
					request.removeAttribute("addresses_admin");
					request.setAttribute("addresses_admin", model_Address.doRetrieveAll(sort_address,0,1));
					request.removeAttribute("orders_admin");
					request.setAttribute("orders_admin", model_Order.doRetrieveAll(sort_order,0,1));
					request.removeAttribute("products_admin");
					request.setAttribute("products_admin", model_Product.doRetrieveAll_for_Order(sort_order,0,1));
				} catch (SQLException e) {
					System.out.println("Error 2:" + e.getMessage());
				}
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JspManager/Jsp/index.jsp");
				dispatcher.forward(request, response);
			}		
		}
		else
		{
			try {
				request.removeAttribute("addresses_admin");
				request.setAttribute("addresses_admin", model_Address.doRetrieveAll(sort_address,0,1));
				request.removeAttribute("orders_admin");
				request.setAttribute("orders_admin", model_Order.doRetrieveAll(sort_order,0,1));
				request.removeAttribute("products_admin");
				request.setAttribute("products_admin", model_Product.doRetrieveAll_for_Order(sort_order,0,1));
			} catch (SQLException e) {
				System.out.println("Error 2:" + e.getMessage());
			}
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JspManager/Jsp/index.jsp");
			dispatcher.forward(request, response);
		}			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}