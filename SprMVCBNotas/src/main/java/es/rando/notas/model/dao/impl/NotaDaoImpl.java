package es.rando.notas.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.rando.notas.model.Nota;
import es.rando.notas.model.dao.ExceptionDao;
import es.rando.notas.model.dao.NotaDao;

@Repository
public class NotaDaoImpl implements NotaDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Iterable<Nota> findAll() throws ExceptionDao {
		List<Nota> lista = null;

		try {
			String hql = "FROM Nota";
			lista = sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (Exception ex) {
			throw new ExceptionDao(ex);
		}

		return lista;
	}

	@Override
	public Iterable<Nota> findByNotasUsuario(Integer idUser) throws ExceptionDao {
		List<Nota> lista = null;
//
//		try {
//			String hql = "from usuarios as u \r\n" + 
//					"left join nota as n on n.idUsuario = u.idUsuarios\r\n" + 
//					"where n.idUsuario = "+idUser;
//			lista = sessionFactory.getCurrentSession().createQuery(hql).list();
//		} catch (Exception ex) {
//			throw new ExceptionDao(ex);
//		}
		return lista;
	}

	@Override
	public Nota findById(int id) throws ExceptionDao {
		Nota nota = null;

		try {
			nota = (Nota) sessionFactory.getCurrentSession().get(Nota.class, id);
		} catch (Exception ex) {
			throw new ExceptionDao(ex);
		}

		return nota;
	}

	@Override
	public void save(Nota nota) throws ExceptionDao {
		try {
			sessionFactory.getCurrentSession().save(nota);
		} catch (Exception ex) {
			throw new ExceptionDao(ex);
		}
	}

	@Override
	public void update(Nota nota) throws ExceptionDao {
		try {
			sessionFactory.getCurrentSession().update(nota);
		} catch (Exception ex) {
			throw new ExceptionDao(ex);
		}
	}

	@Override
	public void delete(Nota nota) throws ExceptionDao {
		try {
			sessionFactory.getCurrentSession().delete(nota);
		} catch (Exception ex) {
			throw new ExceptionDao(ex);
		}
	}

}
