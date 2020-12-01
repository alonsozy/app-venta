package com.app.store;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.app.store.controller.ProductoController;
import com.app.store.entity.Producto;
import com.app.store.service.IProductoService;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


@RunWith(SpringRunner.class)
@WebMvcTest(ProductoController.class)
public class ProductoControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	IProductoService productService;

	
	private String urlListUsers;
	private String urlCreateUser;
	private String urlUserByID;
	private String urlUpdateUser;
	private String urlDeleteUser;
	List<Producto> lstUsers = new ArrayList<Producto>();
	
	@Before
	public void setUp() {
		urlListUsers = "/getproducts";
		urlCreateUser = "/createProduct";
		urlUserByID = "/getProductById/_id";
		urlUpdateUser = "/updateProductById/_id";
		urlDeleteUser = "/deleteProductById/_id";
		llenarList();
	}
	
	@Test
	public void lisProductsTest_Status() throws Exception {

		when(productService.findAllProducts()).thenReturn(lstUsers);
		mvc.perform(get(urlListUsers)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void listUsersTest_Data() throws Exception {

		String jsonRpta="[{\"idProducto\":1,\"nombre\":\"PSP\",\"precio\":350.10}]";
		when(productService.findAllProducts()).thenReturn(lstUsers);
		MvcResult result = mvc.perform(get(urlListUsers)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
		
		String text=result.getResponse().getContentAsString();
		JsonElement r = JsonParser.parseString(text);
		assertTrue(r.isJsonArray());
		assertEquals(r, JsonParser.parseString(jsonRpta));
	}
	
	@Test
	public void ProductTest_Data() throws Exception{
		System.out.println("**********************");
		String requestJson="{\"idProducto\":1,\"nombre\":\"PSP\",\"precio\":350.10}";
		when(productService.createProduct(new Producto())).thenReturn(llenarProductos());
		mvc.perform(post(urlCreateUser)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andExpect(status().is(HttpStatus.CREATED.value()))
				.andDo(mvcResult -> {
		            String json = mvcResult.getResponse().getContentAsString();
		        });;
	}
	
	@Test
	public void getUserByIDTest_Status() throws Exception {

		Long idProduct=1L;
		urlUserByID=urlUserByID.replaceAll("_id", idProduct.toString());
		when(productService.findProduct(1L)).thenReturn(llenarProductos());
		mvc.perform(get(urlUserByID)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}
	
	@Test
	public void getUserByIDTest_Status400() throws Exception {
	    
		urlUserByID=urlUserByID.replaceAll("_id", "abc");
		mvc.perform(
				get(urlUserByID).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}
	
	
	private Producto llenarProductos() {
		Producto u1 = new Producto();
		u1.setIdProducto(1);
		u1.setNombre("PSP");
		u1.setPrecio(350.10);
		
		return u1;
		
	}
	public void llenarList() {
		lstUsers.add(llenarProductos());
	}
	
}
