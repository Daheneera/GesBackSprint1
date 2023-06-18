package es.mdef.gesinalog_API.REST.usuario;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.mdef.gesinalog_API.GesinalogAPIApplication;
import es.mdef.gesinalog_API.Excepciones.RegisterNotFoundException;
import es.mdef.gesinalog_API.REST.instalacion.InstalacionController;
import es.mdef.gesinalog_API.REST.valoracion.ValoracionListaAssembler;
import es.mdef.gesinalog_API.REST.valoracion.ValoracionListaModel;
import es.mdef.gesinalog_API.entidades.IncidenciaConId;
import es.mdef.gesinalog_API.entidades.Usuario;
import es.mdef.gesinalog_API.entidades.Valoracion;
import es.mdef.gesinalog_API.repositorios.Usuariorepositorio;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	private final Usuariorepositorio repositorio;
	private final UsuarioAssembler assembler;
	private UsuarioPostAssembler postAssembler;	
	private UsuarioListaAssembler listaAssembler;
	private ValoracionListaAssembler valoracionListaAssembler;

	private final Logger log;
	
	
	
	
	

	public UsuarioController(Usuariorepositorio repositorio, UsuarioAssembler assembler,
			UsuarioPostAssembler postAssembler, UsuarioListaAssembler listaAssembler,
			ValoracionListaAssembler valoracionListaAssembler) {
	
		this.repositorio = repositorio;
		this.assembler = assembler;
		this.postAssembler = postAssembler;
		this.listaAssembler = listaAssembler;
		this.valoracionListaAssembler = valoracionListaAssembler;
		log= GesinalogAPIApplication.log;
	}

	@GetMapping("{id}")
	public UsuarioModel one(@PathVariable Long id) {
		Usuario usuario = repositorio.findById(id)
				.orElseThrow(() -> new RegisterNotFoundException(id, "usuario"));
			
	//	log.info("Recuperado " + usuario);
		return assembler.toModel(usuario);
	}
	
	@GetMapping("{id}/valoraciones")
	public CollectionModel<ValoracionListaModel> valoraciones(@PathVariable Long id) {
		Usuario usuario = repositorio.findById(id)
				.orElseThrow(() -> new RegisterNotFoundException(id, "usuario"));
	
		Link link = linkTo(methodOn(UsuarioController.class).one(id)).withSelfRel();
		link = Link.of(link.getHref() + "/valoraciones", "valoraciones");
	    return valoracionListaAssembler.toCollection(usuario.getValoraciones());
	}
	


	
	
	@GetMapping
	public CollectionModel<UsuarioListaModel> all(){
		return listaAssembler.toList(repositorio.findAll());
	}
	
	
	@PostMapping
	public UsuarioModel add( @RequestBody UsuarioPostModel model) {
		Usuario user = repositorio.save(postAssembler.toEntity(model));
		log.info("nuevo usuario");		
		return assembler.toModel(user);
		}
	
	
	@PutMapping("{id}")
	public UsuarioModel edit( @PathVariable Long id, @RequestBody UsuarioModel model) {
		Usuario usuario = repositorio.findById(id).map(u -> {
			u.setNombre(model.getNombre());
			u.setUsername(model.getUsername());
			u.setTipoUser(model.getTipoUser());
			return repositorio.save(u);
			}).orElseThrow(()->new RegisterNotFoundException(id, "usuario"));
			
		log.info("Actualizado "+usuario);
		return assembler.toModel(usuario);
	}
	
	
//	@PutMapping("{id}/password")
//	public void updatePassword(@PathVariable Long id, @RequestParam String password) {
//	Usuario usuario = repositorio.findById(id)
//	.orElseThrow(() -> new RegisterNotFoundException(id, "usuario"));
//	usuario.setPassword(password); // actualiza el password
//	usuario = repositorio.save(usuario);
//	
//	}
	
	@PatchMapping
	public UsuarioModel edit(@PathVariable Long id, @RequestBody String newPassword) {
		Usuario usuario = repositorio.findById(id).map(u ->{
								u.setPassword(newPassword);
								return repositorio.save(u);
								}).orElseThrow(()->new RegisterNotFoundException(id, "usuario"));
		log.info("Actualizado "+ usuario);
		repositorio.save(usuario);
		return assembler.toModel(usuario);
	}
	
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		log.info("Borrado pedido " + id);
		repositorio.deleteById(id);
	}


}
