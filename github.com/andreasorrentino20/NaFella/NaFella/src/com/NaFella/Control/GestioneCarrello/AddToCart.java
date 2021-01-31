package com.NaFella.Control.GestioneCarrello;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.NaFella.Model.Bean.Cart;
import com.NaFella.Model.Bean.Product;
import com.NaFella.Model.DAO.ProductDAO;
import com.NaFella.Model.Bean.ReadFile;


/**
 * Servlet implementation class AddToCart
 */

public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ProductDAO model;
	final File folder = new File("prints");
	static {
		model = new ProductDAO();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if(cart == null) {
			cart = new Cart();
		}
		String action = request.getParameter("action");
		try {
			if (action != null) {
				if(request.getParameter("id")!= null) {
					int id = Integer.parseInt(request.getParameter("id"));
					if(action.equals("add")) {
						if(model.doRetrieveByKey(id).getAvailability() <= 0){
						} else {

							cart.addItem(model.doRetrieveByKey(id), "");
							model.doUpdateByKey(id, "remove");
						}
					}
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		request.getSession().removeAttribute("cart");
		request.getSession().setAttribute("cart", cart);
		response.getWriter().write(""+cart.getProducts().size());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
