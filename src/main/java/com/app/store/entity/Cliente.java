package com.app.store.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6547559453543113967L;

	@Getter @Setter
	private long idCliente;
	
	@Getter @Setter
	private String nombre;
	
	@Getter @Setter
	private String apellido;
	
	@Getter @Setter
	private String dni;
	
	@Getter @Setter
	private String telefono;
	
	@Getter @Setter
	private String email;
	
	
	
}
