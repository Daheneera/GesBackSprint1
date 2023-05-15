package es.mdef.gesinalog_sprint1.entidades;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="INSTALACIONES")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name="usoInstalacion", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("I")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Instalacion {
	
		public enum Tipo {
			Habitacion, ZonaGeneral
		}
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		private String nombre;
		private Boolean a_c;
		private Tipo tipoInstalacion;
		private List<String> mobiliario;
		@OneToMany(mappedBy = "instalacion")
		List<Incidencia> incidencias;
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
		public Boolean getA_c() {
			return a_c;
		}
		public void setA_c(Boolean a_c) {
			this.a_c = a_c;
		}
		public List<Incidencia> getIncidencias() {
			return incidencias;
		}
		public void setIncidencias(List<Incidencia> incidencias) {
			this.incidencias = incidencias;
		}
		
		public Tipo getTipoInstalación() {
			return tipoInstalacion;
		}
		public void setTipoInstalación(Tipo tipoInstalación) {
			this.tipoInstalacion = tipoInstalación;
		}
		
		public List<String> getMobiliario() {
			return mobiliario;
		}
		public void setMobiliario(List<String> mobiliario) {
			this.mobiliario = mobiliario;
		}
		
		@Override
		public String toString() {
			return "Instalacion [id=" + id + ", nombre=" + nombre + ", a_c=" + a_c + ", incidencias=" + incidencias
					+ "]";
		}
		
		
		
		
}
