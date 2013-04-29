package it.geek.crimini.DAO.impl;


import java.util.List;
import it.geek.crimini.DAO.IDAO;
import it.geek.crimini.model.Utente;
import it.geek.crimini.util.ConnessioneDBCrimini;

import java.sql.*;
import java.util.Vector;


	public class UtenteDAO implements IDAO<Utente, String> {

		public Utente findById(String id) {
			
			Connection c=null;
			Utente ret = null;
			
			c = ConnessioneDBCrimini.getConnection();
		
			
			PreparedStatement ps= null;
			ResultSet rs= null;
			
		String sql="SELECT username, password, cognome, nome, id_ruolo FROM utenti WHERE username=?";
			
			try {
				ps=c.prepareStatement(sql);
				ps.setString(1,id);
				rs=ps.executeQuery();
				
				if(rs.next()){
					ret=new Utente();
					ret.setUsername(rs.getString("username"));
					ret.setPassword(rs.getString("password"));
					ret.setCognome(rs.getString("cognome"));
					ret.setNome(rs.getString("nome"));
					ret.setId_ruolo(rs.getInt("id_ruolo"));
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
		
		public List<Utente> findAll () {
			
			List<Utente> lista = null;
			
			Connection c= ConnessioneDBCrimini.getConnection();
			
			PreparedStatement ps = null;
			ResultSet rs= null;
			
			String sql= "SELECT nome, cognome, id_ruolo FROM utenti ";
			try {
				ps=c.prepareStatement(sql);
				rs=ps.executeQuery();
				
				lista = new Vector<Utente>();
				Utente u = null;
				while(rs.next()){
					u=new Utente();
					u.setNome(rs.getString("nome"));
					u.setCognome(rs.getString("cognome"));
					u.setId_ruolo(rs.getInt("id_ruolo")); 
					lista.add(u);
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
		public boolean insert (Utente u) {
			
		Connection c = null;
		PreparedStatement ps = null;
		boolean ret = false;
		
		c = ConnessioneDBCrimini.getConnection();
		
		String sql = "INSERT INTO utenti (username, password, nome, cognome, id_ruolo) values (?,?,?,?,?)";
		
		try{
			ps=c.prepareStatement(sql);
			ps.setString(1,u.getUsername());
			ps.setString(2,u.getPassword());
			ps.setString(3,u.getNome());
			ps.setString(3,u.getCognome());
			ps.setInt(5,u.getId_ruolo());
			
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
}
	
