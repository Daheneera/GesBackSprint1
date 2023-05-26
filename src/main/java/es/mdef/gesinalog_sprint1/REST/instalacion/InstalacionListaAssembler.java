package es.mdef.gesinalog_sprint1.REST.instalacion;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.luque.librerias.entidades.Habitacion;
import com.luque.librerias.entidades.Instalacion;
import com.luque.librerias.entidades.ZonaGeneral;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class InstalacionListaAssembler implements RepresentationModelAssembler<Instalacion, InstalacionListaModel> {

	
	@Override
	public InstalacionListaModel toModel(Instalacion entity) {
		InstalacionListaModel model = new InstalacionListaModel();
		model.setNombre(entity.getNombre());
		model.setA_c(entity.getA_c());
		model.setMobiliario(entity.getMobiliario());
		model.setTipoInstalación(entity.getTipoInstalación());
		if(entity instanceof Habitacion) {
			Habitacion hab = (Habitacion) entity;
			model.setTelefono(hab.getTelefono());
			model.setTv(hab.getTv());
			model.setNumCamas(hab.getNumCamas());
		}
		if (entity instanceof ZonaGeneral) {
			ZonaGeneral zona = (ZonaGeneral) entity;
			model.setAforo(zona.getAforo());
		}
				
		model.add(
				linkTo(methodOn(InstalacionController.class).one(entity.getId())).withSelfRel()
				
				);
		return model;
	}

	public CollectionModel<InstalacionListaModel> toCollection(List<Instalacion> lista){
		CollectionModel<InstalacionListaModel> collection = CollectionModel.of(
								  lista.stream().map(this::toModel).collect(Collectors.toList()));
		collection.add(
				
				linkTo(methodOn(InstalacionController.class).all()).withRel("instalaciones")
				);
		return collection;
	}
	
}
