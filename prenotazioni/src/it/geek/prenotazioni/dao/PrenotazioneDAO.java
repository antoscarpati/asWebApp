package it.geek.prenotazioni.dao;

import it.geek.prenotazioni.model.Prenotazione;
import it.geek.prenotazioni.util.ConnessioneDBPrenotazioni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.log4j.Logger;

public class PrenotazioneDAO implements IDAO {

	private static Logger log = Logger.getLogger(PrenotazioneDAO.class);
	
	public List<Prenotazione> findByMatricolaStudente(String matricola){
		List<Prenotazione> ritorno = null;
		
		//...
		
		return ritorno;
	}
	
	public boolean insert (String matricola, int codCorso) {
		
		Connection c = null;
		PreparedStatement ps = null;
		boolean ret = false;
		
		c = ConnessioneDBPrenotazioni.getConnection();
		
		String sql = "INSERT INTO prenotazioni (cod_studente, cod_corso) values (?,?)";
		
		try{
			ps=c.prepareStatement(sql);
			ps.setString(1,matricola);
			ps.setInt(2,codCorso);
			
			
int ritorno = ps.executeUpdate ();
			
			if (ritorno>0) {
				ret = true;
        	}	
		
			
			} catch (Exception e) {
			e.printStackTrace ();
			}
			finally {
				try {
					ps.close();
					}
				catch (Exception e) {
					System.out.println ("Impossibile chiudere il PreparedStatement"+ e);
					e.printStackTrace ();
					}
				try {
					c.close();
					} catch (Exception e) {
					System.out.println ("Impossibile chiudere la connection"+ e);
					e.printStackTrace ();
					}
		} return ret;
	}
	
	public void delete(String id){
		
		//...
		
	}

	@Override
	public Object findById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Prenotazione p) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
