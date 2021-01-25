package com.NaFella.Control;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.NaFella.Model.Bean.Product;
import com.NaFella.Model.DAO.ProductDAO;

/**
 * Servlet implementation class UploadFile
 */
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static ProductDAO model;
	
	static {
		model = new ProductDAO();
	}
	
	public UploadFile() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		if(ServletFileUpload.isMultipartContent(request))
		{
			try
			{
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				
				String name_folder = null,dir = null,action= null, product_name= null, size= null, image = null, sex= null, product_type=null , description=null;
				Double price = 0.0, discount=0.0;
				int availability = 0, i = 0;
				
				for(FileItem item : multiparts)
				{
					if(!item.isFormField())
					{						
						String name = new File(item.getName()).getName();					
						
						if(product_name!=null && i==0)
						{	
							product_name = product_name.replaceAll("^\\s+", ""); //toglie lo spazio all'inizio
							product_name = product_name.replaceAll("\\s+$", ""); //toglie lo spazio alla fine
							name_folder = Folder(product_name,product_name.length());
							dir = creaDir(name_folder);
							i=1;
						}
						
						if(image==null)
							image = name_folder + "/" + name + "*";
						else
							image = image + name_folder + "/" + name + "*";
						
						item.write(new File(dir + File.separator + name));
					}
					else
					{							
						if ("action".equals(item.getFieldName()))
						{
							action = item.getString();
						}
						 
						if ("product_name".equals(item.getFieldName()))
						{
							product_name = item.getString();
						}
						
						if ("size".equals(item.getFieldName()))
						{
							size = item.getString();
						}
						
						if ("sex".equals(item.getFieldName()))
						{
							sex = item.getString();
						}
						
						if ("product_type".equals(item.getFieldName()))
						{
							product_type = item.getString();
						}
						
						if ("description".equals(item.getFieldName()))
						{
							description = item.getString();
						}
						
						if ("price".equals(item.getFieldName()))
						{
							price = Double.parseDouble(item.getString());
						}
						
						if ("discount".equals(item.getFieldName()))
						{
							if(item.getString()!=null)
								discount = Double.parseDouble(item.getString());
						}
						
						if ("availability".equals(item.getFieldName()))
						{
							availability = Integer.parseInt(item.getString());
						}
						
					}
				}
				
				if (action.equalsIgnoreCase("insert_product")) {
					
					Product bean = new Product(0, null, null, null, null, null, 0, 0, 0);
					bean.setName(product_name);;
					bean.setSize(size);
					bean.setImg(image);
					bean.setType(product_type);
					bean.setDescription(description);
					bean.setPrice(price);
					bean.setDiscount(discount);
					bean.setAvailability(availability);
					model.doSave(bean);
					
					request.setAttribute("message_success", "Product inserted successfully.");
				}
			}
			catch(Exception ex)
			{
				request.setAttribute("message_danger", "File upload failed");  // errore fixato
				//request.setAttribute("message_danger", "File upload failed due to : " + ex);
			}
		}
		else
		{
			request.setAttribute("message_danger", "Sorry this servlet only handles file upload request.");
		}
		
	      RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/JspManager/Jsp/new_product.jsp");
		  dispatcher.forward(request, response);
	}
	
	public String Folder(String name,int n)
	{		
		String name_folder = "";
		
		for(int i=0;i<n;i++)
		{						
			String comparison = name.substring(i, i+1);
			
			if((comparison.equalsIgnoreCase(" "))||(comparison.equalsIgnoreCase("*")))
			{	
				name_folder = name_folder + "_";
			}
			else
			{
				name_folder = name_folder + name.substring(i, i+1);
				
			}
		}
		
	 return name_folder;
	}
	
	private static String creaDir(String name_folder)
	  {
		String Dir = "C:/Program Files/Apache Software Foundation/Tomcat 8.5/webapps/NaFella/images/" + name_folder;
		//String Dir = "C:/apache-tomcat-8.5.11/webapps/GenerateShop/images/" + name_folder;
		
	    new File(Dir).mkdir();
	    return Dir;
	  }
}