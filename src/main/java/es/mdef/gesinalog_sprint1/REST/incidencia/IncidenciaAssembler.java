package es.mdef.gesinalog_sprint1.REST.incidencia;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.luque.librerias.entidades.Incidencia;

import es.mdef.gesinalog_sprint1.REST.instalacion.InstalacionController;



@Component
public class IncidenciaAssembler implements RepresentationModelAssembler<Incidencia, IncidenciaModel> {

	@Override
	public IncidenciaModel toModel(Incidencia entity) {
		IncidenciaModel model = new IncidenciaModel();
		model.setDescripcion(entity.getDescripcion());
		model.setEstadoIncidencia(entity.getEstadoIncidencia());
		model.setFechaAlta(entity.getFechaAlta());
		model.setFechaInicio(entity.getFechaInicio());
		model.setTipoIncidencia(entity.getTipoIncidencia());
		model.setUrgencia(entity.getUrgencia());
		model.add(
				linkTo(methodOn(IncidenciaController.class).one(entity.getId())).withSelfRel(),
				linkTo(methodOn(InstalacionController.class).one(entity.getInstalacion().getId())).withRel("Instalacion")
				);
		
		
		
		return model;
	}
	
	public Incidencia toEntity(IncidenciaModel model) {
		Incidencia incidencia = new Incidencia();
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
