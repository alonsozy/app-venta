package com.app.store.entity;

import lombok.Getter;
import lombok.Setter;

public class VentaDetalle {

	@Getter @Setter
	private long idDetalleVenta;
	
	@Getter @Setter
	private long idVenta;
	
	@Getter @Setter
	private long idProducto;
	
	
}
