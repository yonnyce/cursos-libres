package co.edu.ucentral.app.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import co.edu.ucentral.app.servicio.common.base.entity.EntidadBase;

@Entity
@Table(name = "respuesta_estudiante")
public class RespuestaEstudiante extends EntidadBase {

	@ManyToOne
	@JoinColumn(name = "id_opcion", nullable = false)
	private Opcion opcion;

	@ManyToOne
	@JoinColumn(name = "id_estudiante_curso", nullable = false)
	private EstudianteCurso estudianteCurso;

	public Opcion getOpcion() {
		return opcion;
	}

	public void setOpcion(Opcion opcion) {
		this.opcion = opcion;
	}

	public EstudianteCurso getEstudianteCurso() {
		return estudianteCurso;
	}

	public void setEstudianteCurso(EstudianteCurso estudianteCurso) {
		this.estudianteCurso = estudianteCurso;
	}

}
