package com.backend.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.apirest.models.entity.tipoMoneda;
import com.backend.apirest.models.services.ITipoMonedaService;

@RestController
@RequestMapping("/moneda")
public class TipoMonedaController {
	
	@Autowired
	private ITipoMonedaService tipoMonedaService;

	@Secured({"ROLE_ADMIN"})
	@GetMapping("/tipomoneda")
	public List<tipoMoneda> listEstadoAplicativo(){
		return tipoMonedaService.listTipoMoneda();
	}
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/tipomoneda/{id}")
	public ResponseEntity<?> actualizarTipoMoneda(@RequestBody tipoMoneda tipomoneda, @PathVariable Long id) {
		tipoMoneda updTipoMoneda = null;
		
		Map<String, Object> response = new HashMap<>();
		tipoMoneda tipomonedaActual = tipoMonedaService.listTipoMoneda(id);
		
		if(tipomonedaActual == null) {
			response.put("mensaje", "Error, no se pudo editar la moneda actual no existe en la BD");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			tipomonedaActual.setTipoCambio(tipomoneda.getTipoCambio());		
			updTipoMoneda = tipoMonedaService.guardarTipoMoneda(tipomonedaActual);
					
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la funcion");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("codigo", "500");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Se actualizo el tipo de cambio!");
		response.put("cambio", updTipoMoneda);
		response.put("codigo", "200");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
}
