package com.angular.springboot.backend.apirest.models.services;

import java.util.List;

import com.angular.springboot.backend.apirest.models.entity.Comentario;

public interface IComentarioService {

	
	public List<Comentario> findAll();
	
	public Comentario findById(Long id);
	
	public Comentario save (Comentario comentario);
	
	public void delete (Long id);
}
