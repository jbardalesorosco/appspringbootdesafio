package com.backend.apirest.models.services;

import java.util.List;

import com.backend.apirest.models.entity.tipoCambio;
import com.backend.apirest.models.entity.tipoMoneda;

public interface ITipoMonedaService {

	public tipoMoneda guardarTipoMoneda(tipoMoneda tipocambio);
	public List<tipoMoneda> listTipoMoneda();
	public tipoMoneda listTipoMoneda(Long id);
	
}
