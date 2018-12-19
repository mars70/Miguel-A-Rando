package es.rando.notas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tema")
public class Tema {
	
	private Integer idTema;
	private String tema;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdTema() {
		return idTema;
	}
	
	public void setIdTema(Integer idTema) {
		this.idTema = idTema;
	}
	
	public String getTema() {
		return tema;
	}
	
	public void setTema(String tema) {
		this.tema = tema;
	}

	@Override
	public String toString() {
		return "Tema [idTema=" + idTema + ", tema=" + tema + "]";
	}
	
}
