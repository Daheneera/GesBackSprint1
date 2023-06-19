package es.mdef.gesinalog_API.REST.incidencia;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import java.util.ArrayList;
import java.util.List;

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


import com.luque.librerias.utilidades.IncidenciaImpl.Prelacion;
import com.luque.librerias.utilidades.IncidenciaImpl.Tipo;


import es.mdef.gesinalog_API.GesinalogAPIApplication;
import es.mdef.gesinalog_API.Excepciones.RegisterNotFoundException;
import es.mdef.gesinalog_API.REST.instalacion.InstalacionController;
import es.mdef.gesinalog_API.REST.valoracion.ValoracionListaAssembler;
import es.mdef.gesinalog_API.REST.valoracion.ValoracionListaModel;
import es.mdef.gesinalog_API.entidades.IncidenciaConId;
import es.mdef.gesinalog_API.entidades.Valoracion;
import es.mdef.gesinalog_API.repositorios.IncidenciaRepositorio;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/incidencias")
public class IncidenciaController {

	private final IncidenciaRepositorio repositorio;
	private final IncidenciaAssembler assembler;
	private final IncidenciaListaAssembler listaAssembler;
	private final ValoracionListaAssembler valoracionListaAssembler;
	private final Logger log;

	public IncidenciaController(IncidenciaRepositorio repositorio, IncidenciaAssembler assembler,
			IncidenciaListaAssembler listaAssembler, ValoracionListaAssembler valoracionListaAssembler) {

		this.repositorio = repositorio;
		this.assembler = assembler;
		this.listaAssembler = listaAssembler;
		this.valoracionListaAssembler = valoracionListaAssembler;
		log = GesinalogAPIApplication.log;
	}

	@GetMapping("{id}")
	public IncidenciaModel one(@PathVariable Long id) {
		IncidenciaConId incidencia = repositorio.findById(id)
				.orElseThrow(() -> new RegisterNotFoundException(id, "incidencia"));
		log.info("Recuperada " + incidencia);
		return assembler.toModel(incidencia);
	}

	@GetMapping
	public CollectionModel<IncidenciaListaModel> all() {
		return listaAssembler.toCollection(repositorio.findAll());
	}

	@GetMapping("{id}/valoraciones")
	public CollectionModel<ValoracionListaModel> valoraciones(@PathVariable Long id) {
		IncidenciaConId incidencia = repositorio.findById(id)
				.orElseThrow(() -> new RegisterNotFoundException(id, "incidencia"));
		for (Valoracion valor :incidencia.getValoraciones()) {
			log.info(valor.toString());
		}	
		
	
		return valoracionListaAssembler.toCollection(incidencia.getValoraciones());
	}

	@GetMapping("/agrupadas-por-mes")
	public List<HistoricoModel> obtenerIncidenciasPorTipoIncidenciaYMes() {
		List<Object[]> IncidenciasPorTipoYMes = repositorio.getIncidenciasPorTipoIncidenciaYMes();
		List<HistoricoModel> historico = new ArrayList<>();

		for (Object[] resultado : IncidenciasPorTipoYMes) {
			String descripcion = (String) resultado[0];
			java.sql.Date fechaAltaSql = (java.sql.Date) resultado[1];
			java.time.LocalDate fechaAlta = fechaAltaSql.toLocalDate();
			java.sql.Date fechaInicioSql = (java.sql.Date) resultado[2];
			java.time.LocalDate fechaInicio = fechaInicioSql.toLocalDate();
			Object valorRecibido = resultado[3];
	    	int ordinalTipo = (int) valorRecibido;

			Tipo tipoIncidencia = Tipo.values()[ordinalTipo];
			Byte prelacionByte = (Byte) resultado[4];
			int ordinalPrelacion = prelacionByte.intValue();
			Prelacion urgencia = Prelacion.values()[ordinalPrelacion];

			Long instalacion = (Long) resultado[5];
			Long cantidadValoraciones = (Long) resultado[6];
			Double promedioPuntuacion = (Double) resultado[7];
			String mes = (String) resultado[8];
			String anno = resultado[9].toString();

			HistoricoModel model = new HistoricoModel();
			model.setDescripcion(descripcion);
			model.setFechaAlta(fechaAlta);
			model.setFechaInicio(fechaInicio);
			model.setTipoIncidencia(tipoIncidencia);
			model.setUrgencia(urgencia);
			model.setCantidadValoraciones(cantidadValoraciones);
			model.setPromedioPuntuacion(promedioPuntuacion);
			model.setMes(mes);
			model.setAnno(anno);
			model.add(linkTo(methodOn(InstalacionController.class).one(instalacion)).withRel("instalacion"));

			historico.add(model);

		}

		return historico;
	}

	@PostMapping
	public IncidenciaModel add(@RequestBody IncidenciaModel model) {
		IncidenciaConId incidencia = repositorio.save(assembler.toEntity(model));
		log.info("Añadida " + incidencia);
		return assembler.toModel(incidencia);
	}

	@PutMapping("{id}")
	public IncidenciaModel edit(@PathVariable Long id, @RequestBody IncidenciaModel model) {

		IncidenciaConId incidencia = repositorio.findById(id).map(inc -> {
			inc.setDescripcion(model.getDescripcion());
			inc.setEstadoIncidencia(model.getEstadoIncidencia());
			inc.setFechaAlta(model.getFechaAlta());
			inc.setFechaInicio(model.getFechaInicio());
			inc.setTipoIncidencia(model.getTipoIncidencia());
			inc.setUrgencia(model.getUrgencia());
			inc.setInstalacion(model.getInstalacion());
			return repositorio.save(inc);
		}).orElseThrow(() -> new RegisterNotFoundException(id, "incidencia"));
		log.info("Actualizada " + incidencia);
		return assembler.toModel(incidencia);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		log.info("Borrada incidencia " + id);
		repositorio.deleteById(id);
	}

}
