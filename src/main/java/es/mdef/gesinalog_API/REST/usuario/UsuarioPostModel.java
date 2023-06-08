package es.mdef.gesinalog_API.REST.usuario;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import es.mdef.gesinalog_API.entidades.Usuario.Role;

@Relation(itemRelation="usuario")
public class UsuarioPostModel extends RepresentationModel<UsuarioPostModel> {

	private String nombre;
	private String username;
	private String password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UsuarioPostModel [nombre=" + nombre + ", username=" + username + ", password=" + password
				+ ", tipoUser=" + tipoUser + "]";
	}
	

	
	
	
	
}
