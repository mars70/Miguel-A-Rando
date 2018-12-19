package es.rando.notas.model.dao;

public class ExceptionDao extends Exception{

	private static final long serialVersionUID = 1L;

	public ExceptionDao (Exception ex) {
		super(ex);
	}
}
