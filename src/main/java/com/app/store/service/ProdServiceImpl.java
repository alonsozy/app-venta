package com.app.store.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.store.dao.ProductoDao;
import com.app.store.dto.TProducto;
import com.app.store.entity.Producto;
import com.app.store.service.util.Constants;
import com.app.store.service.util.Constants.OBSERV;

@Service
public class ProdServiceImpl implements IProductoService{

	@Autowired
	ProductoDao productDao;
	
	/**
	 * <p> Metodo para obtener la lista de Productos a retornar en los Endpoints
	 * Se obtendra la entidad de persistencia TProducto y se homologara a la entidad de los controllers Producto
	 * </p>
	 * @author Alonso
	 * @param ID
	 * @return Lista de Productos
	 */
	@Override
	public List<Producto> findAllProducts() {
//		List<Producto> list = new ArrayList<>();
//		productDao.findAll().forEach(x -> list.add(setProducto(x))); 
//		return list;
		
		List<TProducto> list = productDao.findByEstado(true);
		List<Producto> users = new ArrayList<Producto>();
		list.stream().forEach(x -> users.add(setProducto(x)));
		return users;
	}

	/**
	 * <p> Metodo para registrar la entidad Producto en la tabla T_Producto
	 * </p>
	 * @author Alonso
	 * @param Objeto Producto
	 * @return Entidad Producto registrada en BD
	 */
	@Override
	public Producto createProduct(Producto prod) {
		TProducto bean= new TProducto();
		bean.setNombre(prod.getNombre());
		bean.setPrecio(new BigDecimal(prod.getPrecio()));
		bean.setEstado(true);
		bean.setAudit_dfecope(null);
		bean.setAudit_vobs(OBSERV.CREATE);
		bean.setAudit_vuser("ROOT");
		bean.setAudit_dfecre(LocalDateTime.now());
		
		bean = productDao.save(bean);
		return setProducto(bean);
	}

	/**
	 * <p> Metodo para buscar por id la entidad TPRODUCTO con estado Activo (tabla t_producto)
	 * </p>
	 * @author Alonso
	 * @param Long ID
	 * @return En caso de encontrar se retorna la entidad Producto en caso contrario se retorna null
	 */
	@Override
	public Producto findProduct(Long id) {
		Optional<TProducto> prod= productDao.findProdById(id,true);
		if(prod.isPresent()) {
			return setProducto(prod.get());
		}else {
			return null;
		}
	}

	/**
	 * <p> Metodo para editar el registro de la entidad TProducto
	 * </p>
	 * @author Alonso
	 * @param Id, Entidad Producto, Entidad TProducto
	 * @return Se retorna la entidad Producto actualizada
	 */
	@Override
	public Producto editProduct(Long id, Producto producto, TProducto bean) {
		bean.setIdProducto(id);
		bean.setNombre(producto.getNombre());
		bean.setPrecio(new BigDecimal(producto.getPrecio()));
		//actualizamos la fecha de auditoria de actualizacion
		bean.setAudit_dfecope(LocalDateTime.now());
		bean.setAudit_vobs(OBSERV.UPDATE);
		bean=productDao.save(bean);
		
		return setProducto(bean);
	}

	/**
	 * <p> Metodo para buscar por ID la entidad nativa Tproducto mapeada con la tabla T_Producto
	 * </p>
	 * @author Alonso
	 * @param ID
	 * @return Optional con el objeto TProducto
	 */
	@Override
	public Optional<TProducto> findTProducto(Long id) {
		return productDao.findProdById(id, true);
	}

	
	/**
	 * <p> Metodo para eliminar(deshabilitar) el registro de la entidad TPRODUCTO
	 * </p>
	 * @author Alonso
	 * @param Entidad TPRODUCTO
	 * @return
	 */
	@Override
	public TProducto deleteProduct(TProducto prod) {
		//deshabilitando el estado
		prod.setAudit_dfecope(LocalDateTime.now());
		prod.setEstado(false);
		prod.setAudit_vobs(OBSERV.DELETE);
		prod = productDao.save(prod);
		return prod;
	}

	private Producto setProducto(TProducto x) {
		Producto p = new Producto();
		p.setIdProducto(x.getIdProducto());
		p.setNombre(x.getNombre());
		p.setPrecio(x.getPrecio().doubleValue());
		return p;
	}
	
}
