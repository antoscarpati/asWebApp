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

public class AggiuntoUtenteServlet extends HttpServlet {

public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
		doPost(request,response);
		}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String id_ruolo = request.getParameter("id_ruolo");
		
		int ruolo = Integer.parseInt(id_ruolo);
		
		Utente utente = new Utente();
		
		utente.setUsername(username);
		utente.setPassword(password);
		utente.setNome(nome);
		utente.setCognome(cognome);
		utente.setId_ruolo(ruolo);
		
		
		UtenteDAO dao = new UtenteDAO();
		dao.insert(utente);
		
		List<Utente> lista = dao.findAll();
		
		request.setAttribute("listaUtenti",lista);
		RequestDispatcher rd = request.getRequestDispatcher("benvenuto.jsp");
		rd.forward(request,response);
		
		
	}
}
