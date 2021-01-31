package com.NaFella.Control.GestioneProdotti;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;

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
 * Servlet implementation class Prova
 */

public class CatalogView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ProductDAO model;
	
	static {
		model = new ProductDAO();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Cart cart = (Cart) request.getSession().getAttribute("cart");
		
			if(cart == null) {
				cart = new Cart();
			}
			String s = "";
			String a =request.getParameter("action");
			String sex = null;
			int id = -1;
			if(request.getParameter("id")!= null) {
				id = Integer.parseInt(request.getParameter("id"));
			}
			try {
				
				if(a == null)
				{
					if(s != null) 
					{
						request.setAttribute("products", model.doRetrieveAll(s,null,null,0));
					}
				}
				if(a != null) {
					
					
					if(a.equals("add") && id != -1) {
						//System.out.println("CONTROL " + model.doRetrieveByKey(id).getAvailability());
						if(model.doRetrieveByKey(id).getAvailability() <= 0){ 
						}	else {
							cart.addItem(model.doRetrieveByKey(id), request.getParameter("image"));
							model.doUpdateByKey(id, "remove");
						}
					}
					else
					{	if(request.getParameter("tipoPiatto")!=null)
						{
							sex = request.getParameter("tipoPiatto");
							
							if((a.equals("PrimaScelta") || a.equals("Salumi") || a.equals("Affettati") || a.equals("PrimiPiatti")|| a.equals("SecondiPiatti")|| a.equals("Contorni")) && (sex.equals("Bianca") || sex.equals("Rossa") || sex.equals("PiattiPronti")))
							{
								System.out.println("sono in CatalogView prima di doRetriveAll");
								
								request.setAttribute("products", model.doRetrieveAll(s,a,sex,0));
								System.out.println("sono in CatalogView DOPO di doRetriveAll");
							}
						}
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getSession().removeAttribute("cart");
			request.getSession().setAttribute("cart", cart);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Jsp/Catalog.jsp");
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
