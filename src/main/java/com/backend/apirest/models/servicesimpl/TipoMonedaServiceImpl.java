package com.backend.apirest.models.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.apirest.models.dao.ITipoCambioDao;
import com.backend.apirest.models.dao.ITipoMonedaDao;
import com.backend.apirest.models.entity.tipoMoneda;
import com.backend.apirest.models.services.ITipoMonedaService;

@Service
public class TipoMonedaServiceImpl implements ITipoMonedaService {

	@Autowired
	private ITipoMonedaDao tipoMonedaDao;
	
	@Override
	public tipoMoneda guardarTipoMoneda(tipoMoneda tipocambio) {
		return tipoMonedaDao.save(tipocambio);
	}

	@Override
	public List<tipoMoneda> listTipoMoneda() {		
		return (List<tipoMoneda>) tipoMonedaDao.findAll();
	}

	@Override
	public tipoMoneda listTipoMoneda(Long id) {
		return tipoMonedaDao.findById(id).orElse(null);
	}

}
