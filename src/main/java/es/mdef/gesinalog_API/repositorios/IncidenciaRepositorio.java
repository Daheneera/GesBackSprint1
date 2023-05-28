package es.mdef.gesinalog_API.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import es.mdef.gesinalog_API.entidades.IncidenciaConId;






public interface IncidenciaRepositorio extends JpaRepository<IncidenciaConId, Long> {

}
