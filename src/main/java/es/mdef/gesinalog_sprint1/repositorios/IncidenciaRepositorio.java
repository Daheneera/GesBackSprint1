package es.mdef.gesinalog_sprint1.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import es.mdef.gesinalog_sprint1.entidades.Incidencia;

public interface IncidenciaRepositorio extends JpaRepository<Incidencia, Long> {

}
