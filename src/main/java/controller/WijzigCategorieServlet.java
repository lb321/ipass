package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Categorie;
import model.Schap;
import services.ServiceProvider;

/**
 * Servlet implementation class WijzigCategorieServlet
 */
@WebServlet("/WijzigCategorieServlet")
public class WijzigCategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WijzigCategorieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	/*private int getSameValues(String value){
		for(String)
	}*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Integer> schapNummers = new ArrayList<Integer>();
		ArrayList<Categorie> categorieen = new ArrayList<Categorie>();
		RequestDispatcher rd = null;
		boolean error = false;
		for(String key: request.getParameterMap().keySet()){
			int i = 0;
			try{
				i = Integer.parseInt(request.getParameterMap().get(key)[0]);
			}catch(NumberFormatException e){
				request.setAttribute("message", "Schapnummer moet ingevult zijn!");
				error = true;
				break;
			}
			if(schapNummers.contains(i)){
				request.setAttribute("message", "Schapnummers mogen niet gelijk zijn!");
				error = true;
				break;
			}
			schapNummers.add(i);
			categorieen.add(new Categorie(key, new Schap(i)));
		}
		if(!error){
			boolean result = ServiceProvider.getCategorieService().updateCategories(categorieen);
			if(result){
				request.setAttribute("message", "Schappen zijn geupdate!");
			} else {
				request.setAttribute("message", "Er was een fout met het schappen updaten");
			}
		}
		rd = request.getRequestDispatcher("indelingveranderen.jsp");
		rd.forward(request, response);
	}

}
