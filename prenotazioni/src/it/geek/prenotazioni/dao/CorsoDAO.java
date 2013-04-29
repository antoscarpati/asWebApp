package it.geek.prenotazioni.dao;


import it.geek.prenotazioni.util.ConnessioneDBPrenotazioni;
import it.geek.prenotazioni.model.Corso;
import it.geek.prenotazioni.model.Prenotazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;

public class CorsoDAO implements IDAO{

	private static Logger log = Logger.getLogger(CorsoDAO.class);
	
	public List<Corso> findAll () {
		
		List<Corso> lista = null;
		
		Connection c= ConnessioneDBPrenotazioni.getConnection();
		
		PreparedStatement ps = null;
		ResultSet rs= null;
		
		String sql= "SELECT id, materia FROM corsi ";
		try {
			ps=c.prepareStatement(sql);
			rs=ps.executeQuery();
			
			lista = new Vector<Corso>();
			Corso co = null;
			while(rs.next()){
				co=new Corso();
				co.setId(rs.getInt("id"));
				co.setMateria(rs.getString("Materia"));
				lista.add(co);
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
	return lista;	
	}

	@Override
	public Object findById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Prenotazione p) {
		// TODO Auto-generated method stub
		return false;
	}
}

