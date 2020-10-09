package co.edu.ucentral.app.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import co.edu.ucentral.app.servicio.common.base.entity.EntidadBase;

@Entity
@Table(name = "estudiante")
public class Estudiante extends EntidadBase {

	@NotEmpty
	@Size(min = 3, max = 12)
	private String documentoIdentidad;

	@NotEmpty
	@Size(min = 3, max = 35)
	private String nombres;

	@NotEmpty
	@Size(min = 3, max = 35)
	private String apellidos;

	public String getDocumentoIdentidad() {
		return documentoIdentidad;
	}

	public void setDocumentoIdentidad(String documentoIdentidad) {
		this.documentoIdentidad = documentoIdentidad;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

}
