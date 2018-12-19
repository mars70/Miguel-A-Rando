package es.rando.notas.service;

import es.rando.notas.model.Tema;

public interface TemaSvc {
	
	public Iterable<Tema> findAll() throws ExceptionSvc;

}
