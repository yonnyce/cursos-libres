package co.edu.ucentral.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import co.edu.ucentral.app.servicio.common.base.entity.EntidadBase;

@Entity
@Table(name = "opcion")
public class Opcion extends EntidadBase {

	@Column(nullable = false, length = 50)
	private String enunciado;

	@Column(nullable = false)
	private Boolean correcta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pregunta")
	private Pregunta pregunta;

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public Boolean getCorrecta() {
		return correcta;
	}

	public void setCorrecta(Boolean correcta) {
		this.correcta = correcta;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

}
