package com.NaFella.Control;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.NaFella.Model.Bean.Customer;
import com.NaFella.Model.Bean.Product;
import com.NaFella.Model.DAO.ProductDAO;

/**
 * Servlet implementation class ProductControl
 */
public class ProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// ProductModelDS usa il DataSource
	// ProductModelDM usa il DriverManager	
	
	static ProductDAO model;
	
	static {
		model = new ProductDAO();
	}
	
	
	public ProductControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
        
		Customer admin = (Customer)request.getSession().getAttribute("admin");
		
		try {
			
			if(admin == null) {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JspManager/Jsp/login.jsp");
				dispatcher.forward(request, response);
			} else {
					
					if (action != null) {
						if (action.equalsIgnoreCase("edit")) {
							
							int id = 0;
							if(request.getParameter("id")!=null)
							{  
								id = Integer.parseInt(request.getParameter("id"));
								request.removeAttribute("product");
								request.setAttribute("product", model.doRetrieveByKey(id));
							}
						}else if (action.equalsIgnoreCase("modify")) {
							
								String product_name = request.getParameter("product_name");
								String size = request.getParameter("size");
								String image = request.getParameter("image");
								String sex = request.getParameter("sex");
								String product_type = request.getParameter("product_type");
								String description = request.getParameter("description");
								Double price = Double.parseDouble(request.getParameter("price"));
								Double discount = Double.parseDouble(request.getParameter("discount"));
								int availability = Integer.parseInt(request.getParameter("availability"));
								
								int id = Integer.parseInt(request.getParameter("id"));
								
								Product bean = new Product(0, null, null, null, null, null, 0, 0, 0);
								bean.setName(product_name);;
								bean.setSize(size);
								bean.setImg(image);
								bean.setType(product_type);
								bean.setDescription(description);
								bean.setPrice(price);
								bean.setDiscount(discount);
								bean.setAvailability(availability);
								bean.setId(id);
								model.doModify(bean);
							}
								else if (action.equalsIgnoreCase("delete")) {
									
									int id = 0;
									if(request.getParameter("id")!=null)
									{
										id = Integer.parseInt(request.getParameter("id"));
										model.doDelete(id);
									}
								}
					}
			}
		} catch (SQLException e) {
			System.out.println("Error 1:" + e.getMessage());
		}

		String sort = request.getParameter("sort");
		
		try {
			request.removeAttribute("product_admin");
			request.setAttribute("product_admin", model.doRetrieveAll(sort,null,null,0));
		} catch (SQLException e) {
			System.out.println("Error 2:" + e.getMessage());
		}
	
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JspManager/Jsp/products.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

