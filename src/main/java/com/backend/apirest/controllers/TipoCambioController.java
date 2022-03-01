package com.backend.apirest.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.apirest.models.entity.tipoCambio;
import com.backend.apirest.models.services.ITipoCambioService;

@RestController
@RequestMapping("/cambio")
public class TipoCambioController {

	@Autowired
	private ITipoCambioService cambioService;
	
	@GetMapping("/realizarcambio")
	public ResponseEntity<?> realizarCambio(@RequestParam(name = "monto") Float monto,
			@RequestParam(name = "monedaorigen") String monedaOrigen,
			@RequestParam(name = "monedadestino") String monedaDestino) {
		tipoCambio cambio = null;
		
		Map<String, Object> response = new HashMap<>();
		try {
			
			tipoCambio tipocambio = new tipoCambio();
			
			tipocambio.setMonto(monto);
			tipocambio.setMonedaOrigen(monedaOrigen);
			tipocambio.setMonedaDestino(monedaDestino);
					
			cambio = cambioService.guardarTipoCambio(tipocambio);
					
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la funcion");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("codigo", "500");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El cambio se ha realizado!");
		response.put("cambio", cambio);
		response.put("codigo", "200");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
}
