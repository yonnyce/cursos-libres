package co.edu.ucentral.app.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import co.edu.ucentral.app.servicio.common.base.entity.EntidadBase;

@Entity
@Table(name = "facultad")
public class Facultad extends EntidadBase {

	@Column(unique = true)
	private String nombre;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "facultad", cascade = CascadeType.ALL)
	List<Departamento> departamentos;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

}
