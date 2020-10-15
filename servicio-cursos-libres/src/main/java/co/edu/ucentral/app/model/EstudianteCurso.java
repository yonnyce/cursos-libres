package co.edu.ucentral.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import co.edu.ucentral.app.servicio.common.base.entity.EntidadBase;

@Entity
@Table(name = "estudiante_curso", uniqueConstraints = @UniqueConstraint(columnNames = { "id_curso",
		"id_estudiante" }, name = "estudiante_curso_unique_constraint"))
public class EstudianteCurso extends EntidadBase {

	@Column(name = "id_estudiante", nullable = false)
	private Long idEstudiante;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_curso")
	private Curso curso;

	public Long getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(Long idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
