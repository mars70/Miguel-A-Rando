package es.rando.notas.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.rando.notas.model.Tema;
import es.rando.notas.model.dao.ExceptionDao;
import es.rando.notas.model.dao.TemaDao;

@Repository
public class TemaDaoImpl implements TemaDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Iterable<Tema> findAll() throws ExceptionDao {
		List<Tema> lista = null;

		try {
			String hql = "FROM Tema";
			lista = sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (Exception ex) {
			throw new ExceptionDao(ex);
		}

		return lista;
	}
	
}
