package com.app.store.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Producto implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 3157972905486931039L;

	@Getter @Setter
	private long idProducto;
	
	@Getter @Setter
	private String nombre;
	
	@Getter @Setter
	private double precio;
	
	
}
