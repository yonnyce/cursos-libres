package co.edu.ucentral.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.app.model.Estudiante;

public interface EstudianteRespository extends JpaRepository<Estudiante, Long> {

}
