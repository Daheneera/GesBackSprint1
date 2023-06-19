package es.mdef.gesinalog_API.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.mdef.gesinalog_API.entidades.IncidenciaConId;

@RepositoryRestResource(path = "incidencias", collectionResourceRel = "incidencias")
public interface IncidenciaRepositorio extends JpaRepository<IncidenciaConId, Long> {

	@Query(value = "SELECT i.tipo_incidencia, COUNT(v.id), SUM(v.puntuacion), AVG(v.puntuacion) AS promedioPuntuacion " + "FROM incidencias i "
			+ "JOIN valoraciones v ON i.id = v.incidencia_id " + "GROUP BY i.tipo_incidencia", nativeQuery = true)
	List<Object[]> getValoracionesAgrupadasPorTipoIncidencia();

	@Query(value = "SELECT i.descripcion, i.fecha_Alta, i.fecha_Inicio, i.tipo_Incidencia, "
			+ "i.urgencia, i.instalacion_Id, COUNT(v.incidencia_Id) AS cantidadValoraciones, AVG(v.puntuacion) AS promedioPuntuacion, "
			+ "TO_CHAR(i.fecha_Inicio, 'Month') AS nombreMes, EXTRACT(YEAR FROM i.fecha_Inicio) AS año "
			+ "FROM Incidencias i " + "LEFT JOIN valoraciones v ON i.Id = v.incidencia_Id "
			+ "WHERE i.estado_Incidencia = 2 "
			+ "GROUP BY i.descripcion, i.estado_Incidencia, i.fecha_Alta, i.fecha_Inicio, i.tipo_Incidencia, "
			+ "i.urgencia, i.instalacion_Id, EXTRACT(MONTH FROM i.fecha_Alta) "
			+ "ORDER BY EXTRACT(YEAR FROM i.fecha_Inicio) DESC, EXTRACT(MONTH FROM i.fecha_Inicio) DESC", nativeQuery = true)
	List<Object[]> getIncidenciasPorTipoIncidenciaYMes();

}
