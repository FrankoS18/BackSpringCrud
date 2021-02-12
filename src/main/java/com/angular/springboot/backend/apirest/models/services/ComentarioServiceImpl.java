package com.angular.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.angular.springboot.backend.apirest.models.dao.IComentarioDao;
import com.angular.springboot.backend.apirest.models.entity.Comentario;

@Service
public class ComentarioServiceImpl implements IComentarioService {

	@Autowired
	private IComentarioDao comentarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Comentario> findAll() {
		return (List<Comentario>) comentarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Comentario findById(Long id) {
		return comentarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Comentario save(Comentario comentario) {
		return comentarioDao.save(comentario);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		comentarioDao.deleteById(id);
		
	}

}
