package es.mdef.gesinalog_API.REST.valoracion;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import es.mdef.gesinalog_API.entidades.IncidenciaConId;
import es.mdef.gesinalog_API.entidades.Usuario;

@Relation(collectionRelation = "valoraciones")
public class ValoracionListaModel extends RepresentationModel<ValoracionListaModel> {
	private Long id;
	private Integer puntuacion;
	private IncidenciaConId incidencia;
	private Usuario usuario;
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
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "Valoracion [id=" + id + ", puntuacion=" + puntuacion + ", incidencia=" + incidencia + ", usuario="
				+ usuario + "]";
	}
	
}
