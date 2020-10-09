package co.edu.ucentral.app.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import co.edu.ucentral.app.servicio.common.base.entity.EntidadBase;

@Entity
@Table(name = "evaluacion")
public class Evaluacion extends EntidadBase {

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_curso", nullable = false)
	private Curso curso;

	@OneToMany(mappedBy = "evaluacion")
	private Set<Pregunta> preguntas;

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Set<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(Set<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

}
