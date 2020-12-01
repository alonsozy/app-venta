package com.app.store.service;

import java.util.List;

import com.app.store.entity.Venta;

public interface IVentaService {
	
	public List<Venta> findAllSales();

	public Venta createSale(Venta user);

	public Venta findSale(Long id);

}
