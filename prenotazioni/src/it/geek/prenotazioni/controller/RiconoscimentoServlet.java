package it.geek.prenotazioni.controller;

import it.geek.prenotazioni.*;
import it.geek.prenotazioni.dao.IDAO;
import it.geek.prenotazioni.dao.StudenteDAO;
import it.geek.prenotazioni.model.Studente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class RiconoscimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String matricola= request.getParameter("matricola");
		
		IDAO<?, String> dao= new StudenteDAO();
		Studente s= (Studente) dao.findById(matricola);
		
		String forwardPath="";
		
		if (s!=null && s.getMatricola().equals(matricola)){
						
			forwardPath="/home.jsp";
			
			HttpSession session = request.getSession();
			session.setAttribute("studente", s);
			
		} else {
				
			forwardPath="/error.jsp";
			request.setAttribute("errore", "non ho trovato nessuno studente con quella matricola");	
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
		rd.forward(request, response);
		}
	
		
	}


