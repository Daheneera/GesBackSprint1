package es.mdef.gesinalog_API.REST.valoracion;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import es.mdef.gesinalog_API.entidades.IncidenciaConId;
import es.mdef.gesinalog_API.entidades.Usuario;


@Relation(itemRelation = "valoracion")
public class ValoracionModel extends RepresentationModel<ValoracionModel> {
	private Integer puntuacion;
	private IncidenciaConId incidencia;
	private Usuario user;
	private String opinion;
	
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
		return "ValoracionModel [puntuacion=" + puntuacion + ", incidencia=" + incidencia + ", usuario=" + user
				+ ", opinion=" + opinion + "]";
	}
	
	
	
	
}
