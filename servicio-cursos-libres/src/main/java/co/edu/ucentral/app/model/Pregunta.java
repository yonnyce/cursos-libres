package co.edu.ucentral.app.model;

import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.checkerframework.checker.nullness.Opt;

import com.fasterxml.jackson.annotation.JsonIgnore;

import co.edu.ucentral.app.servicio.common.base.entity.EntidadBase;

@Entity
@Table(name = "pregunta")
public class Pregunta extends EntidadBase {

	@Column(length = 150, nullable = false)
	private String enunciado;

	@OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL)
	private List<Opcion> opciones;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_evaluacion")
	private Evaluacion evaluacion;

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public List<Opcion> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<Opcion> opciones) {
		this.opciones = opciones;
	}

	public Evaluacion getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}

	public boolean respuestaCorrecta(Opcion opcion) {
		Optional<Opcion> optOpcion = this.opciones.stream().filter(opt -> opt.getCorrecta())
				.filter(opt -> opt.getId().equals(opcion.getId())).findAny();

		return optOpcion.isPresent();
	}

}
