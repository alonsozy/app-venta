package com.app.store.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.store.dto.TProducto;
import com.app.store.entity.Producto;
import com.app.store.service.IProductoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("")
@Api(tags = "PRODUCTO")
public class ProductoController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IProductoService prodService;

	/**
	 * <p> Metodo para retornar la lista de Productos de la BD
	 * </p>
	 * @author Alonso
	 * @param void
	 * @return La lista de Productos 
	 */
	@ApiOperation(value = "Get all products", notes = "Get all products")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK") })
	@GetMapping(path = "/getproducts", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<Producto> listUsers() {
		log.info("GetMapping - value: /getproducts");
		return prodService.findAllProducts();
	}

	
	/**
	 * <p> Metodo para registrar un Producto
	 * </p>
	 * @author Alonso
	 * @param Objeto Producto
	 * @return El producto registrado
	 */
	@ApiOperation(value = "Create Producto", notes = "")
	@ApiResponses({
		@ApiResponse(code = HttpServletResponse.SC_CREATED, message ="CREATED"), 
		@ApiResponse(code = HttpServletResponse.SC_METHOD_NOT_ALLOWED, message ="Invalid input") 
	})
	@PostMapping(path = "/createProduct", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public Producto createUser(@RequestBody Producto prod) {
		log.info("PostMapping - value: /createProduct");
		return prodService.createProduct(prod);
	}

	
	/**
	 * <p> Metodo para obtener un Producto por Id
	 * </p>
	 * @author Alonso
	 * @param userId : Id del Producto
	 * @return El producto registrado con el Id enviado
	 */
	@ApiOperation(value = " ", notes = "Get one Producto")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"), 
					@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message ="Invalid user id"), 
					@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message ="Product not found") 
	})
	@GetMapping(path = "/getProductById/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Producto getUserByID(@PathVariable("productId") Long id){
		log.info("GetMapping - value: /getProductById/"+id);
		Producto user=prodService.findProduct(id);
		if(null!=user) {
		}else {
			
		}
		return user;
	}
	
	
	/**
	 * <p> Metodo para actualizar un Producto, asi como tambien se actualizara los campos de auditoria (Fecha y motivo)
	 * </p>
	 * @author Alonso
	 * @param userId : Id del Producto, Objeto Producto
	 * @return El usuario actualizado con el Id enviado
	 */
	@ApiOperation(value = "", notes = "")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"), 
					@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message ="Invalid product id"), 
					@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message ="Product not found") 
	})
	@PutMapping(path = "/updateProductById/{productId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Producto putUser(@PathVariable("productId") Long productId,@RequestBody Producto prod) {
		log.info("PutMapping - value: /updateProductById/"+productId);
		Optional<TProducto> bean=prodService.findTProducto(productId);
		if(bean.isPresent()) {
			prod=prodService.editProduct(productId, prod,bean.get());
		}else {
			
		}
		return prod;
	}
	
	
	/**
	 * <p> Metodo para eliminar un Producto, asi como tambien se actualizara los campos de auditoria (Fecha y motivo)
	 * </p>
	 * @author Alonso
	 * @param userId : Id del Producto
	 * @return 
	 */
	@ApiOperation(value = "", notes = "")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"), 
					@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message ="Invalid product id"), 
					@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message ="Product not found") 
	})
	@DeleteMapping(path = "/deleteProductById/{prodId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteUser(@PathVariable("prodId") Long prodId) {
		log.info("DeleteMapping - value: /deleteProductById/"+prodId);
		Optional<TProducto> bean=prodService.findTProducto(prodId);
		if(bean.isPresent()) {
			prodService.deleteProduct(bean.get());
		}else {
			//throw new UserNotFoundException("User not found");
		}
	}
	
}
