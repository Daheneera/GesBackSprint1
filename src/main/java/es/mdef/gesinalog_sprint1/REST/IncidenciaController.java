package es.mdef.gesinalog_sprint1.REST;

import org.slf4j.Logger;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.mdef.gesinalog_sprint1.GesinalogSprint1Application;
import es.mdef.gesinalog_sprint1.Excepciones.RegisterNotFoundException;
import es.mdef.gesinalog_sprint1.entidades.Incidencia;
import es.mdef.gesinalog_sprint1.repositorios.IncidenciaRepositorio;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/incidencias")
public class IncidenciaController {

		private final IncidenciaRepositorio repositorio;
		private final IncidenciaAssembler assembler;
		private final IncidenciaListaAssembler listaAssembler;
		private final Logger log;

	
	public IncidenciaController(IncidenciaRepositorio repositorio, IncidenciaAssembler assembler,
				IncidenciaListaAssembler listaAssembler) {
		
			this.repositorio = repositorio;
			this.assembler = assembler;
			this.listaAssembler = listaAssembler;
			log = GesinalogSprint1Application.log;
		}









	@GetMapping("{id}")
	public IncidenciaModel one(@PathVariable Long id) {
		Incidencia incidencia = repositorio.findById(id).orElseThrow(
				()-> new RegisterNotFoundException(id, "incidencia"));
		log.info("Recuperada " + incidencia);
		return assembler.toModel(incidencia);
	}

	
	@GetMapping
	public CollectionModel<IncidenciaListaModel> all (){
		return  listaAssembler.toCollection(repositorio.findAll());
	}
	
	
	@PostMapping
	public IncidenciaModel add(@RequestBody IncidenciaModel model) {
		Incidencia incidencia = repositorio.save(assembler.toEntity(model));
		log.info("Añadida " + incidencia);
		return assembler.toModel(incidencia);
	}

	@PutMapping
	public IncidenciaModel edit(@PathVariable Long id, @RequestBody IncidenciaModel model) {
		
		Incidencia incidencia = repositorio.findById(id).map(
				inc ->{
					inc.setDescripcion(model.getDescripcion());
					inc.setEstadoIncidencia(model.getEstadoIncidencia());
					inc.setFechaAlta(model.getFechaAlta());
					inc.setFechaInicio(model.getFechaInicio());
					inc.setIdInstalacion(model.getIdInstalacion());
					inc.setTipoIncidencia(model.getTipoIncidencia());
					inc.setUrgencia(model.getUrgencia());
					return repositorio.save(inc);
				}).orElseThrow(()-> new RegisterNotFoundException(id, "incidencia"));
		log.info("Actualizada "+ incidencia);
		return assembler.toModel(incidencia);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		log.info("Borrada incidencia " + id);
		repositorio.deleteById(id);
	}








}
