package es.mdef.gesinalog_API.entidades;

public class ValoracionesAgrupadas {

		private Long puntuacion;
		private Long incidenciaId;
		private Long usuarioId;
		public Long getPuntuacion() {
			return puntuacion;
		}
		public void setPuntuacion(Long puntuacion) {
			this.puntuacion = puntuacion;
		}
		public Long getIncidenciaId() {
			return incidenciaId;
		}
		public void setIncidenciaId(Long incidenciaId) {
			this.incidenciaId = incidenciaId;
		}
		public Long getUsuarioId() {
			return usuarioId;
		}
		public void setUsuarioId(Long usuarioId) {
			this.usuarioId = usuarioId;
		}
		@Override
		public String toString() {
			return "ValoracionesAgrupadas [puntuacion=" + puntuacion + ", incidenciaId=" + incidenciaId + ", usuarioId="
					+ usuarioId + "]";
		}
		
		
}
