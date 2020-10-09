package co.edu.ucentral.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import co.edu.ucentral.app.servicio.common.base.entity.EntidadBase;

@Entity
@Table(name = "departamento", uniqueConstraints = { @UniqueConstraint(columnNames = { "id", "id_departamento" }) })
public class Curso extends EntidadBase {

	@Column(unique = true)
	private String nombre;

	@Column(name = "id_departamento")
	private Integer idDepartamento;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
