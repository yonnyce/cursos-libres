package co.edu.ucentral.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.app.model.Pregunta;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {

}
