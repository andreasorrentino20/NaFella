package com.NaFella.Control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.NaFella.Model.Bean.Cart;
import com.NaFella.Model.Bean.Customer;
import com.NaFella.Model.Bean.Order;
import com.NaFella.Model.DAO.OrderDAO;
import com.NaFella.Model.Bean.Product;
import com.NaFella.Model.Bean.Selection;
import com.NaFella.Model.DAO.SelectionDAO;

/**
 * Servlet implementation class ConfirmCheckout
 */
@WebServlet("/ConfirmCheckout")
public class ConfirmCheckout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static SelectionDAO selectionModel;
	
	static {
		
			selectionModel = new SelectionDAO();
		
	}
	
	static OrderDAO orderModel;
	
	static {
		
			orderModel = new OrderDAO();
		
	}
	
    public ConfirmCheckout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Customer customer = (Customer)request.getSession().getAttribute("customer");
		 if(customer!= null) {
			 Cart cart = (Cart)request.getSession().getAttribute("cart");
			 if(cart!= null) {
				 int addressId = Integer.parseInt(request.getParameter("address_id"));
				 Order order = new Order(0,null,null,null,0,0,0);
				 order.setCustomerId(customer.getId());
				 order.setCustomerAddress(addressId);
				 order.setPrice(Double.parseDouble(request.getParameter("total")));
				 order.setPaymentState("COMPLETED");
				 try {
					 System.out.println("sono in dosave");
					orderModel.doSave(order);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 try {
					order.setId(orderModel.doRetrieveLastId().getId());
					System.out.println(order.getId());
				 } catch(SQLException e) {
					 e.printStackTrace();
				 }
				 List<Selection> selections = new LinkedList<>();
				 for(int i = 0; i < cart.getProducts().size(); i++) {
					 selections.add(new Selection(cart.getProducts().get(i).getId(), order.getId(), cart.getImages().get(i), cart.getProducts().get(i).getPrice() - (cart.getProducts().get(i).getDiscount()/100*cart.getProducts().get(i).getPrice())));
				 }
				 try {
					selectionModel.doSaveSelection(selections);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.getSession().removeAttribute("cart");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Jsp/CheckoutComplete.jsp");
				dispatcher.forward(request, response);
				return;
			 } else {
				 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Jsp/CartView.jsp");
				 dispatcher.forward(request, response);
			 }
		 } else {
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
