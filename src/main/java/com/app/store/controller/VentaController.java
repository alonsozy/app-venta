package com.app.store.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.store.entity.Venta;
import com.app.store.service.IVentaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("")
@Api(tags = "VENTA")
public class VentaController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IVentaService ventaService;
	
	/**
	 * <p> Metodo para retornar la lista de Ventas de la BD
	 * </p>
	 * @author Alonso
	 * @param void
	 * @return La lista de Ventas 
	 */
	@ApiOperation(value = "Get all sales", notes = "Get all sales")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK") })
	@GetMapping(path = "/getsales", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<Venta> listSales() {
		log.info("GetMapping - value: /getsales");
		return ventaService.findAllSales();
	}
	
	/**
	 * <p> Metodo para registrar una Venta
	 * </p>
	 * @author Alonso
	 * @param Objeto Venta
	 * @return La Venta registrado
	 */
	@ApiOperation(value = "Create Sale", notes = "")
	@ApiResponses({
		@ApiResponse(code = HttpServletResponse.SC_CREATED, message ="CREATED"), 
		@ApiResponse(code = HttpServletResponse.SC_METHOD_NOT_ALLOWED, message ="Invalid input") 
	})
	@PostMapping(path = "/createSale", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public Venta createUser(@RequestBody Venta venta) {
		log.info("PostMapping - value: /createSale");
		return ventaService.createSale(venta);
	}
	
	/**
	 * <p> Metodo para obtener una Venta por Id
	 * </p>
	 * @author Alonso
	 * @param userId : Id de la Venta
	 * @return La venta registrada con el Id enviado
	 */
	@ApiOperation(value = " ", notes = "Get one Sale")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"), 
					@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message ="Invalid sale id"), 
					@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message ="Sale not found") 
	})
	@GetMapping(path = "/getSaleById/{saleId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Venta getUserByID(@PathVariable("saleId") Long id){
		log.info("GetMapping - value: /getSaleById/"+id);
		Venta venta=ventaService.findSale(id);
		if(null!=venta) {
		}else {
			
		}
		return venta;
	}
	
}
