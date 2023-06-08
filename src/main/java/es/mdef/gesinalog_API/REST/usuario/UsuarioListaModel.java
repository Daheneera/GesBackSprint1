package es.mdef.gesinalog_API.REST.usuario;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import es.mdef.gesinalog_API.entidades.Valoracion;
import es.mdef.gesinalog_API.entidades.Usuario.Role;

@Relation(collectionRelation = "usuarios")
public class UsuarioListaModel extends RepresentationModel<UsuarioListaModel> {

	private String nombre;
	private String username;
	private Role tipoUser;

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Role getTipoUser() {
		return tipoUser;
	}
	public void setTipoUser(Role tipoUser) {
		this.tipoUser = tipoUser;
	}
	@Override
	public String toString() {
		return "UsuarioListaModel [nombre=" + nombre + ", username=" + username + ", tipoUser=" + tipoUser + "]";
	}
	
	

}
