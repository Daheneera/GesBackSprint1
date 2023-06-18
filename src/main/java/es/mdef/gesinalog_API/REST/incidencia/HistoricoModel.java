package es.mdef.gesinalog_API.REST.incidencia;

import java.time.LocalDate;

import org.springframework.hateoas.RepresentationModel;

import com.luque.librerias.utilidades.IncidenciaImpl.Prelacion;
import com.luque.librerias.utilidades.IncidenciaImpl.Tipo;


public class HistoricoModel extends RepresentationModel<HistoricoModel> {

	
		private String descripcion;
		private LocalDate fechaAlta;
		private LocalDate fechaInicio;
		private Tipo tipoIncidencia;
		private Prelacion urgencia;
		private Long cantidadValoraciones;
		private Double promedioPuntuacion;
		private String mes;
		private String anno;
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
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
	
		public Long getCantidadValoraciones() {
			return cantidadValoraciones;
		}
		public void setCantidadValoraciones(Long cantidadValoraciones) {
			this.cantidadValoraciones = cantidadValoraciones;
		}
		public Double getPromedioPuntuacion() {
			return promedioPuntuacion;
		}
		public void setPromedioPuntuacion(Double promedioPuntuacion) {
			this.promedioPuntuacion = promedioPuntuacion;
		}
		public String getMes() {
			return mes;
		}
		public void setMes(String mes) {
			this.mes = mes;
		}
		public String getAnno() {
			return anno;
		}
		public void setAnno(String anno) {
			this.anno = anno;
		}
		@Override
		public String toString() {
			return "HistoricoModel [descripcion=" + descripcion + ", fechaAlta=" + fechaAlta + ", fechaInicio="
					+ fechaInicio + ", tipoIncidencia=" + tipoIncidencia + ", urgencia=" + urgencia
					+ ", cantidadValoraciones=" + cantidadValoraciones + ", promedioPuntuacion=" + promedioPuntuacion
					+ ", mes=" + mes + ", anno=" + anno + "]";
		}
	
		
	
		
		
	
	
}
