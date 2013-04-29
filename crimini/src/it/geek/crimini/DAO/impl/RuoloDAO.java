package it.geek.crimini.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import it.geek.crimini.DAO.IDAO;
import it.geek.crimini.model.Ruolo;
import it.geek.crimini.model.Utente;
import it.geek.crimini.util.ConnessioneDBCrimini;

public class RuoloDAO implements IDAO<Ruolo, String> {
	
	public List<Ruolo> findAll() {
		

		
		return null;
		
		
	}

	@Override
	public Ruolo findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Utente u) {
		// TODO Auto-generated method stub
		return false;
	}	
}
