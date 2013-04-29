package it.geek.prenotazioni.dao;

import it.geek.prenotazioni.model.*;

import java.util.List;

public interface IDAO<E,K>{
	
	public E findById(K id);
	public List<E> findAll ();
	public boolean insert (Prenotazione p);
	

}
