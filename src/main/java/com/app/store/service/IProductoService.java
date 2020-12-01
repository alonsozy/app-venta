package com.app.store.service;

import java.util.List;
import java.util.Optional;

import com.app.store.dto.TProducto;
import com.app.store.entity.Producto;

public interface IProductoService{

	public List<Producto> findAllProducts();

	public Producto createProduct(Producto user);

	public Producto findProduct(Long id);

	public Producto editProduct(Long id, Producto producto, TProducto bean);

	public Optional<TProducto> findTProducto(Long id);

	public TProducto deleteProduct(TProducto user);

}
