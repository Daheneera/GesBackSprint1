package es.mdef.gesinalog_API.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.mdef.gesinalog_API.entidades.Usuario;
@RepositoryRestResource(path="usuarios",collectionResourceRel="usuarios")
public interface Usuariorepositorio extends JpaRepository<Usuario, Long> {

}
