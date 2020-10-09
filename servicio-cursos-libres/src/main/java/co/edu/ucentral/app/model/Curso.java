package co.edu.ucentral.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import co.edu.ucentral.app.servicio.common.base.entity.EntidadBase;

@Entity
@Table(name = "departamento")
public class Curso extends EntidadBase {

	@Column(unique = true)
	private String nombre;

	@Column(name = "id_departamento")
	private Integer idDepartamento;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "curso", cascade = CascadeType.ALL)
	private Evaluacion examen;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public Evaluacion getExamen() {
		return examen;
	}

	public void setExamen(Evaluacion examen) {
		this.examen = examen;
	}

}
