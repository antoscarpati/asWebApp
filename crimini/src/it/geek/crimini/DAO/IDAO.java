package it.geek.crimini.DAO;

import java.util.List;
import it.geek.crimini.model.*;

public interface IDAO<E,K>{
	
	public E findById(K id);
	public List<E> findAll ();
	public boolean insert (Utente u);

}
