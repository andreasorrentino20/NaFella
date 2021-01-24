package com.NaFella.Control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.NaFella.Model.Bean.Cart;
import com.NaFella.Model.Bean.Customer;
import com.NaFella.Model.Bean.Product;
import com.NaFella.Model.DAO.ProductDAO;

/**
 * Servlet implementation class CartSession
 */

public class CartSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ProductDAO model;
    
	static {
		model = new ProductDAO();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cart cart = (Cart)request.getSession().getAttribute("cart");
			if(cart != null) {
				String action = request.getParameter("action");
				String removeIndex = request.getParameter("removeFromCart");
				try {
					if (action != null) {
						if(request.getParameter("id")!= null) {
							int id = Integer.parseInt(request.getParameter("id"));
							if(action.equals("add")) {
								if(model.doRetrieveByKey(id).getAvailability() <= 0){
								} else {
									cart.addItem(model.doRetrieveByKey(id), request.getParameter("image"));
									//model.doUpdateByKey(id, "remove");
								}
							}
							if(action.equals("remove")) {
								if(removeIndex!=null) {
									try {
										int i = Integer.parseInt(removeIndex);
										cart.removeItem(i);
										//model.doUpdateByKey(id, "add");
									} catch (NumberFormatException e){ }
								}
							}
						}
						if(action.equals("removeAll")) {
							for(Product pr : cart.getProducts()) {
								model.doUpdateByKey(pr.getId(), "add");
							}
							cart.clearCart();
						}
					}
				} catch(SQLException e) {
					e.printStackTrace();
				} 
			}else {
				cart = new Cart();
			}
			request.removeAttribute("cart");
			request.setAttribute("cart", cart);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Jsp/CartView.jsp");
			dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
