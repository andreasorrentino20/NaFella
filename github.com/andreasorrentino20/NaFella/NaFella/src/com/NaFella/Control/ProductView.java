package com.NaFella.Control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.NaFella.Model.Bean.Product;
import com.NaFella.Model.DAO.ProductDAO;

/**
 * Servlet implementation class ProductView
 */
@WebServlet("/ProductView")
public class ProductView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static ProductDAO model;

	static {
		model = new ProductDAO();
	}
	
    public ProductView() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product pr = new Product(0,null,null,null,null,null,0,0,0);
		//System.out.println("sono qui");
		try {
			pr = model.doRetrieveByKey(Integer.parseInt(request.getParameter("id")));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("product", pr);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Jsp/Product.jsp");
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
