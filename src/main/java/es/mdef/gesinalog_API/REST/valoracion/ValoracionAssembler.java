package es.mdef.gesinalog_API.REST.valoracion;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import es.mdef.gesinalog_API.REST.incidencia.IncidenciaController;
import es.mdef.gesinalog_API.REST.usuario.UsuarioController;
import es.mdef.gesinalog_API.entidades.Valoracion;



@Component
public class ValoracionAssembler implements RepresentationModelAssembler<Valoracion, ValoracionModel> {

	@Override
	public ValoracionModel toModel(Valoracion entity) {
		ValoracionModel model= new ValoracionModel();
		model.setPuntuacion(entity.getPuntuacion());
		model.setOpinion(entity.getOpinion());
		model.add(
				linkTo(methodOn(ValoracionController.class).one(entity.getId())).withSelfRel(),
				linkTo(methodOn(IncidenciaController.class).one(entity.getIncidencia().getId())).withRel("incidencia"),
				linkTo(methodOn(UsuarioController.class).one(entity.getUsuario().getId())).withRel("usuario")
				
				
				);
		
		
		return model;
	}
	
	public Valoracion toEntity(ValoracionModel model) {
		Valoracion valoracion = new Valoracion();
		valoracion.setPuntuacion(model.getPuntuacion());
		valoracion.setOpinion(model.getOpinion());
		valoracion.setIncidencia(model.getIncidencia());
		valoracion.setUsuario(model.getUsuario());
		return valoracion;
	}
	

}
