package com.angular.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.angular.springboot.backend.apirest.models.entity.Comentario;
import com.angular.springboot.backend.apirest.models.services.IComentarioService;

@CrossOrigin(origins = {"http://localhost:4200"} )
@RestController
@RequestMapping("/api")
public class ComentarioController {

	@Autowired
	private IComentarioService comentarioService;
	
	@GetMapping("/comentarios")
	public List<Comentario> index(){
		return comentarioService.findAll();
	}
	
	@GetMapping("/comentarios/{id}")
	public Comentario show(@PathVariable Long id) {
		return comentarioService.findById(id);
	}
	
	@PostMapping("/comentarios")
	@ResponseStatus(HttpStatus.CREATED)
	public Comentario create(@RequestBody Comentario comentario) {
		return comentarioService.save(comentario);
	}
	
	@PutMapping("/comentarios/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Comentario update(@RequestBody Comentario comentario, @PathVariable Long id) {
		Comentario comentarioActual = new Comentario();
		comentarioActual = comentarioService.findById(id);
		comentarioActual.setTitulo(comentario.getTitulo());
		comentarioActual.setCreador(comentario.getCreador());
		comentarioActual.setTexto(comentario.getTexto());
		
		return comentarioService.save(comentarioActual);
		
	}
	
	@DeleteMapping("/comentarios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Comentario existeComentario = comentarioService.findById(id);
		if(existeComentario != null) {
			comentarioService.delete(id);
		}
		
	}
	
	
	
	
	
	
	
}
