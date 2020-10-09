package co.edu.ucentral.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ucentral.app.model.Facultad;

public interface FacultadRespository extends JpaRepository<Facultad, Long> {

	Optional<Facultad> findByNombre(String nombre);

}
