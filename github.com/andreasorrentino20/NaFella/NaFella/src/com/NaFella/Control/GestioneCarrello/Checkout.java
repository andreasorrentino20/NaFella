package com.NaFella.Control.GestioneCarrello;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.NaFella.Model.DAO.AddressDAO;
import com.NaFella.Model.Bean.Cart;
import com.NaFella.Model.Bean.Customer;
import com.NaFella.Model.Bean.Product;

/**
 * Servlet implementation class Checkout
 */

public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkout() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    static AddressDAO model;
    
    static {
		model = new AddressDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = (Customer)request.getSession().getAttribute("customer");
		if(customer!= null) {
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			try {
				request.setAttribute("addresses", model.doRetrieveAll(null, customer.getId(),0));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(cart == null) {
				cart = new Cart();
			} else {
				double total = 0;
				for(Product pr : cart.getProducts()) {
					double discount = pr.getPrice() - pr.getDiscount();
					total += discount;
				}
				request.setAttribute("total", total);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Jsp/Checkout.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			request.setAttribute("message_danger", "To proceed with the purchase, log in or register.");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Jsp/Login.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
