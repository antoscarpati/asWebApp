package it.geek.crimini.DAO;


public interface IDAO<E,K>{
	
	public E findById(K id);

}
