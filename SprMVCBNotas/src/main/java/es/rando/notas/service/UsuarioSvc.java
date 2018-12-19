package es.rando.notas.service;

import es.rando.notas.model.Usuario;

public interface UsuarioSvc {

	public Iterable<Usuario> findAll() throws ExceptionSvc;
	public Usuario findById(int id) throws ExceptionSvc;
	public boolean findByApodoClave(String user, String pass) throws ExceptionSvc;
	public Usuario findByUserPass(String apodoUsuario, String clave) throws ExceptionSvc;
	public boolean findByDni(String dni) throws ExceptionSvc;
	public boolean findByEmail(String email) throws ExceptionSvc;
	public boolean findByApodo(String apodoUsuario) throws ExceptionSvc;
	public void save(Usuario usuario) throws ExceptionSvc;
}
