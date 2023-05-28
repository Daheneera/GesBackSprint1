package es.mdef.gesinalog_API.REST.instalacion;

import org.springframework.stereotype.Component;

import es.mdef.gesinalog_API.entidades.Habitacion;
import es.mdef.gesinalog_API.entidades.InstalacionConId;
import es.mdef.gesinalog_API.entidades.ZonaGeneral;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.hateoas.server.RepresentationModelAssembler;


@Component
public class InstalacionAssembler implements RepresentationModelAssembler<InstalacionConId, InstalacionModel> {

	@Override
	public InstalacionModel toModel(InstalacionConId entity) {
		InstalacionModel model = new InstalacionModel();
		model.setA_c(entity.getA_c());
		model.setNombre(entity.getNombre());
		model.setTipoInstalacion(entity.getTipoInstalación());
		model.setMobiliario(entity.getMobiliario());
		model.add(
				linkTo(methodOn(InstalacionController.class).one(entity.getId())).withSelfRel()
				);
		return model;
	}
	public InstalacionModel toModel(Habitacion entity) {
		InstalacionModel model = new InstalacionModel();
		model.setA_c(entity.getA_c());
		model.setNombre(entity.getNombre());
		model.setMobiliario(entity.getMobiliario());
		model.setTipoInstalacion(entity.getTipoInstalación());
		model.setTelefono(entity.getTelefono());
		model.setTv(entity.getTv());
		model.setNumCamas(entity.getNumCamas());
		model.add(
				linkTo(methodOn(InstalacionController.class).one(entity.getId())).withSelfRel()
				);
		return model;
	}
	
	public InstalacionModel toModel(ZonaGeneral entity) {
		InstalacionModel model = new InstalacionModel();
		model.setA_c(entity.getA_c());
		model.setNombre(entity.getNombre());
		model.setMobiliario(entity.getMobiliario());
		model.setTipoInstalacion(entity.getTipoInstalación());
		model.setAforo(entity.getAforo());
		model.add(
				linkTo(methodOn(InstalacionController.class).one(entity.getId())).withSelfRel()
				);
		return model;
	}
	
	public InstalacionConId toEntity(InstalacionModel model) {
		InstalacionConId instalacion;
		
		switch(model.getTipoInstalacion()) {
		case Habitacion:
					Habitacion hab = new Habitacion();
					hab.setTelefono(model.getTelefono());
					hab.setTv(model.getTv());
					hab.setNumCamas(model.getNumCamas());
					instalacion = hab;
					break;
		case ZonaGeneral:
			ZonaGeneral zona = new ZonaGeneral();
					zona.setAforo(model.getAforo());
					instalacion=zona;
					break;
		default: 
					instalacion = new InstalacionConId();
		}
		instalacion.setNombre(model.getNombre());
		instalacion.setA_c(model.getA_c());
		instalacion.setMobiliario(model.getMobiliario());
		instalacion.setTipoInstalación(model.getTipoInstalacion());
		return instalacion;
	}
	
}
