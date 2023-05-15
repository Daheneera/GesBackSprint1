package es.mdef.gesinalog_sprint1.REST.incidencia;

import java.time.LocalDate;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import es.mdef.gesinalog_sprint1.entidades.Incidencia.Estado;
import es.mdef.gesinalog_sprint1.entidades.Incidencia.Prelacion;
import es.mdef.gesinalog_sprint1.entidades.Incidencia.Tipo;
import es.mdef.gesinalog_sprint1.entidades.Instalacion;

@Relation(itemRelation = "incidencias")
public class IncidenciaModel extends RepresentationModel<IncidenciaModel> {
	
			private String descripcion;
			private Estado estadoIncidencia;
			private LocalDate fechaAlta;
			private LocalDate fechaInicio;
			private Tipo tipoIncidencia;
			private Prelacion urgencia;
			private Instalacion instalacion;
			
			public String getDescripcion() {
				return descripcion;
			}
			public void setDescripcion(String descripcion) {
				this.descripcion = descripcion;
			}
			public Estado getEstadoIncidencia() {
				return estadoIncidencia;
			}
			public void setEstadoIncidencia(Estado estadoIncidencia) {
				this.estadoIncidencia = estadoIncidencia;
			}
			public LocalDate getFechaAlta() {
				return fechaAlta;
			}
			public void setFechaAlta(LocalDate fechaAlta) {
				this.fechaAlta = fechaAlta;
			}
			public LocalDate getFechaInicio() {
				return fechaInicio;
			}
			public void setFechaInicio(LocalDate fechaInicio) {
				this.fechaInicio = fechaInicio;
			}

			public Tipo getTipoIncidencia() {
				return tipoIncidencia;
			}
			public void setTipoIncidencia(Tipo tipoIncidencia) {
				this.tipoIncidencia = tipoIncidencia;
			}
			public Prelacion getUrgencia() {
				return urgencia;
			}
			public void setUrgencia(Prelacion urgencia) {
				this.urgencia = urgencia;
			}
			
			
			
			public Instalacion getInstalacion() {
				return instalacion;
			}
			public void setInstalacion(Instalacion instalacion) {
				this.instalacion = instalacion;
			}
			@Override
			public String toString() {
				return "IncidenciaModel [descripcion=" + descripcion + ", estadoIncidencia=" + estadoIncidencia
						+ ", fechaAlta=" + fechaAlta + ", fechaInicio=" + fechaInicio + ", tipoIncidencia="
						+ tipoIncidencia + ", urgencia=" + urgencia + "]";
			}
			
		
			
			
			
	}


