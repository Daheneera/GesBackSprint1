package es.mdef.gesinalog_sprint1.REST.incidencia;

import java.time.LocalDate;



import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.luque.librerias.entidades.Incidencia.Estado;
import com.luque.librerias.entidades.Incidencia.Prelacion;
import com.luque.librerias.entidades.Incidencia.Tipo;



@Relation(collectionRelation = "incidencias")
public class IncidenciaListaModel extends RepresentationModel<IncidenciaListaModel> {
	private String descripcion;
	private Estado estadoIncidencia;
	private LocalDate fechaAlta;
	private LocalDate fechaInicio;
	private Tipo tipoIncidencia;
	private Prelacion urgencia;
	
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
	@Override
	public String toString() {
		return "IncidenciaListaModel [descripcion=" + descripcion + ", estadoIncidencia=" + estadoIncidencia
				+ ", fechaAlta=" + fechaAlta + ", fechaInicio=" + fechaInicio + ", tipoIncidencia=" + tipoIncidencia
				+ ", urgencia=" + urgencia + "]";
	}
	

	
	
}
