package it.geek.prenotazioni.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


import it.geek.prenotazioni.model.Prenotazione;
import it.geek.prenotazioni.model.Studente;
import it.geek.prenotazioni.util.ConnessioneDBPrenotazioni;

public class StudenteDAO implements IDAO<Studente, String> {

	public Studente findById(String id){
		Connection c=null;
		Studente ret = null;
		
		c = ConnessioneDBPrenotazioni.getConnection();
	
		
		PreparedStatement ps= null;
		ResultSet rs= null;
		
	String sql="SELECT matricola, nome, cognome FROM studenti WHERE matricola=?";
		
		try {
			ps=c.prepareStatement(sql);
			ps.setString(1,id);
			rs=ps.executeQuery();
			
			if(rs.next()){
				ret=new Studente();
				ret.setMatricola(rs.getString("matricola"));
				ret.setNome(rs.getString("nome"));
				ret.setCognome(rs.getString("cognome"));
				}
			
		} catch (Exception e) {
			System.out.println("errore! "+e);
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			}
			catch (Exception e) {
			System.out.println ("Impossibile chiudere il ResultSet"+ e);
			e.printStackTrace ();
			}
			try {
				ps.close();
			} catch (Exception e) {
			System.out.println ("Impossibile chiudere il PrepareStatement"+ e);
			e.printStackTrace ();
			}
			try {
				c.close();
			} catch (Exception e) {
			System.out.println ("Impossibile chiudere la Connection" + e);
			e.printStackTrace ();
			}
		} 
	return ret;	
	}

	@Override
	public List<Studente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Prenotazione p) {
		// TODO Auto-generated method stub
		return false;
	}
		
		

}
