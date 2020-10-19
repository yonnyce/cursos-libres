package co.edu.ucentral.app.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import co.edu.ucentral.app.servicio.common.base.entity.EntidadBase;

@Entity
@Table(name = "curso", uniqueConstraints = @UniqueConstraint(columnNames = { "id_periodo",
		"nombre" }, name = "curso_departamento_unique_constraint"))
public class Curso extends EntidadBase {

	@NotNull
	@Size(min = 1, max = 50)
	@Column(unique = true, length = 50)
	private String nombre;

	@Column(name = "id_departamento", nullable = false)
	private Integer idDepartamento;

	@Column(name = "id_periodo", nullable = false)
	private Integer idPeriodo;
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "curso", cascade = CascadeType.ALL)
	private Evaluacion examen;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToMany(mappedBy = "curso",cascade = CascadeType.ALL)
	private Set<EstudianteCurso> estudiantes;

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

	public Integer getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(Integer idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public Set<EstudianteCurso> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(Set<EstudianteCurso> estudiantes) {
		this.estudiantes = estudiantes;
	}

}
