package it.geek.prenotazioni.controller;

import it.geek.prenotazioni.dao.CorsoDAO;
import it.geek.prenotazioni.dao.IDAO;
import it.geek.prenotazioni.dao.StudenteDAO;
import it.geek.prenotazioni.model.Corso;
import it.geek.prenotazioni.model.Studente;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SceltaCorsoServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	     doPost(request, response);
		
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IDAO dao = new CorsoDAO();
		List<Corso> lista = dao.findAll();
		
		request.setAttribute("Corso", lista);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/elencoCorsi.jsp");
		dispatcher.forward (request, response);
		
	}
}
