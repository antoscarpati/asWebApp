package it.geek.crimini.controller;

import it.geek.crimini.DAO.*;
import it.geek.crimini.model.*;
import it.geek.crimini.DAO.impl.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InserisciUtenteServlet extends HttpServlet {

public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
		doPost(request,response);
		}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/inserisciUtente.jsp");
		dispatcher.forward (request, response);
	}
}
