package es.mdef.gesinalog_API.REST.usuario;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import es.mdef.gesinalog_API.entidades.Usuario;


@Component
public class UsuarioAssembler implements RepresentationModelAssembler<Usuario, UsuarioModel> {

	@Override
	public UsuarioModel toModel(Usuario entity) {
		UsuarioModel model = new UsuarioModel();
		model.setNombre(entity.getNombre());
		model.setUsername(entity.getUsername());
		model.setTipoUser(entity.getTipoUser());
		model.add(
				linkTo(methodOn(UsuarioController.class).one(entity.getId())).withSelfRel()

				);
		return model;
	}

	public Usuario toentity(UsuarioModel model) {
		Usuario user = new Usuario();
		user.setNombre(model.getNombre());
		user.setUsername(model.getUsername());
		user.setTipoUser(model.getTipoUser());
		return user;
		
	}
	
}
