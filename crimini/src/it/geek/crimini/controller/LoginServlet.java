package it.geek.crimini.controller;

	import it.geek.crimini.DAO.IDAO;
	import it.geek.crimini.model.*;
	import it.geek.crimini.DAO.impl.UtenteDAO;
	import java.io.IOException;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	public class LoginServlet extends HttpServlet {
		
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
			
			doPost(request,response);
			}
		
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
			
			String username= request.getParameter("username");
			String password= request.getParameter("password");
			
			IDAO dao= new UtenteDAO();
			Utente u= (Utente) dao.findById(username);
			
			String forwardPath="";
			
			if (u== null){
				forwardPath="/error.jsp";
				request.setAttribute ("errore", "hai sbagliato utente");
			}
			
			else if (u!=null && u.getPassword().equals(password)){
							
				forwardPath="/home.jsp";
				
				HttpSession session = request.getSession();
				session.setAttribute("utente", u);
				
			} else {
					
				forwardPath="/error.jsp";
				request.setAttribute("errore", "hai sbagliato password!");	
			}
			
			RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
			rd.forward(request, response);
			}
		}


