package es.rando.notas.model.dao;

import es.rando.notas.model.Tema;

public interface TemaDao {
	
	public Iterable<Tema> findAll() throws ExceptionDao;

}
