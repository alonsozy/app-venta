package com.app.store.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Venta  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -179388803532502976L;
	
	@Getter @Setter
	private long idVenta;
	
	@Getter @Setter
	private long idCliente;
	
	@Getter @Setter
	private LocalDateTime fecha;
	
	@Getter @Setter
	private List<VentaDetalle> detalle;
	
}
