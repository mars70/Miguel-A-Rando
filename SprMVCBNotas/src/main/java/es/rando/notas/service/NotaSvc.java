package es.rando.notas.service;

import es.rando.notas.model.Nota;

public interface NotaSvc {

	public Iterable<Nota> findAll() throws ExceptionSvc;
	
	public Iterable<Nota> findByNotasUsuario(Integer idUser) throws ExceptionSvc;
	
	public Nota findById(int id) throws ExceptionSvc;

	public void save(Nota nota) throws ExceptionSvc;
	
	public void update(Nota nota) throws ExceptionSvc;
	
	public void delete(Nota nota) throws ExceptionSvc;
	
}
