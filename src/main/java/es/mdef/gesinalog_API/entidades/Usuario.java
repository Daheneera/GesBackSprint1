package es.mdef.gesinalog_API.entidades;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="USUARIOS")
public class Usuario {
		public enum Role {
			Usuario, Administrador
		};
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@JsonIgnore
		private Long id;
		private String nombre;
		private String username;
		private String password;
		private Role tipoUser;
		@OneToMany(mappedBy = "usuario")
		private List<Valoracion> valoraciones;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
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
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Role getTipoUser() {
			return tipoUser;
		}
		public void setTipoUser(Role tipoUser) {
			this.tipoUser = tipoUser;
		}
		public List<Valoracion> getValoraciones() {
			return valoraciones;
		}
		public void setValoraciones(List<Valoracion> valoraciones) {
			this.valoraciones = valoraciones;
		}
		@Override
		public String toString() {
			return "Usuario [id=" + id + ", nombre=" + nombre + ", username=" + username + ", password=" + password
					+ ", tipoUser=" + tipoUser +  "]";
		}
		
		
		
}
