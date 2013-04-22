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


public class LogoutServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
		doPost(request,response);
		}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{

		HttpSession session = request.getSession();
		session.invalidate();
		
		response.sendRedirect("logout.jsp");
		
		}
}
