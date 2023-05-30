package es.mdef.gesinalog_API.REST.incidencia;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import es.mdef.gesinalog_API.REST.instalacion.InstalacionController;
import es.mdef.gesinalog_API.entidades.IncidenciaConId;
import es.mdef.gesinalog_API.entidades.InstalacionConId;



@Component
public class IncidenciaAssembler implements RepresentationModelAssembler<IncidenciaConId, IncidenciaModel> {

	@Override
	public IncidenciaModel toModel(IncidenciaConId entity) {
		IncidenciaModel model = new IncidenciaModel();
		model.setDescripcion(entity.getDescripcion());
		model.setEstadoIncidencia(entity.getEstadoIncidencia());
		model.setFechaAlta(entity.getFechaAlta());
		model.setFechaInicio(entity.getFechaInicio());
		model.setTipoIncidencia(entity.getTipoIncidencia());
		model.setUrgencia(entity.getUrgencia());
		model.add(
				linkTo(methodOn(IncidenciaController.class).one(entity.getId())).withSelfRel(),
				linkTo(methodOn(InstalacionController.class).one(((InstalacionConId)entity.getInstalacion()).getId())).withRel("Instalacion")
				);
		
		
		
		return model;
	}
	
	public IncidenciaConId toEntity(IncidenciaModel model) {
		IncidenciaConId incidencia = new IncidenciaConId();
	incidencia.setDescripcion(model.getDescripcion());
	incidencia.setEstadoIncidencia(model.getEstadoIncidencia());
	incidencia.setFechaAlta(model.getFechaAlta());
	incidencia.setFechaInicio(model.getFechaInicio());
	incidencia.setTipoIncidencia(model.getTipoIncidencia());
	incidencia.setUrgencia(model.getUrgencia());
	incidencia.setInstalacion(model.getInstalacion());
		return incidencia;
	}

}
