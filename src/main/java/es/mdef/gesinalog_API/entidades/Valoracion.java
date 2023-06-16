package es.mdef.gesinalog_API.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="VALORACIONES")
public class Valoracion {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private Integer puntuacion;
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="IncidenciaId")
		private IncidenciaConId incidencia;
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="UsuarioId")
		private Usuario user;
		private String opinion;
		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
		}
		public Integer getPuntuacion() {
			return puntuacion;
		}
		public void setPuntuacion(Integer puntuacion) {
			this.puntuacion = puntuacion;
		}
		public IncidenciaConId getIncidencia() {
			return incidencia;
		}
		public void setIncidencia(IncidenciaConId incidencia) {
			this.incidencia = incidencia;
		}
		public Usuario getUsuario() {
			return user;
		}
		public void setUsuario(Usuario usuario) {
			this.user = usuario;
		}
		public String getOpinion() {
			return opinion;
		}

		public void setOpinion(String opinion) {
			this.opinion = opinion;
		}

		@Override
		public String toString() {
			return "Valoracion [id=" + id + ", puntuacion=" + puntuacion + ", incidencia=" + incidencia.getId() + ", usuario="
					+ user.getNombre() + ", opinion=" + opinion + "]";
		}

		
		
		
		
		
}
