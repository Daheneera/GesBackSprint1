package es.mdef.gesinalog_API.entidades;

import java.time.LocalDate;
import java.util.List;

import com.luque.librerias.utilidades.Incidencia;
import com.luque.librerias.utilidades.IncidenciaImpl;

import jakarta.persistence.OneToMany;



public class IncidenciaConId extends IncidenciaImpl implements Incidencia{

	
	
	private Long id;
	private InstalacionConId instalacion;
	private List<Valoracion> valoraciones;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public InstalacionConId getInstalacion() {
		return instalacion;
	}
	public void setInstalacion(InstalacionConId instalacion) {
		this.instalacion = instalacion;
	}
	public List<Valoracion> getValoraciones() {
		return valoraciones;
	}
	public void setValoraciones(List<Valoracion> valoraciones) {
		this.valoraciones = valoraciones;
	}
	@Override
	public String toString() {
		return "IncidenciaConId [id=" + id + ", instalacion=" + instalacion + ", valoraciones=" + valoraciones
				+ ", getDescripcion()=" + getDescripcion() + ", getEstadoIncidencia()=" + getEstadoIncidencia()
				+ ", getFechaAlta()=" + getFechaAlta() + ", getFechaInicio()=" + getFechaInicio()
				+ ", getTipoIncidencia()=" + getTipoIncidencia() + ", getUrgencia()=" + getUrgencia() + "]";
	}
	
	
	

	



		
		
}
