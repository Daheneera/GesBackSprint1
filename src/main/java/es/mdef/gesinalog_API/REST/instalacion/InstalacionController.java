package es.mdef.gesinalog_API.REST.instalacion;


import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.slf4j.Logger;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luque.librerias.utilidades.InstalacionImpl.Tipo;

import es.mdef.gesinalog_API.GesinalogAPIApplication;
import es.mdef.gesinalog_API.Excepciones.RegisterNotFoundException;
import es.mdef.gesinalog_API.REST.incidencia.IncidenciaAssembler;
import es.mdef.gesinalog_API.REST.incidencia.IncidenciaListaAssembler;
import es.mdef.gesinalog_API.REST.incidencia.IncidenciaListaModel;
import es.mdef.gesinalog_API.REST.incidencia.IncidenciaModel;
import es.mdef.gesinalog_API.entidades.Habitacion;
import es.mdef.gesinalog_API.entidades.IncidenciaConId;
import es.mdef.gesinalog_API.entidades.InstalacionConId;
import es.mdef.gesinalog_API.entidades.ZonaGeneral;
import es.mdef.gesinalog_API.repositorios.InstalacionRepositorio;


//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/instalaciones")
public class InstalacionController {

	private final InstalacionRepositorio repositorio;
	private final InstalacionAssembler assembler;
	private final InstalacionListaAssembler listaAssembler;
	private final IncidenciaListaAssembler incidenciaListaAssembler;
	private final Logger log;
	
		
	public InstalacionController(InstalacionRepositorio repositorio, InstalacionAssembler assembler,
			InstalacionListaAssembler listaAssembler, IncidenciaListaAssembler incidenciaListaAssembler) {
		
		this.repositorio = repositorio;
		this.assembler = assembler;
		this.listaAssembler = listaAssembler;
		this.incidenciaListaAssembler= incidenciaListaAssembler;
		this.log = GesinalogAPIApplication.log;
	}

	@GetMapping("{id}")
	public InstalacionModel one(@PathVariable Long id) {
		InstalacionConId instalacion = repositorio.findById(id)
				.orElseThrow(() -> new RegisterNotFoundException(id, "instalacion"));
		log.info("Recuperada " + instalacion);
		return assembler.toModel(instalacion);
	}

	@GetMapping
	public CollectionModel<InstalacionListaModel> all(){
		return listaAssembler.toCollection(repositorio.findAll());
	}

	
	@GetMapping("{id}/incidencias")
	public CollectionModel<IncidenciaListaModel> incidencias(@PathVariable Long id) {
		InstalacionConId instalacion = repositorio.findById(id)
				.orElseThrow(() -> new RegisterNotFoundException(id, "instalacion"));
	
				
	    return incidenciaListaAssembler.toCollection(instalacion.getIncidencias());
	}
	
	@PostMapping
	public InstalacionModel add(@RequestBody InstalacionModel model) {
		
		InstalacionConId instalacion;
		
		switch(model.getTipoInstalacion()) {
		case Habitacion:
			Habitacion hab = new Habitacion();
												
						hab = (Habitacion) assembler.toEntity(model);
						repositorio.save(hab);
						
						log.info("Añadida " + hab);
						return assembler.toModel(hab);
						
		case ZonaGeneral:
			ZonaGeneral zona = new ZonaGeneral();
			zona = (ZonaGeneral)assembler.toEntity(model);
			repositorio.save(zona);
			
			log.info("Añadida " + zona);
			return assembler.toModel(zona);
			
		
		default: 
			instalacion= new InstalacionConId();
			return assembler.toModel(instalacion);
		}
	}
	@PutMapping("{id}")
	public InstalacionModel edit( @PathVariable Long id, @RequestBody InstalacionModel model) {
		InstalacionConId instalacion = repositorio.findById(id).map(i -> {
			i.setNombre(model.getNombre());
			i.setA_c(model.getA_c());
			i.setMobiliario(model.getMobiliario());
			i.setTipoInstalación(model.getTipoInstalacion());
			
			if(i.getTipoInstalación()==Tipo.Habitacion) {
				((Habitacion) i).setTelefono(model.getTelefono());
				((Habitacion) i).setTv(model.getTv());
				((Habitacion) i).setNumCamas(model.getNumCamas());
			}else if (i.getTipoInstalación()==Tipo.ZonaGeneral) {
				((ZonaGeneral) i).setAforo(model.getAforo());
			}
			return repositorio.save(i);
			}).orElseThrow(()->new RegisterNotFoundException(id, "instalacion"));
			
		log.info("Actualizada "+instalacion);
		
		if(instalacion.getTipoInstalación()==Tipo.Habitacion) {
		return assembler.toModel((Habitacion)instalacion);
		}else if(instalacion.getTipoInstalación()==Tipo.ZonaGeneral) {
			return assembler.toModel((ZonaGeneral)instalacion);
		}else return assembler.toModel(instalacion);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		log.info("Borrada instalacion " + id);
		repositorio.deleteById(id);
	}

}
