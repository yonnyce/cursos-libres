package co.edu.ucentral.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ResultadosEstudiante {

	private double nota = 0;
	private Boolean presentoElExamen;
	private int totalErradas = 0;
	private int totalCorrectas = 0;
	private int noRespondidas = 0;

	@JsonIgnore
	private EstudianteCurso estudianteCurso;

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public Boolean getPresentoElExamen() {
		return presentoElExamen;
	}

	public void setPresentoElExamen(Boolean presentoElExamen) {
		this.presentoElExamen = presentoElExamen;
	}

	public int getTotalErradas() {
		return totalErradas;
	}

	public void setTotalErradas(int totalErradas) {
		this.totalErradas = totalErradas;
	}

	public int getTotalCorrectas() {
		return totalCorrectas;
	}

	public void setTotalCorrectas(int totalCorrectas) {
		this.totalCorrectas = totalCorrectas;
	}

	public int getNoRespondidas() {
		return noRespondidas;
	}

	public void setNoRespondidas(int noRespondidas) {
		this.noRespondidas = noRespondidas;
	}

	public EstudianteCurso getEstudianteCurso() {
		return estudianteCurso;
	}

	public void setEstudianteCurso(EstudianteCurso estudianteCurso) {
		this.estudianteCurso = estudianteCurso;
	}

}
