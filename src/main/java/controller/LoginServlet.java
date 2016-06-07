package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		String name = request.getParameter("name"); 
		String pass = request.getParameter("pass");
		RequestDispatcher rd = null;
		if(!pass.equals("geheim")){
			request.setAttribute("message", "Dit wachtwoord is niet juist.");
			request.setAttribute("name", name);
		}
		else if((name.equals("gebruiker") || name.equals("user")) && pass.equals("geheim")){
			request.getSession().setAttribute("type", "gebruiker");
		} else if(name.equals("beheerder") && pass.equals("geheim")) {
			request.getSession().setAttribute("type", "beheerder");
		} else {
			request.setAttribute("message", "Deze inlognaam is niet juist.");
			request.setAttribute("name", name);
		}
		rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
