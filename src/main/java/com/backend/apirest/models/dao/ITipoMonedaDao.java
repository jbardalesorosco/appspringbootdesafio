package com.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.backend.apirest.models.entity.tipoMoneda;

public interface ITipoMonedaDao extends CrudRepository<tipoMoneda, Long> {

}
