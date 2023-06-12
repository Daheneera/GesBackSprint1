package es.mdef.gesinalog_API.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.mdef.gesinalog_API.entidades.Valoracion;


@RepositoryRestResource(path="valoraciones",collectionResourceRel="valoraciones")
public interface ValoracionRepositorio extends JpaRepository<Valoracion, Long> {

	
	
	
}
