package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ServiceProvider;

/**
 * Servlet implementation class VoegProductToeServlet
 */
@WebServlet("/VoegProductToeServlet")
public class VoegProductToeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoegProductToeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String naam = (String) request.getParameter("naam");
		double prijs = Double.parseDouble(request.getParameter("prijs"));
		String g = request.getParameter("gewicht");
		String categorie = request.getParameter("categorie");
		int gewicht = 0;
		if(!g.isEmpty()){
			gewicht = Integer.parseInt(g);
		}
		ServiceProvider.getProductService().insertProduct(naam, prijs, gewicht, categorie);
	}

}
