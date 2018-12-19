package es.rando.notas.model.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.rando.notas.model.Usuario;
import es.rando.notas.model.dao.ExceptionDao;
import es.rando.notas.model.dao.UsuarioDao;

@Repository
public class UsuarioDaoImpl implements UsuarioDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Iterable<Usuario> findAll() throws ExceptionDao {
		List<Usuario> lista = null;

		try {
			String hql = "FROM Usuario";
			lista = sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (Exception ex) {
			throw new ExceptionDao(ex);
		}

		return lista;
	}

	@Override
	public Usuario findById(int id) throws ExceptionDao {
		Usuario usuario = null;

		try {
			usuario = (Usuario) sessionFactory.getCurrentSession().get(Usuario.class, id);
		} catch (Exception ex) {
			throw new ExceptionDao(ex);
		}

		return usuario;
	}

	@Override
	public boolean findByApodoContraseña(String apodoUsuario, String clave) throws ExceptionDao {
		
		List<Usuario> lista = null;

		try {
			String hql = "FROM Usuario u where u.apodoUsuario='"+apodoUsuario+"' and u.clave='"+clave+"'";
			lista = sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (Exception ex) {
			throw new ExceptionDao(ex);
		}
		
		if (!lista.isEmpty()) {
			return true;
		}
		else{
			return false;
		}
		
	}

	@Override
	public boolean findByDni(String dni) throws ExceptionDao {
		
		List<Usuario> lista = null;

		try {
			String hql = "FROM Usuario u where u.dni='"+dni+"'";
			lista = sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (Exception ex) {
			throw new ExceptionDao(ex);
		}
		
		if (!lista.isEmpty()) {
			return true;
		}
		else{
			return false;
		}		
	}

	@Override
	public boolean findByEmail(String email) throws ExceptionDao {
		List<Usuario> lista = null;

		try {
			String hql = "FROM Usuario u where u.email='"+email+"'";
			lista = sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (Exception ex) {
			throw new ExceptionDao(ex);
		}
		
		if (!lista.isEmpty()) {
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean findByApodo(String apodoUsuario) throws ExceptionDao {
		List<Usuario> lista = null;

		try {
			String hql = "FROM Usuario u where u.apodoUsuario='"+apodoUsuario+"'";
			lista = sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (Exception ex) {
			throw new ExceptionDao(ex);
		}
		
		if (!lista.isEmpty()) {
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public void save(Usuario usuario) throws ExceptionDao {
		try {
			sessionFactory.getCurrentSession().save(usuario);
		} catch (Exception ex) {
			throw new ExceptionDao(ex);
		}
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public Usuario findByUserPass(String apodoUsuario, String clave) throws ExceptionDao {
		List<Usuario> lista = null;

		try {
			String hql = "FROM Usuario u where u.apodoUsuario='"+apodoUsuario+"' and u.clave='"+clave+"'";
			lista = sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch (Exception ex) {
			throw new ExceptionDao(ex);
		}
		
		if (!lista.isEmpty()) {
			return lista.get(0);
		}
		else{
			return lista.get(0);
		}
	}
}
