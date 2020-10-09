package co.edu.ucentral.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.app.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Optional<Curso> findByNombre(String nombre);

}
