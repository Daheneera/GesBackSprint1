package es.mdef.gesinalog_API.REST.valoracion;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import es.mdef.gesinalog_API.REST.incidencia.IncidenciaController;
import es.mdef.gesinalog_API.REST.usuario.UsuarioController;
import es.mdef.gesinalog_API.entidades.Valoracion;

@Component
public class ValoracionListaAssembler implements RepresentationModelAssembler<Valoracion, ValoracionListaModel> {

	@Override
	public ValoracionListaModel toModel(Valoracion entity) {
		ValoracionListaModel model = new ValoracionListaModel();
		model.setPuntuacion(entity.getPuntuacion());
		model.setOpinion(entity.getOpinion());
		model.add(
				linkTo(methodOn(ValoracionController.class).one(entity.getId())).withSelfRel(),
				linkTo(methodOn(IncidenciaController.class).one(entity.getIncidencia().getId())).withRel("incidencia"),
				linkTo(methodOn(UsuarioController.class).one(entity.getUsuario().getId())).withRel("usuario")
				);

		return model;
	}

	public CollectionModel<ValoracionListaModel> toCollection (List<Valoracion> lista){
		CollectionModel<ValoracionListaModel> collection = CollectionModel.of(
				lista.stream().map(this::toModel).collect(Collectors.toList())
				);
		collection.add(
				linkTo(methodOn(ValoracionController.class).all()).withRel("valoraciones")
				
				);
		
		
		return collection;
		
	}
}
