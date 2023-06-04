package es.mdef.gesinalog_API.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import es.mdef.gesinalog_API.entidades.Usuario;

public interface Usuariorepositorio extends JpaRepository<Usuario, Long> {

}
