package it.geek.crimini.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class ConnessioneDBCrimini {

	public static Connection getConnection () {
		Connection c= null;
		try {
		
		InitialContext cxt = new InitialContext();
		DataSource ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/CriminiDB");
		c = ds.getConnection();
		
		}
		catch (NamingException e){
			System.out.println("non ho trovato il driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("non ho la connessione!");
			e.printStackTrace();
		}
		return c;
	}
	
}
