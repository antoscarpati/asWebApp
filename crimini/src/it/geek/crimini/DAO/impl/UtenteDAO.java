package it.geek.crimini.DAO.impl;


	import java.util.List;
	import it.geek.crimini.DAO.IDAO;
	import it.geek.crimini.model.Utente;
	import java.sql.*;

	import javax.naming.NamingException;
	import javax.naming.InitialContext;
	import javax.sql.DataSource;

	public class UtenteDAO implements IDAO<Utente, String> {

		public Utente findById(String id) {
			
			Connection c=null;
			Utente ret = null;
			
			try{
				InitialContext cxt = new InitialContext();
				DataSource ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/MusicDB");
				c = ds.getConnection();
				
				/*Class.forName("com.mysql.jdbc.Driver");
				c=DriverManager.getConnection("jdbc:mysql://localhost/musica?user=root&password=root");*/
				
				} catch (NamingException e){
					System.out.println("non ho trovato il driver!");
					e.printStackTrace();
				} catch (SQLException e) {
					System.out.println("non ho la connessione!");
					e.printStackTrace();
				}
			
			PreparedStatement ps= null;
			ResultSet rs= null;
			
		String sql="SELECT username, password, cognome, nome FROM utenti WHERE username=?";
			
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
}
