package es.mdef.gesinalog_API.REST.valoracion;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.luque.librerias.utilidades.IncidenciaImpl.Tipo;

@Relation(collectionRelation = "valoraciones-agrupadas")
public class SumaValoracionesModel extends RepresentationModel<SumaValoracionesModel> {

		private Tipo tipoIncidencia;
		private Long numeroValoraciones;
		private Long sumaPuntuaciones;
		public Tipo getTipoIncidencia() {
			return tipoIncidencia;
		}
		public void setTipoIncidencia(Tipo tipoIncidencia) {
			this.tipoIncidencia = tipoIncidencia;
		}
		public Long getNumeroValoraciones() {
			return numeroValoraciones;
		}
		public void setNumeroValoraciones(Long numeroValoraciones) {
			this.numeroValoraciones = numeroValoraciones;
		}
		public Long getSumaPuntuaciones() {
			return sumaPuntuaciones;
		}
		public void setSumaPuntuaciones(Long sumaPuntuaciones) {
			this.sumaPuntuaciones = sumaPuntuaciones;
		}
		@Override
		public String toString() {
			return "SumaValoracionesModel [tipoIncidencia=" + tipoIncidencia + ", numeroValoraciones="
					+ numeroValoraciones + ", sumaPuntuaciones=" + sumaPuntuaciones + "]";
		}
	
	
	
	
}
