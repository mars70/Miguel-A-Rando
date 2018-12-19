package es.rando.notas.model.dao;

import es.rando.notas.model.Usuario;

public interface UsuarioDao {

	public Iterable<Usuario> findAll() throws ExceptionDao;
	public Usuario findById(int id) throws ExceptionDao;
	public boolean findByApodoContraseña(String apodoUsuario, String clave) throws ExceptionDao;
	public Usuario findByUserPass(String apodoUsuario, String clave) throws ExceptionDao;
	public boolean findByDni(String dni) throws ExceptionDao;
	public boolean findByEmail(String email) throws ExceptionDao;
	public boolean findByApodo(String apodoUsuario) throws ExceptionDao;
	public void save(Usuario usuario) throws ExceptionDao;
	
}
