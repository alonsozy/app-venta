package com.app.store;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.app.store.dao.ProductoDao;
import com.app.store.dto.TProducto;
import com.app.store.entity.Producto;
import com.app.store.service.ProdServiceImpl;
import com.app.store.service.util.Constants;

@RunWith(MockitoJUnitRunner.class)
public class ProdServiceImplTest {
	
	@Mock
	ProductoDao productDao;

	@InjectMocks
	ProdServiceImpl prodService;
	
	List<TProducto> listTProducto;
	@Before
	public void setUp() {
		listTProducto = new ArrayList<TProducto>();
		listTProducto.add(getProducto());
	}
	
	@Test
	public void findTProductTest() throws Exception {
		Long id = 1L;
		TProducto prod = new TProducto();
		prod.setIdProducto(1L);
		Optional<TProducto> op = Optional.ofNullable(prod);
		when(productDao.findProdById(id, true)).thenReturn(op);

		op = prodService.findTProducto(id);
		assertTrue(op.isPresent());
		assertEquals(op.get().getIdProducto(), 1L);
	}
	
	@Test
	public void findTUserTest_NoData() throws Exception {
		Long id = -1L;
		Optional<TProducto> op = Optional.ofNullable(null);
		when(productDao.findProdById(id,true)).thenReturn(op);
		op = prodService.findTProducto(id);
		assertTrue(!op.isPresent());
	}

	@Test
	public void createProdTest() throws Exception{
		TProducto tprod = getProducto();
		Producto prod = new Producto();
		
		prod.setIdProducto(1L);
		prod.setNombre("PSP");
		prod.setPrecio(350.10);
		when(productDao.save(Mockito.any(TProducto.class))).thenReturn(tprod);
		Producto p2 = prodService.createProduct(prod);
		assertEquals(p2.getIdProducto(), 1L);
		assertEquals(tprod.getAudit_vobs(), Constants.OBSERV.CREATE);
		assertEquals(tprod.getEstado(), true);
		assertNull(tprod.getAudit_dfecope());
	}
	
	public TProducto getProducto() {
		TProducto p= new TProducto();
		p.setIdProducto(1L);
		p.setNombre("PSP");
		p.setPrecio(new BigDecimal(350.10));
		p.setEstado(true);
		p.setAudit_vuser("ROOT");
		p.setAudit_vobs(Constants.OBSERV.CREATE);
		p.setAudit_dfecre(LocalDateTime.now());
		p.setAudit_dfecope(null);
		return p;
	}
}
