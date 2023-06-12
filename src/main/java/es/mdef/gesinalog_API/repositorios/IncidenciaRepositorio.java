package es.mdef.gesinalog_API.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import es.mdef.gesinalog_API.REST.valoracion.SumaValoracionesModel;
import es.mdef.gesinalog_API.entidades.IncidenciaConId;





@RepositoryRestResource(path="incidencias",collectionResourceRel="incidencias")
public interface IncidenciaRepositorio extends JpaRepository<IncidenciaConId, Long> {
	
	@Query("SELECT i.tipoIncidencia, COUNT(v), SUM(v.puntuacion) " +
		       "FROM IncidenciaConId i " +
		       "JOIN i.valoraciones v " +
		       "GROUP BY i.tipoIncidencia")

	    List<Object[]> getValoracionesAgrupadasPorTipoIncidencia();
}
