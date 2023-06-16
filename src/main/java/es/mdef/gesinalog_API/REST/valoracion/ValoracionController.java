package es.mdef.gesinalog_API.REST.valoracion;

import java.util.ArrayList;
import java.util.Arrays;
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

import com.luque.librerias.utilidades.IncidenciaImpl.Tipo;

import es.mdef.gesinalog_API.GesinalogAPIApplication;
import es.mdef.gesinalog_API.Excepciones.RegisterNotFoundException;
import es.mdef.gesinalog_API.REST.incidencia.IncidenciaAssembler;
import es.mdef.gesinalog_API.entidades.Valoracion;
import es.mdef.gesinalog_API.repositorios.IncidenciaRepositorio;
import es.mdef.gesinalog_API.repositorios.ValoracionRepositorio;


@RestController
@RequestMapping("/valoraciones")
public class ValoracionController {

	private final ValoracionRepositorio repositorio;
	private final IncidenciaRepositorio incidenciaRepositorio;
	private final ValoracionAssembler assembler;
	private final ValoracionListaAssembler listaAssembler;
	private final IncidenciaAssembler incidenciaAssembler;
	private final Logger log;
	
	
	
	
	
	public ValoracionController(ValoracionRepositorio repositorio,IncidenciaRepositorio incidenciaRepositorio, ValoracionAssembler assembler,
			ValoracionListaAssembler listaAssembler, IncidenciaAssembler incidenciaAssembler) {
		this.repositorio = repositorio;
		this.incidenciaRepositorio = incidenciaRepositorio;
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
	
	
	    
	@GetMapping("/agrupadas-por-tipo-incidencia")
	public List<Object> obtenerValoracionesAgrupadasPorTipoIncidencia() {
	    List<Object[]> valoraciones = incidenciaRepositorio.getValoracionesAgrupadasPorTipoIncidencia();
	    List<Object> sumaValoraciones = new ArrayList<>();

	    for (Object[] resultado : valoraciones) {
	    	
	      	Byte tipoIncidenciaByte = (Byte) resultado[0];
	       	int ordinalTipo = tipoIncidenciaByte.intValue();
	       	
			Tipo tipoIncidencia = Tipo.values()[ordinalTipo];
	        Long numeroValoraciones =  (Long) resultado[1];
	        Long sumaPuntuaciones = (Long) resultado[2];
	        Double promedioPuntuaciones = (Double) resultado[3];

	        SumaValoracionesModel sumaValoracionesModel = new SumaValoracionesModel();
	        sumaValoracionesModel.setTipoIncidencia(tipoIncidencia);
	        sumaValoracionesModel.setSumaPuntuaciones(sumaPuntuaciones);
	        sumaValoracionesModel.setNumeroValoraciones(numeroValoraciones);
	        sumaValoracionesModel.setPromedioPuntuaciones(promedioPuntuaciones);

	       

	        sumaValoraciones.add(sumaValoracionesModel);
	    }

	    return sumaValoraciones;
	 
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
			val.setOpinion(model.getOpinion());
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
