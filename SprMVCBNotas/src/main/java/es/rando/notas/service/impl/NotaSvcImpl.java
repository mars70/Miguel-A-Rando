package es.rando.notas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.rando.notas.model.Nota;
import es.rando.notas.model.dao.NotaDao;
import es.rando.notas.service.ExceptionSvc;
import es.rando.notas.service.NotaSvc;

@Transactional
@Service
public class NotaSvcImpl implements NotaSvc {

	@Autowired
	private NotaDao dao;

	@Override
	public Iterable<Nota> findAll() throws ExceptionSvc {
		Iterable<Nota> lista = null;

		try {
			lista = dao.findAll();
		} catch (Exception ex) {
			throw new ExceptionSvc(ex);
		}

		return lista;
	}

	@Override
	public Iterable<Nota> findByNotasUsuario(Integer idUser) throws ExceptionSvc {
		Iterable<Nota> lista = null;

		try {
			lista = dao.findByNotasUsuario(idUser);
		} catch (Exception ex) {
			throw new ExceptionSvc(ex);
		}

		return lista;
	}

	@Override
	public Nota findById(int id) throws ExceptionSvc {
		Nota nota = null;
		
		try{
			nota = dao.findById(id);
		}catch (Exception ex){
			throw new ExceptionSvc(ex);
		}
		
		return nota;
	}

	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void save(Nota nota) throws ExceptionSvc {
		try{
			dao.save(nota);
		}catch (Exception ex){
			throw new ExceptionSvc(ex);
		}
	}

	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void update(Nota nota) throws ExceptionSvc {
		try{
			dao.update(nota);
		}catch (Exception ex){
			throw new ExceptionSvc(ex);
		}
	}

	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void delete(Nota nota) throws ExceptionSvc {
		try{
			nota = findById(nota.getIdNota());
			dao.delete(nota);
		}catch (Exception ex){
			throw new ExceptionSvc(ex);
		}
	}

}
