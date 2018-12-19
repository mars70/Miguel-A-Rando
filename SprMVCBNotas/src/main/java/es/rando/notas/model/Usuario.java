package es.rando.notas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



@Entity
@Table(name="usuarios")
public class Usuario {
	
	private Integer idUsuario;
	private String dni;
	private String nombre;
	private String apellidos;
	private Date fechaNacimiento;
	private String email;
	private String apodoUsuario;
	private String clave;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idUsuarios")
	public Integer getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	@NotNull
	@Pattern(regexp="\\d{8}[A-HJ-NP-TV-Z]", message="como 12345678A...")
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	@NotEmpty(message = "pon tu nombre")
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@NotEmpty(message = "pon tus apellidos")
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	@NotNull
	//@Temporal(TemporalType.DATE)
	@Past(message="pon fecha nacimiento")
	//@DateTimeFormat(pattern="dd/MM/yyyy")
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	@Email
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Size(min=4, max=25)
	public String getApodoUsuario() {
		return apodoUsuario;
	}
	
	public void setApodoUsuario(String apodoUsuario) {
		this.apodoUsuario = apodoUsuario;
	}
	
//	public String getContraseña() {
//		return contraseña;
//	}
//	
//	public void setContraseña(String contraseña) {
//		this.contraseña = contraseña;
//	}

	@Override
	public String toString() {
		return "Nota [idUsuario=" + idUsuario + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", fechaNacimiento=" + fechaNacimiento + ", email=" + email + ", apodoUsuario=" + apodoUsuario
				+ ", contraseña=" + clave + "]";
	}

	@NotNull(message="Debe tener 8 caracteres alfanuméricos")
	@Size(min=8, max=8)
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
}
