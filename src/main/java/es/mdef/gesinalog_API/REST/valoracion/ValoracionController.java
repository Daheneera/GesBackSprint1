package es.mdef.gesinalog_API.REST.valoracion;

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

import es.mdef.gesinalog_API.GesinalogAPIApplication;
import es.mdef.gesinalog_API.Excepciones.RegisterNotFoundException;
import es.mdef.gesinalog_API.REST.incidencia.IncidenciaAssembler;
import es.mdef.gesinalog_API.entidades.Valoracion;
import es.mdef.gesinalog_API.repositorios.ValoracionRepositorio;


@RestController
@RequestMapping("/valoraciones")
public class ValoracionController {

	private final ValoracionRepositorio repositorio;
	private final ValoracionAssembler assembler;
	private final ValoracionListaAssembler listaAssembler;
	private final IncidenciaAssembler incidenciaAssembler;
	private final Logger log;
	
	
	
	
	
	public ValoracionController(ValoracionRepositorio repositorio, ValoracionAssembler assembler,
			ValoracionListaAssembler listaAssembler, IncidenciaAssembler incidenciaAssembler) {
		this.repositorio = repositorio;
		this.assembler = assembler;
		this.listaAssembler = listaAssembler;
		this.incidenciaAssembler = incidenciaAssembler;
		log = GesinalogAPIApplication.log;
	}

	@GetMapping("{id}")
	public ValoracionModel one(@PathVariable Long id) {
		Valoracion valoracion = repositorio.findById(id).
				orElseThrow(()-> new RegisterNotFoundException(id, "valoracion"));
		log.info("Recuparada: " + valoracion);

		return assembler.toModel(valoracion);
	}

	@GetMapping
	public CollectionModel<ValoracionListaModel> all() {
		return listaAssembler.toCollection(repositorio.findAll());
	}
	
	@PostMapping
	public ValoracionModel add(@RequestBody ValoracionModel model) {
		Valoracion valoracion = repositorio.save(assembler.toEntity(model));
		log.info("Añadida: " + valoracion);
		return assembler.toModel(valoracion);
	}
	
	@PutMapping("{id}")
	public ValoracionModel edit(@PathVariable Long id, @RequestBody ValoracionModel model) {
		Valoracion valoracion = repositorio.findById(id).map(val->{
			val.setIncidencia(model.getIncidencia());
			val.setPuntuacion(model.getPuntuacion());
			val.setUsuario(model.getUsuario());
			return repositorio.save(val);
		}).orElseThrow(()->new RegisterNotFoundException(id, "valoracion"));
		log.info("Actualizada: "+ valoracion);
		return assembler.toModel(valoracion);
	}
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		log.info("Borrada valoración " + id);
		repositorio.deleteById(id);
	}
}
