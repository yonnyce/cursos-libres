package co.edu.ucentral.app.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import co.edu.ucentral.app.servicio.common.base.entity.EntidadBase;

@Entity
@Table(name = "pregunta")
public class Pregunta extends EntidadBase {

	@Column(length = 150, nullable = false)
	private String enunciado;

	@OneToMany(mappedBy = "pregunta")
	private Set<Opcion> opciones;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_evaluacion")
	private Evaluacion evaluacion;

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public Set<Opcion> getOpciones() {
		return opciones;
	}

	public void setOpciones(Set<Opcion> opciones) {
		this.opciones = opciones;
	}

	public Evaluacion getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}

}
