package es.rando.notas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import es.rando.notas.model.Usuario;
import es.rando.notas.model.dao.UsuarioDao;
import es.rando.notas.service.ExceptionSvc;
import es.rando.notas.service.UsuarioSvc;

@Transactional
@Service
public class UsuarioSvcImpl implements UsuarioSvc{

	@Autowired
	private UsuarioDao dao;

	@Override
	public Iterable<Usuario> findAll() throws ExceptionSvc {
		Iterable<Usuario> lista = null;

		try {
			lista = dao.findAll();
		} catch (Exception ex) {
			throw new ExceptionSvc(ex);
		}

		return lista;
	}

	@Override
	public Usuario findById(int id) throws ExceptionSvc {
		Usuario nota = null;
		
		try{
			nota = dao.findById(id);
		}catch (Exception ex){
			throw new ExceptionSvc(ex);
		}
		
		return nota;
	}

	@Override
	public boolean findByApodoClave(String user, String pass) throws ExceptionSvc {
		boolean coincidencia = false;
		
		try{
			coincidencia = dao.findByApodoContraseña(user, pass);
		}catch (Exception ex){
			throw new ExceptionSvc(ex);
		}
		
		return coincidencia;
	}

	@Override
	public boolean findByDni(String dni) throws ExceptionSvc {
		boolean coincidencia = false;
		
		try{
			coincidencia = dao.findByDni(dni);
		}catch (Exception ex){
			throw new ExceptionSvc(ex);
		}
		
		return coincidencia;
	}

	@Override
	public boolean findByEmail(String email) throws ExceptionSvc {
		boolean coincidencia = false;
		
		try{
			coincidencia = dao.findByEmail(email);
		}catch (Exception ex){
			throw new ExceptionSvc(ex);
		}
		
		return coincidencia;
	}

	@Override
	public boolean findByApodo(String apodoUsuario) throws ExceptionSvc {
		boolean coincidencia = false;
		
		try{
			coincidencia = dao.findByApodo(apodoUsuario);
		}catch (Exception ex){
			throw new ExceptionSvc(ex);
		}
		
		return coincidencia;
	}

	@Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public void save(Usuario usuario) throws ExceptionSvc {
		try{
			dao.save(usuario);
		}catch (Exception ex){
			throw new ExceptionSvc(ex);
		}
		
	}

	@Override
	public Usuario findByUserPass(String apodoUsuario, String clave) throws ExceptionSvc {
		Usuario usuario = null;

		try {
			usuario = dao.findByUserPass(apodoUsuario, clave);
		} catch (Exception ex) {
			throw new ExceptionSvc(ex);
		}

		return usuario;
	}

}
