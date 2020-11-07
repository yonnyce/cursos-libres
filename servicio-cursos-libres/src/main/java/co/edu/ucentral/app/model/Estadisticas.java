package co.edu.ucentral.app.model;

public class Estadisticas {

	long numeroEstudiantesAprobados = 0;
	long numeroEstudiantesReprobados = 0;
	long totalEstudiantesPresentaronElExamen = 0;
	double promedioGeneral = 0.0;

	public long getNumeroEstudiantesAprobados() {
		return numeroEstudiantesAprobados;
	}

	public void setNumeroEstudiantesAprobados(long numeroEstudiantesAprobados) {
		this.numeroEstudiantesAprobados = numeroEstudiantesAprobados;
	}

	public long getNumeroEstudiantesReprobados() {
		return numeroEstudiantesReprobados;
	}

	public void setNumeroEstudiantesReprobados(long numeroEstudiantesReprobados) {
		this.numeroEstudiantesReprobados = numeroEstudiantesReprobados;
	}

	public long getTotalEstudiantesPresentaronElExamen() {
		return totalEstudiantesPresentaronElExamen;
	}

	public void setTotalEstudiantesPresentaronElExamen(long totalEstudiantesPresentaronElExamen) {
		this.totalEstudiantesPresentaronElExamen = totalEstudiantesPresentaronElExamen;
	}

	public double getPromedioGeneral() {
		return promedioGeneral;
	}

	public void setPromedioGeneral(double promedioGeneral) {
		this.promedioGeneral = promedioGeneral;
	}

}
