package co.edu.ucentral.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import co.edu.ucentral.app.servicio.common.base.entity.EntidadBase;

@Entity
@Table(name = "estudiante_curso", uniqueConstraints = @UniqueConstraint(columnNames = { "id_curso",
		"id_estudiante" }, name = "estudiante_curso_unique_constraint"))
public class EstudianteCurso extends EntidadBase {

	@Column(name = "id_estudiante", nullable = false)
	private Long idEstudiante;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_curso", nullable = false)
	private Curso curso;

	@JsonIgnore
	@OneToMany(mappedBy = "estudianteCurso", cascade = CascadeType.ALL)
	private List<RespuestaEstudiante> respuestasExamen;

	public EstudianteCurso() {
		super();
	}

	public EstudianteCurso(Long idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

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

	public List<RespuestaEstudiante> getRespuestasExamen() {
		return respuestasExamen;
	}

	public void setRespuestasExamen(List<RespuestaEstudiante> respuestasExamen) {
		this.respuestasExamen = respuestasExamen;
	}

}
