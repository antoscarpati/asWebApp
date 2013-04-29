package it.geek.prenotazioni.controller;


import it.geek.prenotazioni.*;
import it.geek.prenotazioni.dao.PrenotazioneDAO;
import it.geek.prenotazioni.model.Prenotazione;
import it.geek.prenotazioni.model.Studente;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrenotazioneServlet extends HttpServlet {

public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
		doPost(request,response);
		}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
		Studente s =(Studente)request.getSession().getAttribute("matricola");
		String codStudente = s.getMatricola();
		String codCorso = request.getParameter("id");
		
		int corso = Integer.parseInt(codCorso);
		
								
		PrenotazioneDAO dao = new PrenotazioneDAO();
		dao.insert(codStudente, corso);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("successo.jsp");
		rd.forward(request,response);
		
		
	}
}
	
		
		