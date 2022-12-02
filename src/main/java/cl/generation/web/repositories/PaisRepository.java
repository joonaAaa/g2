package cl.generation.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.generation.web.models.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
   // repository:su funcion es conectarnos con la base de datos
}
