package es.rando.notas.service;

public class ExceptionSvc extends Exception{
	
	private static final long serialVersionUID = 1L;

	public ExceptionSvc(Exception ex) {
		super(ex);
	}
	
}
