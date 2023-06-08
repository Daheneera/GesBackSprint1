package es.mdef.gesinalog_API.REST.usuario;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import es.mdef.gesinalog_API.REST.valoracion.ValoracionController;
import es.mdef.gesinalog_API.REST.valoracion.ValoracionListaModel;
import es.mdef.gesinalog_API.entidades.Usuario;


@Component
public class UsuarioListaAssembler implements RepresentationModelAssembler<Usuario, UsuarioListaModel> {

	@Override
	public UsuarioListaModel toModel(Usuario entity) {
		UsuarioListaModel model = new UsuarioListaModel();
		model.setNombre(entity.getNombre());
		model.setUsername(entity.getUsername());
		model.setTipoUser(entity.getTipoUser());
		model.add(
				linkTo(methodOn(UsuarioController.class).one(entity.getId())).withSelfRel()
				);

		return model;
	}

	 
	public CollectionModel<UsuarioListaModel> toList(List<Usuario> lista){
		CollectionModel<UsuarioListaModel> collection = CollectionModel.of(
				lista.stream().map(this::toModel).collect(Collectors.toList())
				);
			collection.add(
				linkTo(methodOn(UsuarioController.class).all()).withRel("usuarios")
				
				);
		
		return collection;
		
	}
}
