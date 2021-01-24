package com.NaFella.Control;

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
							String sourceImg = request.getParameter("image");
							//trova e carica immagine png nel server
							String img = sourceImg.split(",")[1];
							img = img.replace(' ', '+');
							byte[] imageBytes;
					        imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(img);
					        ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
					        BufferedImage image = ImageIO.read(bis);
					        int n = ReadFile.readFile();
					        //String s = "C:/Program Files/Apache Software Foundation/Tomcat 8.5/webapps/GenerateShop/prints/image"+n+".png";
					        String s = "C:/Users/Luigi Cicalese/eclipse-workspace/NaFella/WebContent/prints/image"+n+".png";
					        String save = "prints/image"+n+".png";
					        File f = new File(s);
					        f.createNewFile();
					        ImageIO.write(image, "png", f);
							n+=1;
							ReadFile.writeFile(n);
							cart.addItem(model.doRetrieveByKey(id), save);
							//model.doUpdateByKey(id, "remove");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
