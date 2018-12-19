package es.rando.notas.model.dao;

import es.rando.notas.model.Nota;

public interface NotaDao {

	public Iterable<Nota> findAll() throws ExceptionDao;
	
	public Iterable<Nota> findByNotasUsuario(Integer idUser) throws ExceptionDao;
	
	public Nota findById(int id) throws ExceptionDao;

	public void save(Nota nota) throws ExceptionDao;
	
	public void update(Nota nota) throws ExceptionDao;
	
	public void delete(Nota nota) throws ExceptionDao;

}
