package es.rando.notas.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="nota")
public class Nota {
	
	private Integer idNota;
	private Usuario usuario;
	private Tema tema;
	private String titulo;
	private String nota;
	private Date fechaNota;
	private Integer importancia;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdNota() {
		return idNota;
	}
	
	public void setIdNota(Integer idNota) {
		this.idNota = idNota;
	}
	
	@ManyToOne
	@JoinColumn(name="idUsuario")
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario idUsuario) {
		this.usuario = idUsuario;
	}
	
	@ManyToOne
	@JoinColumn(name="idTema")
	public Tema getTema() {
		return tema;
	}
	
	public void setTema(Tema idTema) {
		this.tema = idTema;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getNota() {
		return nota;
	}
	
	public void setNota(String nota) {
		this.nota = nota;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getFechaNota() {
		return fechaNota;
	}
	
	public void setFechaNota(Date fechaNota) {
		this.fechaNota = fechaNota;
	}
	
	public Integer getImportancia() {
		return importancia;
	}
	
	public void setImportancia(Integer importancia) {
		this.importancia = importancia;
	}

	@Override
	public String toString() {
		return "Nota [idNota=" + idNota + ", usuario=" + usuario + ", tema=" + tema + ", titulo=" + titulo
				+ ", nota=" + nota + ", fechaNota=" + fechaNota + ", importancia=" + importancia + "]";
	}
	
}
