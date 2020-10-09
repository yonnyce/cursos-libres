package co.edu.ucentral.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import co.edu.ucentral.app.servicio.common.base.entity.EntidadBase;

@Entity
@Table(name = "departamento")
public class Departamento extends EntidadBase {

	@Column
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
