package es.mdef.gesinalog_API.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.mdef.gesinalog_API.entidades.InstalacionConId;





@RepositoryRestResource(path="instalaciones",collectionResourceRel="instalaciones")
public interface InstalacionRepositorio extends JpaRepository<InstalacionConId, Long> {

}
