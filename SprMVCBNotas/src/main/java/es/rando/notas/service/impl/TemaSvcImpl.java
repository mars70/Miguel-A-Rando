package es.rando.notas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.rando.notas.model.Tema;
import es.rando.notas.model.dao.TemaDao;
import es.rando.notas.service.ExceptionSvc;
import es.rando.notas.service.TemaSvc;

@Transactional
@Service
public class TemaSvcImpl implements TemaSvc{

	@Autowired
	private TemaDao dao;

	@Override
	public Iterable<Tema> findAll() throws ExceptionSvc {
		Iterable<Tema> lista = null;

		try {
			lista = dao.findAll();
		} catch (Exception ex) {
			throw new ExceptionSvc(ex);
		}

		return lista;
	}
	
}
