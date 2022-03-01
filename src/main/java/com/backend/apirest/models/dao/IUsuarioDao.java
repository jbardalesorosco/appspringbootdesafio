package com.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.backend.apirest.models.entity.usuario;

public interface IUsuarioDao extends CrudRepository<usuario, Long> {

	@Query("select u from usuario u where u.username = ?1")
	public usuario buscarUsuario(String usuario);
	
}
