package es.mdef.gesinalog_API.REST.usuario;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import es.mdef.gesinalog_API.entidades.Usuario;

@Component
public class UsuarioPostAssembler implements RepresentationModelAssembler<Usuario, UsuarioPostModel> {

	@Override
	public UsuarioPostModel toModel(Usuario entity) {
		UsuarioPostModel model = new UsuarioPostModel();
		model.setNombre(entity.getNombre());
		model.setUsername(entity.getUsername());
		model.setTipoUser(entity.getTipoUser());
		model.setPassword(entity.getPassword());
		model.add(
				linkTo(methodOn(UsuarioController.class).one(entity.getId())).withSelfRel()

				);
		return model;
	}

	public Usuario toEntity(UsuarioPostModel model) {
		Usuario user = new Usuario();
		user.setNombre(model.getNombre());
		user.setUsername(model.getUsername());
		user.setTipoUser(model.getTipoUser());
		user.setPassword(model.getPassword());
		return user;
		
	}
}
