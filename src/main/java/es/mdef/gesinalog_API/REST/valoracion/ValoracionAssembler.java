package es.mdef.gesinalog_API.REST.valoracion;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import es.mdef.gesinalog_API.entidades.Valoracion;



@Component
public class ValoracionAssembler implements RepresentationModelAssembler<Valoracion, ValoracionModel> {

	@Override
	public ValoracionModel toModel(Valoracion entity) {
		
		
		
		return null;
	}

}
