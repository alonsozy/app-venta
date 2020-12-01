package com.app.store.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.store.entity.Cliente;
import com.app.store.service.IClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("")
@Api(tags = "CLIENTE")
public class ClienteController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IClientService clienteService;
	
	/**
	 * <p> Metodo para registrar un Cliente
	 * </p>
	 * @author Alonso
	 * @param Objeto User
	 * @return El cliente registrado
	 */
	@ApiOperation(value = "Create Client", notes = "")
	@ApiResponses({
		@ApiResponse(code = HttpServletResponse.SC_CREATED, message ="CREATED"), 
		@ApiResponse(code = HttpServletResponse.SC_METHOD_NOT_ALLOWED, message ="Invalid input") 
	})
	@PostMapping(path = "/createClients", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente createUser(@RequestBody Cliente cliente) {
		log.info("PostMapping - value: /createClients");
		return clienteService.createClient(cliente);
	}

}
