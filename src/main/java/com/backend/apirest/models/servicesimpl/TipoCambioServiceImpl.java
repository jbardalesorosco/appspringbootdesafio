package com.backend.apirest.models.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.apirest.models.dao.ITipoCambioDao;
import com.backend.apirest.models.entity.tipoCambio;
import com.backend.apirest.models.services.ITipoCambioService;

@Service
public class TipoCambioServiceImpl implements ITipoCambioService {
	
	@Autowired
	private ITipoCambioDao tipocambiodao;

	@Override
	public tipoCambio guardarTipoCambio(tipoCambio tipocambio) {

		tipoCambio tipocambiomoneda = new tipoCambio();
		
		Float montoCambio = 0.0F;
		
		
		if(tipocambio.getMonedaOrigen().equals("soles") && tipocambio.getMonedaDestino().equals("dolar")) {
			tipocambio.setTipoCambio(3.80F);
			montoCambio = tipocambio.getMonto() / tipocambio.getTipoCambio();
		} else if (tipocambio.getMonedaOrigen().equals("soles") && tipocambio.getMonedaDestino().equals("euro")){
			tipocambio.setTipoCambio(4.26F);
			montoCambio = tipocambio.getMonto() / tipocambio.getTipoCambio();
		} else {
			tipocambio.setTipoCambio(0.89F);
			montoCambio = tipocambio.getMonto() * tipocambio.getTipoCambio();
		}
		
		
		
		tipocambiomoneda.setMonedaDestino(tipocambio.getMonedaDestino());
		tipocambiomoneda.setMonedaOrigen(tipocambio.getMonedaOrigen());
		tipocambiomoneda.setMonto(tipocambio.getMonto());
		tipocambiomoneda.setTipoCambio(tipocambio.getTipoCambio());
		tipocambiomoneda.setMontoCambio(montoCambio);
				
		return tipocambiomoneda;
	}

}
